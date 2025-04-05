package implementations;

import utilities.Iterator;
import java.util.NoSuchElementException;

public class StackIterator<E> implements Iterator<E> {
	private int index;
	private MyArrayList<E> stackStorage;

	public StackIterator(MyStack<E> stack, MyArrayList<E> stackStorage) {
		index = stack.size() - 1;
		this.stackStorage = stackStorage;
	}

	@Override
	public boolean hasNext() {
		return index >= 0;
	}

	@Override
	public E next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return stackStorage.get(index--);
	}
}
