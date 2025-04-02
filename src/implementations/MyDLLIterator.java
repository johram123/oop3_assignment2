package implementations;

import utilities.Iterator;
import java.util.NoSuchElementException;

public class MyDLLIterator<E> implements Iterator<E> {
	private MyDLLNode<E> current;

	public MyDLLIterator(MyDLLNode<E> head) {
		current = head;
	}
	
	public MyDLLNode<E> getCurrent() {
		return current;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public E next() throws NoSuchElementException {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}	
		E temp = current.getElement();
		current = current.getNext();
		return temp;
	}

}
