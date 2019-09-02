package ch04;

import java.util.*;

import org.junit.Test;

public class SetTest {

	/**
	 * Set 不重复
	 * TreeSet 有序
	 */
	@Test
	public void test() {
		Set<String> set = new TreeSet<String>(new CaseInsensitiveCompare());
		set.add("hello");
		set.add("Hello");
		System.out.println(set.size());
	}
}

class CaseInsensitiveCompare implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareToIgnoreCase(o2);
	}
	
}
