package utilities;

import exceptions.*;

public interface StackADT<E> {
	/**
	 * Constructor method to make a Stack object
	 * 
	 * Precondition: none
	 * Postcondition: A Stack object is created and its initial value is set to the provided
	 * size in the parameter.
	 * 
	 * @param size The size of the new stack
	 */
	public void create(int size);
	
	/**
	 * Mutator method that adds a new element to the top of the stack.
	 * 
	 * Precondition: Stack object exists and a non-null value was provided to the parameters.
	 * Postcondition: Element is successfully added to the top of the stack.
	 * 
	 * @param element Element to be added
	 * @return boolean If element was successfully added
	 * 
	 * @throws ElementCannotBeNullException is thrown if provided element is null
	 */

	public boolean push(E element) throws ElementCannotBeNullException;
	
	/**
	 * Mutator method that removes the topmost element.
	 * 
	 * Precondition: Stack object exists.
	 * Postcondition: The topmost element is removed from the stack
	 * 
	 * @return E the item that was removed
	 * 
	 * @throws StackEmptyException is thrown if Stack is empty
	 */

	public E pop() throws StackEmptyException;
	
	/**
	 * Accessor method that retrieves the value of the topmost element.
	 * 
	 * Precondition: Stack object exists
	 * Postcondition: The topmost element is accessed and return from the stack.
	 * 
	 * @return E the element that was retrieved
	 * 
	 * @throws StackEmptyException is thrown if Stack is empty.
	 */

	public E peek() throws StackEmptyException;
	
	/**
	 * Transformer method that compares two Stack objects
	 * 
	 * Precondition: At least two stack objects exists
	 * Postcondition: A boolean is returned if two Stack objects are the same, i.e, same length and in same order.
	 * 
	 * @param that the Stack object the current Stack is being compared to
	 * @return boolean if the two Stack objects are the same.
	 * 
	 * @throws InvalidStackCompareException is thrown if the Stack being compared to is invalid, i.e, does not exist.
	 */

	public boolean equals(StackADT<E> that) throws InvalidStackCompareException;
	
	/**
	 * Transformer method that returns an iterator over the items contained in the Stack.
	 * 
	 * Precondition: Stack object exists.
	 * Postcondition: Iterator object is returned that allows for iteration over the items
	 * 
	 * @return Iterator object that allows iteration.
	 */

	public Iterator<E> iterator();
	
	/**
	 * Mutator method that converts the Stack to an array
	 * 
	 * Precondition: Stack object exists
	 * Postcondition: Stack is converted to an array.
	 * 
	 * @return Object array to hold the Stack elements with generic data type.
	 */
	public Object[] toArray();
	
	/**
	 * Mutator method that copies elements from a Stack to an existing array.
	 * 
	 * Precondition: Stack object exists and a valid array is provided.
	 * Postcondition: Stack is successfully copied
	 * 
	 * @param copy designated array that takes in the copied elements from Stack
	 * @return E[] array to hold the Stack elements with specific data type.
	 */

	public E[] toArray(E[] copy);
	
	/**
	 * Accessor method that searches for the element provided.
	 * 
	 * Precondition: Stack object exists and a valid element is provided.
	 * Postcondition: Element is successfully found are returned.
	 * 
	 * @param obj object to be searched
	 * @return the position of the object (starting from 1)
	 */

	public int search(E obj);
	
	/**
	 * Accessor method that returns if provided element exists in the Stack
	 * 
	 * Precondition: Stack object exists and valid object is provided.
	 * Postcondition: A boolean is returned if object exists or not in the element
	 * 
	 * @param obj object to be searched
	 * @return boolean value if object exists or not
	 */

	public boolean contains(E obj);
	
	/**
	 * Accessor method that retrieves the size of the Stack.
	 * 
	 * Precondition: Stack object exists.
	 * Postcondition: The size of the Stack is retrieved.
	 * 
	 * @return the size of the Stack
	 */

	public int size();
	
	/**
	 * Transformer method that returns if Stack is empty or not.
	 * 
	 * Precondition: Stack object exists.
	 * Postcondition: A boolean is returned if Stack is empty or not
	 * 
	 * @return boolean value if object exists or not
	 */

	public boolean isEmpty();
	
	/**
	 * Mutator method that empties the stack
	 * 
	 * Precondition: Stack object exists.
	 * Postcondition: Stack is emptied.
	 */

	public void clear();

}
