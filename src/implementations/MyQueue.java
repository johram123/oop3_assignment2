package implementations;

import utilities.QueueADT;
import exceptions.QueueEmptyException;
import implementations.MyDLL;
import java.util.NoSuchElementException;

public class MyQueue<E> implements QueueADT<E> {
    private MyDLL<E> queueStorage;

    public MyQueue() {
        queueStorage = new MyDLL<>();
    }

    @Override
    public void enqueue(E item) {
        if (item == null) {
            throw new NullPointerException("Cannot enqueue null element");
        }
        queueStorage.add(item);
    }

    @Override
    public E dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }
        return queueStorage.remove(0);
    }

    @Override
    public E peek() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }
        return queueStorage.get(0);
    }

    @Override
    public void clear() {
        queueStorage.clear();
    }

    @Override
    public boolean isEmpty() {
        return queueStorage.isEmpty();
    }

    @Override
    public Object[] toArray() {
        return queueStorage.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return queueStorage.toArray(holder);
    }

    @Override
    public boolean contains(E item) throws NullPointerException {
        return queueStorage.contains(item);
    }

    @Override
    public Iterator<E> iterator() {
        return queueStorage.iterator();
    }

    @Override
    public boolean equals(QueueADT<E> other) {
        if (other == null) return false;
        if (this.size() != other.size()) return false;
        
        Iterator<E> thisIter = this.iterator();
        Iterator<E> otherIter = other.iterator();
        
        while (thisIter.hasNext()) {
            if (!thisIter.next().equals(otherIter.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return queueStorage.size();
    }
}