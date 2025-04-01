package utilities;

import exceptions.*;
public interface QueueADT<E>{
	
	/**
	 * Enqueue adds an element to the end of the queue
	 * 
	 * @precondition queue must exist
	 * @postcondition element is successfully added into the queue
	 * 
	 * @param element element that will be added
	 * @throws ValueCannotBeNullException the element value cannot be a null value
	 */
	
	public void enqueue(E element) throws ValueCannotBeNullException;
	
	/**
	 * Dequeue removes the first element from the queue
	 * 
	 * @precondition element must exists in a queue
	 * @postcondition removes the first element from the queue
	 * 
	 * @return a new queue with the first element removed
	 * @throws QueueEmptyException if the queue is empty  
	 */
	
	public E dequeue() throws QueueEmptyException;
	
	/**
	 * Peek allows you to access the first element without removing
	 * 
	 * @precondition element must exists in a queue
	 * @postcondition retrieves the first element
	 * 
	 * @return first element gets returned
	 * @throws QueueEmptyException cannot access an element if the queue is empty
	 */
	
	public E peek() throws QueueEmptyException;
	
	/**
	 * Equals compares 2 queue's and checks if the queue are the same length size and order
	 * 
	 * @precondition 2 queue must exists
	 * @postcondition gives a boolean value to indicate the result of comparison
	 * 
	 * @param that that the queue is to be compared with
	 * @return returns true if both queue are exactly same, returns false if queue are different
	 * @throws InvalidQueueException if the provided queue is invalid/ if one exist and the other does not exist 
	 */
	
	public boolean equals(MyQueueADT<E> that) throws InvalidQueueException;
	
	/**
	 * Iterator iterates over the elements in the queue
	 * 
	 * @precondition queue must exists
	 * @postcondition gain access to the next element
	 * 
	 * @return an iterator over the elements contained in the queue
	 */
	
	public Iterator<E> iterator();
	
	/**
	 * toArray turns all elements in the queue to an array
	 * 
	 * @precondition queue must exists
	 * @postcondition gives an array containing all elements in the queue
	 * 
	 * @return Array that completely replicates and converts the queue into an array. Same order and size
	 */
	
	public Object[] toArray();
	
	/**
	 * Copy the elements of the queue into provided array
	 * 
	 * @precondition queue must exists
	 * @postcondition gives an array with the same elements of the queue
	 * 
	 * @param copy copy the queue element into the array
	 * @return an array containing all elements of the queue
	 */
	
	public E[] toArray(E[] copy);

	/**
	 * isFull checks if the queue is full
	 * 
	 * @precondition queue must exist
	 * @postcondition gives an boolean value depending on the result
	 * 
	 * @return True if the queue is full, False if not full
	 */
	
	public boolean isFull();
	
	/**
	 * Sizes checks the size of the queue
	 * 
	 * @precondition queue must exist
	 * @postcondition int value must be given 
	 * 
	 * @return an int value depending on the size of the queue is returned
	 */
	
	
	public int size();
	
	/**
	 * dequeueAll removes all the elements in the queue
	 * 
	 * @precondition the queue must exists and is not empty
	 * @postcondition queue must be empty
	 * 
	 * @return a empty queue
	 * @throws QueueEmptyException if the queue is already empty
	 */

	public E dequeueAll() throws QueueEmptyException;
	
	
}