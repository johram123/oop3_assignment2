package implementations;

import utilities.StackADT;
import exceptions.InvalidStackCompareException;
import exceptions.StackEmptyException;
import implementations.MyArrayList;
import java.util.NoSuchElementException;

public class MyStack<E> implements StackADT<E> {
    private MyArrayList<E> stackStorage;

    public MyStack() {
        stackStorage = new MyArrayList<>();
    }

    @Override
    public void push(E item) {
        if (item == null) {
            throw new NullPointerException("Cannot push null element");
        }
        stackStorage.add(item);
    }

    @Override
    public E pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        return stackStorage.remove(stackStorage.size() - 1);
    }

    @Override
    public E peek() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        return stackStorage.get(stackStorage.size() - 1);
    }

    @Override
    public void clear() {
        stackStorage.clear();
    }

    @Override
    public boolean isEmpty() {
        return stackStorage.isEmpty();
    }

    @Override
    public Object[] toArray() {
        return stackStorage.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return stackStorage.toArray(holder);
    }

    @Override
    public boolean contains(E item) throws NullPointerException {
        return stackStorage.contains(item);
    }

    @Override
    public int search(E item) {
        if (item == null) {
            return -1;
        }
        for (int i = stackStorage.size() - 1; i >= 0; i--) {
            if (item.equals(stackStorage.get(i))) {
                return stackStorage.size() - i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return stackStorage.size();
    }

    @Override
    public Iterator<E> iterator() {
        return stackStorage.iterator();
    }

	@Override
	public void create(int size) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean equals(StackADT<E> that) throws InvalidStackCompareException {
		// TODO Auto-generated method stub
		return false;
	}
}