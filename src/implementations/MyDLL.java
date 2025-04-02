package implementations;

import java.util.Arrays;
import utilities.Iterator;
import utilities.ListADT;

public class MyDLL<E> implements ListADT<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6091317822735337054L;
	private MyDLLNode<E> head;
	private MyDLLNode<E> tail;

	public MyDLL() {
		head = tail = null;
	}

	@Override
	public MyDLLIterator<E> iterator() {
		return new MyDLLIterator<E>(head);
	}

	@Override
	public int size() {
		int counter = 0;
		MyDLLIterator<E> iter = iterator();

		while (iter.hasNext()) {
			iter.next();
			counter++;
		}

		return counter;
	}

	@Override
	public void clear() {
		head = tail = null;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}

		if (toAdd == null) {
			throw new NullPointerException();
		}

		MyDLLNode<E> insertedNode = new MyDLLNode<E>(toAdd);
		if (index == 0) {
			if (head == null) {
				head = tail = insertedNode;
			} else {
				insertedNode.setNext(head);
				head.setPrev(insertedNode);
				head = insertedNode;
			}
		} else if (index == size()) {
			tail.setNext(insertedNode);
			insertedNode.setPrev(tail);
			tail = insertedNode;
		} else {
			int counter = 0;
			MyDLLIterator<E> iter = iterator();

			while (counter < index - 1) {
				iter.next();
				counter++;
			}

			MyDLLNode<E> currentNode = iter.getCurrent();
			MyDLLNode<E> nextNode = currentNode.getNext();
			insertedNode.setNext(currentNode.getNext());
			insertedNode.setPrev(currentNode);
			currentNode.setNext(insertedNode);
			nextNode.setPrev(insertedNode);
		}
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}

		MyDLLNode<E> insertedNode = new MyDLLNode<E>(toAdd);
		if (head == null) {
			head = tail = insertedNode;
		} else {
			tail.setNext(insertedNode);
			insertedNode.setPrev(tail);
			tail = insertedNode;
		}
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}

		Iterator<? extends E> iter = toAdd.iterator();
		while (iter.hasNext()) {
			add(iter.next());
		}

		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		int counter = 0;
		MyDLLIterator<E> iter = iterator();
		while (counter < index) {
			iter.next();
			counter++;
		}
		return iter.getCurrent().getElement();
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		E removedNode;

		if (index == 0) {
			removedNode = head.getElement();
			head = head.getNext();
		} else if (index == size() - 1) {
			removedNode = tail.getElement();
			tail = tail.getPrev();
			tail.setNext(null);
		} else {
			int counter = 0;
			MyDLLIterator<E> iter = iterator();

			while (counter < index) {
				iter.next();
				counter++;
			}

			removedNode = iter.getCurrent().getElement();
			MyDLLNode<E> currentNode = iter.getCurrent();
			MyDLLNode<E> nextNode = currentNode.getNext();
			MyDLLNode<E> prevNode = currentNode.getPrev();
			nextNode.setPrev(prevNode);
			prevNode.setNext(nextNode);
		}
		return removedNode;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null) {
			throw new NullPointerException();
		}

		E removedNode;
		MyDLLIterator<E> iter = iterator();
		while (iter.hasNext()) {
			if (iter.getCurrent() == head && head.getElement() == toRemove) {
				removedNode = head.getElement();
				head = head.getNext();
				return removedNode;
			} else if (iter.getCurrent() == tail && tail.getElement() == toRemove) {
				removedNode = tail.getElement();
				tail = tail.getPrev();
				tail.setNext(null);
				return removedNode;
			} else if (iter.getCurrent().getElement() == toRemove) {
				removedNode = iter.getCurrent().getElement();
				MyDLLNode<E> currentNode = iter.getCurrent();
				MyDLLNode<E> nextNode = currentNode.getNext();
				MyDLLNode<E> prevNode = currentNode.getPrev();
				nextNode.setPrev(prevNode);
				prevNode.setNext(nextNode);
				return removedNode;
			}
		}
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		if (toChange == null) {
			throw new NullPointerException();
		}

		E oldElement;
		int counter = 0;
		MyDLLIterator<E> iter = iterator();
		while (counter < index) {
			iter.next();
			counter++;
		}

		oldElement = iter.getCurrent().getElement();
		MyDLLNode<E> currentNode = iter.getCurrent();
		currentNode.setElement(toChange);
		return oldElement;
	}

	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}

		MyDLLIterator<E> iter = iterator();
		while (iter.hasNext()) {
			if (iter.getCurrent().getElement() == toFind) {
				return true;
			}
		}
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null) {
			throw new NullPointerException();
		}

		E[] tempArray = null;
		if (toHold.length < size()) {
			tempArray = Arrays.copyOf(toHold, size());
		} else {
			tempArray = toHold;
		}

		for (int i = 0; i < size(); i++) {
			tempArray[i] = get(i);
		}

		if (tempArray.length > size()) {
			tempArray[size()] = null;
		}

		return tempArray;
	}

	@Override
	public Object[] toArray() {
		Object[] tempArray = new Object[size()];
		
		for (int i = 0; i < size(); i++) {
			tempArray[i] = get(i);
		}
		
		return tempArray;
	}

}
