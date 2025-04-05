package implementations;

/**
 * A node in a doubly linked list, containing a reference to an element,
 * a reference to the next node, and a reference to the previous node.
 *
 * @param <E> the type of element stored in the node
 */
public class MyDLLNode<E>
{
	private E element;
	private MyDLLNode<E> next;
	private MyDLLNode<E> prev;

	/**
	 * Returns the element stored in this node.
	 *
	 * @return the element stored
	 */
	public E getElement() {
		return element;
	}

	/**
	 * Sets the element to be stored in this node.
	 *
	 * @param element the element to store
	 */
	public void setElement(E element) {
		this.element = element;
	}

	/**
	 * Returns the next node in the list.
	 *
	 * @return the next node
	 */
	public MyDLLNode<E> getNext() {
		return next;
	}

	/**
	 * Sets the next node in the list.
	 *
	 * @param next the node to set as next
	 */
	public void setNext(MyDLLNode<E> next) {
		this.next = next;
	}

	/**
	 * Returns the previous node in the list.
	 *
	 * @return the previous node
	 */
	public MyDLLNode<E> getPrev() {
		return prev;
	}

	/**
	 * Sets the previous node in the list.
	 *
	 * @param prev the node to set as previous
	 */
	public void setPrev(MyDLLNode<E> prev) {
		this.prev = prev;
	}

	/**
	 * Constructs a node with the given element and null links.
	 *
	 * @param e the element to store in the node
	 */
	public MyDLLNode(E e) {
		element = e;
		next = null;
		prev = null;
	}
}
