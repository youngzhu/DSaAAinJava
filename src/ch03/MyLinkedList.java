package ch03;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
	private static class Node<T> {
		public Node(T data, Node<T> prev, Node<T> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		public T data;
		public Node<T> prev, next;
	}
	
	public MyLinkedList() {
		clear();
	}
	
	public void clear() {
		beginMarker = new Node<T>(null, null, null);
		endMarker = new Node<T>(null, beginMarker, null);
		beginMarker.next = endMarker;
		
		theSize = 0;
		modCount ++;
	}
	
	public int size() {
		return theSize;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void add(T x) {
		add(size(), x);
	}
	
	public void add(int idx, T x) {
		addBefore(getNode(idx), x);
	}
	
	public T get(int idx) {
		return getNode(idx).data;
	}
	
	public void set(int idx, T newVal) {
		Node<T> p = getNode(idx);
		p.data = newVal;
	}
	
	public T remove(int idx) {
		return remove(getNode(idx));
	}
	
	private T remove(Node<T> p) {
		p.next.prev = p.prev;
		p.prev.next = p.next;
		
		theSize --;
		modCount ++;
		
		return p.data;
	}
	
	private void addBefore(Node<T> p, T x) {
		Node<T> newNode = new Node<T>(x, p.prev, p);
		newNode.prev.next = newNode;
		p.prev = newNode;
		
		theSize++;
		modCount++;
	}
	
	private Node<T> getNode(int idx) {
		Node<T> p;
		
		if (idx < 0 || idx > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if (idx < size() / 2) {
			p = beginMarker.next;
			for (int i = 0; i < idx; i++) {
				p = p.next;
			}
		} else {
			p = endMarker;
			for (int i = size(); i > idx; i--) {
				p = p.prev;
			}
		}
		
		return p;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<T> {
		private Node<T> current = beginMarker.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		
		public boolean hasNext() {
			return current != endMarker;
		}
		
		public T next() {
			if (modCount != expectedModCount) {
				throw new ConcurrentModificationException();
			}
			
			if (! hasNext()) {
				throw new NoSuchElementException();
			}
			
			T nextItem = current.data;
			current = current.next;
			okToRemove = true;
			
			return nextItem;
		}
		
		public void remove() {
			if (modCount != expectedModCount) {
				throw new ConcurrentModificationException();
			}
			
			if (! okToRemove) {
				throw new IllegalStateException();
			}
			
			MyLinkedList.this.remove(current.prev);
			okToRemove = false;
			expectedModCount ++;
		}
	}
	
	private int theSize, modCount = 0;
	private Node<T> beginMarker, endMarker;

}
