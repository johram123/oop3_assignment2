package implementations;

import utilities.*;
import exceptions.*;

public class MyQueue<E> implements QueueADT<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 426764518466227839L;
	private MyDLL<E> queueStorage;

	public MyQueue() {
		queueStorage = new MyDLL<E>();
	}

	@Override
	public void enqueue(E element) throws NullPointerException {
		queueStorage.add(element);
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return queueStorage.remove(0);
	}

	@Override
	public E peek() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return queueStorage.get(0);
	}

	@Override
	public boolean equals(QueueADT<E> that) {

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
		return queueStorage.iterator();
	}

	@Override
	public Object[] toArray() {
		return queueStorage.toArray();
	}

	@Override
	public E[] toArray(E[] holder) {
		return queueStorage.toArray(holder);
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public int size() {
		return queueStorage.size();
	}

	@Override
	public void dequeueAll() {
		queueStorage.clear();
	}

	@Override
	public boolean isEmpty() {
		return queueStorage.isEmpty();
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		return queueStorage.contains(toFind);
	}

	@Override
	public int search(E toFind) {
		int counter = 1;
		Iterator<E> iter = iterator();
		while (iter.hasNext()) {
			if (iter.next().equals(toFind)) {
				return counter;
			}
			counter++;
		}
		return -1;
	}
}
