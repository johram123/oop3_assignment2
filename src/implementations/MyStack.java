package implementations;

import utilities.*;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<E> implements StackADT<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5032167990915865755L;
	private MyArrayList<E> stackStorage;

	public MyStack() {
		stackStorage = new MyArrayList<E>();
	}

	@Override
	public void push(E element) throws NullPointerException {
		stackStorage.add(element);
	}

	@Override
	public E pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return stackStorage.remove(stackStorage.size() - 1);
	}

	@Override
	public E peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return stackStorage.get(stackStorage.size() - 1);
	}

	@Override
	public boolean equals(StackADT<E> that) {

		if (this.size() != that.size()) {
			return false;
		}

		Iterator<E> thisIter = this.iterator();
		Iterator<E> thatIter = that.iterator();

		while (thisIter.hasNext() && thatIter.hasNext()) {
			if (!thisIter.next().equals(thatIter.next())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return new StackIterator<E>(this, stackStorage);
	}

	@Override
	public Object[] toArray() {
		Object[] tempArray = new Object[stackStorage.size()];
		Object[] returnedArray = stackStorage.toArray();
		for (int i = 0; i < returnedArray.length; i++) {
			tempArray[i] = returnedArray[returnedArray.length - 1 - i];
		}
		return tempArray;
	}

	@Override
	public E[] toArray(E[] holder) {
		E[] tempArray = null;
		if (holder.length < size()) {
			tempArray = Arrays.copyOf(holder, size());
		} else {
			tempArray = holder;
		}
		
		E[] returnedArray = stackStorage.toArray(holder);
		Iterator<E> iter = this.iterator();
		for (int i = 0; i < returnedArray.length; i++) {
			tempArray[i] = iter.next();
		}
		return tempArray;
	}

	@Override
	public int search(E element) {
		int counter = 1;
		Iterator<E> iter = this.iterator();
		while (iter.hasNext()) {
			if (iter.next().equals(element)) {
				return counter;
			}
			counter++;
		}
		return -1;
	}

	@Override
	public boolean contains(E element) {
		return stackStorage.contains(element);
	}

	@Override
	public int size() {
		return stackStorage.size();
	}

	@Override
	public boolean isEmpty() {
		return stackStorage.isEmpty();
	}

	@Override
	public void clear() {
		stackStorage.clear();
	}

	@Override
	public boolean stackOverflow() {
		// TODO Auto-generated method stub
		return false;
	}
}
