package appDomain;

import implementations.*;

import java.io.File;
import java.util.Scanner;

import exceptions.EmptyQueueException;
import java.io.FileNotFoundException;
import java.util.EmptyStackException;

/**
 * Main driver class for parsing an XML file line by line and checking tag structure.
 * It uses a stack to track start tags, and two queues to track unmatched tags.
 * 
 * @author Shawn, Johram, Lloyd
 */

public class XmlParserDriver {

	public static void main(String[] args) {
		MyStack<Tag> stack = new MyStack<>();
		MyQueue<Tag> errorQ = new MyQueue<>();
		MyQueue<Tag> extrasQ = new MyQueue<>();
		try {
			File file = new File(args[0]);
			System.out.println(file);
			Scanner readFile = new Scanner(file);

			int lineNumber = 1;

			while (readFile.hasNext()) {
				String line = readFile.nextLine().trim();
				Methods.processTagFromLine(line, lineNumber, stack, errorQ, extrasQ);
				lineNumber++;
			}
			if (stack.isEmpty() && errorQ.isEmpty() && extrasQ.isEmpty()) {
				System.out.println("XML document is constructed properly.");
			}
			readFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (EmptyStackException e) {
			e.printStackTrace();
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		} finally {
			try {
				CleanUp cleanup = new CleanUp(stack, errorQ, extrasQ);
				cleanup.processCleanup();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
		}
	}
}
