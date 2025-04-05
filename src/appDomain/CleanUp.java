package appDomain;

import exceptions.EmptyQueueException;
import implementations.*;

/**
 * Performs cleanup operations after XML parsing is complete.
 * Moves any unclosed start tags from the stack to the error queue,
 * then compares start and end tag queues to report mismatches.
 */
public class CleanUp {

	MyQueue<Tag> errorQ;
	MyQueue<Tag> extrasQ;
	MyStack<Tag> stack;

	/**
	 * Constructs a CleanUp instance.
	 *
	 * @param stack the stack of unmatched start tags
	 * @param errorQ the queue for start tag errors
	 * @param extrasQ the queue for end tag errors
	 */
	public CleanUp(MyStack<Tag> stack, MyQueue<Tag> errorQ, MyQueue<Tag> extrasQ) {
		this.stack = stack;
		this.errorQ = errorQ;
		this.extrasQ = extrasQ;
	}

	/**
	 * Performs final error reconciliation by moving unclosed tags to the error queue,
	 * and comparing tag pairs to report mismatches.
	 */
	public void processCleanup() throws EmptyQueueException {
		moveUnclosedTagsToErrorQ();
		compareQ();
	}

	/**
	 * Moves any remaining unmatched start tags from the stack to the error queue.
	 */
	private void moveUnclosedTagsToErrorQ() {
		while (!stack.isEmpty()) {
			errorQ.enqueue(stack.pop());
		}
	}

	/**
	 * Compares tags from the error queue and extras queue.
	 * If the tag names do not match, the error queue tag is reported.
	 * Matching tags are removed from both queues.
	 */
	private void compareQ() throws EmptyQueueException {
		while (!errorQ.isEmpty() || !extrasQ.isEmpty()) {
			if ((errorQ.isEmpty() && !extrasQ.isEmpty()) || (!errorQ.isEmpty() && extrasQ.isEmpty())) {
				reportErrors();
				break;
			}

			if (!errorQ.peek().tag.equals(extrasQ.peek().tag)) {
				errorQ.dequeue();
			} else {
				errorQ.dequeue();
				extrasQ.dequeue();
			}
		}
	}

	/**
	 * Reports all remaining tags in the extras and error queues as unmatched.
	 */
	private void reportErrors() throws EmptyQueueException {
		while (!extrasQ.isEmpty()) {
			System.out.println("Error at line: " + extrasQ.peek().lineNumber + " </" + extrasQ.peek().tag
					+ "> is not constructed correctly");
			extrasQ.dequeue();
		}
		while (!errorQ.isEmpty()) {
			System.out.println("Error at line: "+ errorQ.peek().lineNumber+ " <" + errorQ.peek().tag + "> is not constructed correctly");
			errorQ.dequeue();
		}
	}
}
