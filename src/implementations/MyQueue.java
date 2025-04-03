package implementations;

<<<<<<< HEAD
import utilities.*;
import exceptions.*;
=======
import utilities.QueueADT;
import exceptions.QueueEmptyException;
import implementations.MyDLL;
import java.util.NoSuchElementException;
>>>>>>> b31771653ce3f59cefefd3a78df7e80986f59084

public class MyQueue<E> implements QueueADT<E> {
    private MyDLL<E> queueStorage;

    public MyQueue() {
<<<<<<< HEAD
        queueStorage = new MyDLL<E>();
    }

    @Override
    public void enqueue(E element) throws ValueCannotBeNullException {
        if (element == null) {
            throw new ValueCannotBeNullException("Cannot enqueue null element");
        }
        queueStorage.add(element);
=======
        queueStorage = new MyDLL<>();
    }

    @Override
    public void enqueue(E item) {
        if (item == null) {
            throw new NullPointerException("Cannot enqueue null element");
        }
        queueStorage.add(item);
>>>>>>> b31771653ce3f59cefefd3a78df7e80986f59084
    }

    @Override
    public E dequeue() throws QueueEmptyException {
        if (isEmpty()) {
<<<<<<< HEAD
            throw new QueueEmptyException("Cannot dequeue from empty queue");
=======
            throw new QueueEmptyException("Queue is empty");
>>>>>>> b31771653ce3f59cefefd3a78df7e80986f59084
        }
        return queueStorage.remove(0);
    }

    @Override
    public E peek() throws QueueEmptyException {
        if (isEmpty()) {
<<<<<<< HEAD
            throw new QueueEmptyException("Cannot peek empty queue");
=======
            throw new QueueEmptyException("Queue is empty");
>>>>>>> b31771653ce3f59cefefd3a78df7e80986f59084
        }
        return queueStorage.get(0);
    }

    @Override
<<<<<<< HEAD
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
=======
    public void clear() {
        queueStorage.clear();
    }

    @Override
    public boolean isEmpty() {
        return queueStorage.isEmpty();
>>>>>>> b31771653ce3f59cefefd3a78df7e80986f59084
    }

    @Override
    public Object[] toArray() {
        return queueStorage.toArray();
    }

    @Override
<<<<<<< HEAD
    public E[] toArray(E[] holder) {
=======
    public E[] toArray(E[] holder) throws NullPointerException {
>>>>>>> b31771653ce3f59cefefd3a78df7e80986f59084
        return queueStorage.toArray(holder);
    }

    @Override
<<<<<<< HEAD
    public boolean isFull() {
        return false; // Linked list implementation is never full
=======
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
>>>>>>> b31771653ce3f59cefefd3a78df7e80986f59084
    }

    @Override
    public int size() {
        return queueStorage.size();
    }
<<<<<<< HEAD

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
=======
>>>>>>> b31771653ce3f59cefefd3a78df7e80986f59084
}