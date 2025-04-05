package appDomain;

import exceptions.EmptyQueueException;
import implementations.MyQueue;
import implementations.MyStack;

/**
 * Utility class that provides methods to process XML tags line by line
 * and validate their proper construction using a stack and queues.
 */
public class Methods {

	/**
	 * Tracks and reports mismatched tags between a matching start and end tag.
	 * Tags above the matched tag in the stack are considered incorrect and added to errorQ.
	 *
	 * @param position   The position of the matching start tag in the stack (1-based).
	 * @param trackedTag The end tag being processed.
	 * @param stack      Stack of unclosed start tags.
	 * @param errorQ     Queue to hold start tags that are mismatched.
	 * @param extrasQ    Queue to hold unmatched end tags.
	 */
	public static void trackPosition(int position, Tag trackedTag, MyStack<Tag> stack, MyQueue<Tag> errorQ,
			MyQueue<Tag> extrasQ) {
		if (position != -1) {
			for (int k = 1; k <= position; k++) {
				Tag current = stack.pop();
				if (k != position) {
					System.out.println("daError at line " + current.lineNumber + ": <" + current.tag
							+ "> is not constructed correctly");
					errorQ.enqueue(current);
				}
			}
			
		} else {
			extrasQ.enqueue(trackedTag);
		}
		
	}

	/**
	 * Parses a single line of XML and pushes/pops tags to and from the stack based on their type.
	 * Properly matched tags are resolved; unmatched ones are tracked in errorQ or extrasQ.
	 *
	 * @param line       The line of XML text to parse.
	 * @param lineNumber The line number in the source file.
	 * @param stack      Stack used to track unmatched start tags.
	 * @param errorQ     Queue used to store mismatched start tags.
	 * @param extrasQ    Queue used to store unmatched end tags.
	 * @throws EmptyQueueException if a dequeue operation is attempted on an empty queue.
	 */
	public static void processTagFromLine(String line, int lineNumber, MyStack<Tag> stack, MyQueue<Tag> errorQ,
			MyQueue<Tag> extrasQ) throws EmptyQueueException {
		if (line.startsWith("<?xml"))
			return;

		int i = 0;
		String formattedTag;
		Tag trackedTag;

		while (i < line.length()) {
			if (line.charAt(i) == '<') {
				int j = line.indexOf('>', i);
				if (j != -1) {
					String tag = line.substring(i, j + 1);
					if (tag.startsWith("<") && !tag.startsWith("</") && !tag.endsWith("/>")) {
						formattedTag = extractTagName(tag);
						trackedTag = new Tag(formattedTag, lineNumber);
						stack.push(trackedTag);
					} else if (tag.startsWith("</")) {
						formattedTag = extractTagName(tag);
						trackedTag = new Tag(formattedTag, lineNumber);

						if (!stack.isEmpty() && trackedTag.tag.equals(stack.peek().tag)) {
							stack.pop();
						} else if (!errorQ.isEmpty() && trackedTag.tag.equals(errorQ.peek().tag)) {
							errorQ.dequeue();
						} else if (stack.isEmpty()) {
							errorQ.enqueue(trackedTag);
						} else {
							int position = stack.search(trackedTag);
							trackPosition(position, trackedTag, stack, errorQ, extrasQ);
						}
					}
					i = j + 1;
				} else {
					break;
				}
			} else {
				i++;
			}
		}
	}

	/**
	 * Helper method that strips XML brackets and attributes, returning only the tag name.
	 *
	 * @param fullTag The full tag string, including brackets and attributes.
	 * @return The cleaned tag name.
	 */
	private static String extractTagName(String fullTag) {
		return fullTag.replaceAll("[<>/]+", "").trim().split(" ")[0];
	}
}
