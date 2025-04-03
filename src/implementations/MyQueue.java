package implementations;

import utilities.*;
import exceptions.*;

public class MyQueue<E> implements QueueADT<E> {
    private MyDLL<E> queueStorage;

    public MyQueue() {
        queueStorage = new MyDLL<E>();
    }

    @Override
    public void enqueue(E element) throws ValueCannotBeNullException {
        if (element == null) {
            throw new ValueCannotBeNullException("Cannot enqueue null element");
        }
        queueStorage.add(element);
    }

    @Override
    public E dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Cannot dequeue from empty queue");
        }
        return queueStorage.remove(0);
    }

    @Override
    public E peek() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Cannot peek empty queue");
        }
        return queueStorage.get(0);
    }

    @Override
    public boolean equals(QueueADT<E> that) throws InvalidQueueException {
        if (that == null) {
            throw new InvalidQueueException("Cannot compare with null queue");
        }
        
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
    public E dequeueAll() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is already empty");
        }
        E firstElement = peek();
        queueStorage.clear();
        return firstElement;
    }

    @Override
    public boolean isEmpty() {
        return queueStorage.isEmpty();
    }
}
