package implementations;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.ListADT;

public class MyArrayList<E> implements ListADT<E> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4969942981919551657L;
	private static int DEFAULT_SIZE = 10;
	private E[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() 
	{
		array = (E[]) new Object[DEFAULT_SIZE];
		size = 0;
	}

	@Override
	public int size() {
        return size;
    }

	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (toAdd == null)
		{
			throw new NullPointerException("Value you are trying to add cannot be null value");
		}
		
		else if (index > size || index < 0)
		{
			throw new IndexOutOfBoundsException("Position must be in range of 0 and size");
		}
		
		else if (size == array.length)
		{
			resize();
		}
		
		for (int position = size; position > index; position--)
		{
			array[position] = array[position - 1];
		}
		
		array[index] = toAdd;
		size++; 
		return true; 
		
		
	}
	
	
	private void resize() 
	{
		E[] newArray = (E[]) new Object[array.length * 2];  
		System.arraycopy(array, 0, newArray, 0, size);  
		array = newArray;  
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null)
		{
			throw new NullPointerException("Value you are trying to add cannot be null value");
		}
		
		else if (size == array.length)
		{
			resize();
		}
		
		array[size] = toAdd;
		size++; 
		return true; 
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null)
		{
			throw new NullPointerException("Values you are trying to add cannot be null value");
		}
		
		for (Iterator<? extends E> iterator = toAdd.iterator(); iterator.hasNext();) 
		{
			E element = iterator.next();
			add(element);
	    }
	    return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0)
		{
			throw new IndexOutOfBoundsException("Position must be in range of 0 and size");
		}
		
		return array[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index > size || index < 0)
		{
			throw new IndexOutOfBoundsException("Position must be in range of 0 and size");
		}
		
		E newArray = array[index];
		
		for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
		
		array[size - 1] = null;

        size--;
        return newArray;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null)
		{
			throw new NullPointerException("Value you are trying to remove cannot be null value");
		}
		
	    for (int position = 0; position < size; position++) 
	    {
	        if (array[position].equals(toRemove)) 
	        {
	            E removedElement = array[position];

	            for (int j = position; j < size - 1; j++) 
	            {
	                array[j] = array[j + 1];
	            }

	            array[size - 1] = null;
	            size--;

	            return removedElement;
	        }
	    }
	    return null;
	    
		
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (toChange == null) 
		{
			throw new NullPointerException("Value you are trying to remove cannot be null valueC");
        }
        
		if (index >= size || index < 0)
		{
			throw new IndexOutOfBoundsException("Position must be in range of 0 and size");
		}

        E oldValue = array[index];
        array[index] = toChange;
        return oldValue;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) 
		{
	        throw new NullPointerException("Cannot search for a null value");
	    }

	    for (int position = 0; position < size; position++) 
	    {
	        if (array[position].equals(toFind)) 
	        {
	            return true;
	        }
	    }

	    return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null) 
		{
	        throw new NullPointerException("The provided array cannot be null.");
	    }
	   
        if( size > toHold.length ) 
        {
        	toHold = (E[]) Array.newInstance(toHold.getClass().getComponentType(), size);
		}
	    System.arraycopy(array, 0, toHold, 0, size);
 
	    return toHold;
	}
	

	@Override
	public Object[] toArray() {
	    Object[] convertedList = new Object[size];
	    
	    System.arraycopy(array, 0, convertedList, 0, size); 

	    return convertedList;
	}

	@Override
	public Iterator<E> iterator() {
		 return new Iterator<E>() 
		 	{
		        private int currentPosition = 0;  
		        @Override
		        public boolean hasNext() 
		        {
		        	return currentPosition < size;
		        }

		        @Override
		        public E next() 
		        {
		            if (hasNext()) 
		            {
		                return array[currentPosition++];
		            }
		            throw new NoSuchElementException("No more element to iterate over");
		        }
		    };
	}

}
