package implementations;

import utilities.*;
import exceptions.*;

public class MyStack<E> implements StackADT<E> {
    private MyArrayList<E> stackStorage;

    public MyStack() {
        stackStorage = new MyArrayList<E>();
    }

    @Override
    public void create(int size) {
        // Workaround since we can't modify MyArrayList
        // Just create new instance (ignore size parameter)
        stackStorage = new MyArrayList<E>();
    }

    @Override
    public boolean push(E element) throws ElementCannotBeNullException {
        if (element == null) {
            throw new ElementCannotBeNullException("Cannot push null element to stack");
        }
        return stackStorage.add(element);
    }

    @Override
    public E pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Cannot pop from empty stack");
        }
        return stackStorage.remove(stackStorage.size() - 1);
    }

    @Override
    public E peek() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Cannot peek empty stack");
        }
        return stackStorage.get(stackStorage.size() - 1);
    }

    @Override
    public boolean equals(StackADT<E> that) throws InvalidStackCompareException {
        if (that == null) {
            throw new InvalidStackCompareException("Cannot compare with null stack");
        }
        
        if (this.size() != that.size()) {
            return false;
        }
        
        // Create array copies for comparison
        Object[] thisArray = this.toArray();
        Object[] thatArray = that.toArray();
        
        for (int i = 0; i < thisArray.length; i++) {
            if (!thisArray[i].equals(thatArray[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {
        private int currentPosition = stackStorage.size();

        @Override
        public boolean hasNext() {
            return currentPosition > 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return stackStorage.get(--currentPosition);
        }
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[stackStorage.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stackStorage.get(stackStorage.size() - 1 - i);
        }
        return result;
    }

    @Override
    public E[] toArray(E[] holder) {
        if (holder.length < stackStorage.size()) {
            holder = (E[]) java.lang.reflect.Array.newInstance(
                holder.getClass().getComponentType(), stackStorage.size());
        }
        
        for (int i = 0; i < stackStorage.size(); i++) {
            holder[i] = stackStorage.get(stackStorage.size() - 1 - i);
        }
        
        if (holder.length > stackStorage.size()) {
            holder[stackStorage.size()] = null;
        }
        
        return holder;
    }

    @Override
    public int search(E element) {
        for (int i = stackStorage.size() - 1; i >= 0; i--) {
            if (stackStorage.get(i).equals(element)) {
                return stackStorage.size() - i; // 1-based position from top
            }
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
}