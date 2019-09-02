package ch03;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 问题：迭代器里没有List
 * 内部类的作用：可以直接访问“外部类”的元素，theItems 等
 * 
 * ch03.MyArrayListV1
 * on 2019年5月20日
 * @author by Yang.ZHU
 */
public class MyArrayListV1<AnyType> implements Iterable<AnyType> {
	private static final int DEFAULT_CAPACITY = 10;
	
	private int theSize;
	private AnyType[] theItems;
	
	public MyArrayListV1() {
		clear();
	}
	
	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	public void ensureCapacity(int newCapacity) {
		if (newCapacity <= theSize) {
			return;
		}
		
		AnyType[] old = theItems;
		theItems = (AnyType[]) new Object[newCapacity];
		for (int i = 0; i < size(); i++) {
			theItems[i] = old[i];
		}
	}

	public int size() {
		return theSize;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void trimToSize() {
		ensureCapacity(size());
	}
	
	public AnyType get(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException(idx);
		}
		return theItems[idx];
	}
	
	public void set(int idx, AnyType newItem) {
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException(idx);
		}
		
//		AnyType old = theItems[idx];
		theItems[idx] = newItem;
	}
	
	public boolean add(AnyType newItem) {
		return add(size(), newItem);
	}

	public boolean add(int idx, AnyType newItem) {
		if (theItems.length == size()) {
			ensureCapacity(size() * 2 + 1);
		}
		
		for (int i = theSize; i > idx; i--) {
			theItems[i] = theItems[i - 1];
		}
		theItems[idx] = newItem;
		
		theSize++;
		
		return true;
	}
	
	public AnyType remove(int idx) {
		AnyType rmItem = theItems[idx];
		
		for (int i = idx; i < size() - 1; i++) {
			theItems[i] = theItems[i + 1];
		}
		
		theSize --;
		
		return rmItem;
	}

	@Override
	public Iterator<AnyType> iterator() {
		return new ArrayListIteratorV1();
	}
	
}

class ArrayListIteratorV1<AnyType> implements Iterator<AnyType> {

	private int current = 0;
	
	@Override
	public boolean hasNext() {
		return current < size();
	}

	@Override
	public AnyType next() {
		if (! hasNext()) {
			throw new NoSuchElementException();
		}
		return theItems[current++];
	}

	@Override
	public void remove() {
		MyArrayListV1.this.remove(-- current);
	}
	
}
