package ch03;

import java.util.Iterator;

import org.junit.Test;

public class MyLinkedListTest {

	@Test
	public void test() {
		MyLinkedList myList = new MyLinkedList<Integer>();
		
		myList.add(1);
		myList.add(2);
		myList.add(3);
		
		myList.remove(1);
		
		Iterator itr = myList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
