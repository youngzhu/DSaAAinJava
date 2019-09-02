package ch03;

import java.util.Iterator;

import org.junit.Test;

public class MyArrayListTest {

	@Test
	public void test() {
		MyArrayList myList = new MyArrayList<Integer>();
		
		myList.add(1);
		myList.add(2);
		myList.add(3);
		
		Iterator itr = myList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
