package ch03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ListTest {
	ArrayList<Integer> arrLst = new ArrayList<Integer>();
	LinkedList<Integer> lnkLst = new LinkedList<Integer>();
	
	private final static int N1 = 1000000;
	private final static int N2 = 10000;
	
	/**
	 * 百万才会有明显差别
	 * 时间都是 ：O(N)
	 */
	@Test
	public void testAdd1() {
		long t1 = System.currentTimeMillis();
		addList1(arrLst, N1);
		long t2 = System.currentTimeMillis();
		
		long t3 = System.currentTimeMillis();
		addList1(lnkLst, N1);
		long t4 = System.currentTimeMillis();
		
		System.out.println(t2 - t1);
		System.out.println(t4 - t3);
	}
	
	/**
	 * 到万有明显差别
	 * ArrayList：O(N^2)
	 * LinkedList: O(N)
	 */
	@Test
	public void testAdd2() {
		long t1 = System.currentTimeMillis();
		addList2(arrLst, N2);
		long t2 = System.currentTimeMillis();
		
		System.out.println(t2 - t1);
		
		long t3 = System.currentTimeMillis();
		addList2(lnkLst, N2);
		long t4 = System.currentTimeMillis();
		
		System.out.println(t4 - t3);
	}
	
	/**
	 * ArrayList：O(N)
	 * LinkedList: O(N^2)
	 */
	@Test
	public void testSum1() {
//		test1();
		testAdd2();
		long t1 = System.currentTimeMillis();
		sum1(arrLst);
		long t2 = System.currentTimeMillis();
		
		System.out.println("ArrayList:" + (t2 - t1));
		
		long t3 = System.currentTimeMillis();
		sum1(lnkLst);
		long t4 = System.currentTimeMillis();
		
		System.out.println("LinkedList:" + (t4 - t3));
	}
	
	/**
	 * 通过增强for循环，两者的差别消除，都是 O(N)
	 * 因为迭代器
	 */
	@Test
	public void testSum2() {
		testAdd2();
		long t1 = System.currentTimeMillis();
		sum2(arrLst);
		long t2 = System.currentTimeMillis();
		
		System.out.println("ArrayList:" + (t2 - t1));
		
		long t3 = System.currentTimeMillis();
		sum2(lnkLst);
		long t4 = System.currentTimeMillis();
		
		System.out.println("LinkedList:" + (t4 - t3));
	}
	
	/**
	 * 针对ArrayList测试容量
	 * 
	 * 一个指定大小，一个未指定
	 * add，然后再遍历，看时间
	 * 
	 * 测试结果：未指定容量 的时间稍长
	 * 
	 */
	@Test
	public void testCapacity() {
		ArrayList<Integer> list1 = new ArrayList<Integer>(10000);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		int capacity = 8889; // 实际的数据量
		
		long t1 = System.currentTimeMillis();
		// 初始化数据
		for (int i = 0; i < capacity; i++) {
			list1.add(i);
		}
		// 遍历获取
		sum2(list1);
		long t2 = System.currentTimeMillis();
		System.out.println("固定容量-" + (t2 - t1));
		
		// ==================================
		long t3 = System.currentTimeMillis();
		// 初始化数据
		for (int i = 0; i < capacity; i++) {
			list2.add(i);
		}
		// 遍历获取
		sum2(list1);
		long t4 = System.currentTimeMillis();
		System.out.println("未指定容量-" + (t4 - t3));
	}
	
	/**
	 * 测试trimToSize的作用
	 * 
	 * 测试结果：没看出太大差别
	 */
	@Test
	public void testCapacity2() {

		ArrayList<Integer> list1 = new ArrayList<Integer>(100000);
		ArrayList<Integer> list2 = new ArrayList<Integer>(100000);
		
		int capacity = 18889; // 实际的数据量
		
		long t1 = System.currentTimeMillis();
		// 初始化数据
		for (int i = 0; i < capacity; i++) {
			list1.add(i);
		}
		
		//trimToSize
		list1.trimToSize();
		
		// 遍历获取
		sum2(list1);
		long t2 = System.currentTimeMillis();
		System.out.println("trimToSize-" + (t2 - t1));
		
		// ==================================
		long t3 = System.currentTimeMillis();
		// 初始化数据
		for (int i = 0; i < capacity; i++) {
			list2.add(i);
		}
		// 遍历获取
		sum2(list1);
		long t4 = System.currentTimeMillis();
		System.out.println("no trimToSize-" + (t4 - t3));
	
	}
	
	/**
	 * 从一个数组中删除所有偶数
	 */
	@Test
	public void testRemove() {
//		List<Integer> lst = new ArrayList<Integer>();
//		lst.add(6);
//		lst.add(5);
//		lst.add(1);
//		lst.add(4);
//		lst.add(2);
//		System.out.println(lst);
//		removeEvens1(lst);
//		System.out.println(lst);
		
		int size = 100000;
		
		List<Integer> arrList = new ArrayList<Integer>(size);
		List<Integer> lnkList = new LinkedList<Integer>();
		
		// 初始化数据
		for (int i = 0; i < size; i++) {
			arrList.add(i);
			lnkList.add(i);
		}
		
		long start = System.currentTimeMillis();
//		removeEvens1(arrList);
//		removeEvens2(arrList);
		removeEvens3(arrList);
		long end = System.currentTimeMillis();
		System.out.println("arrList-" + (end - start));
		
		start = System.currentTimeMillis();
//		removeEvens1(lnkList);
//		removeEvens2(lnkList);
		removeEvens3(lnkList);
		end = System.currentTimeMillis();
		System.out.println("lnkList-" + (end - start));
	}
	
	/**
	 * 方法一：
	 * 10000
	 * arrList-0
	 * lnkList-110
	 * 
	 * 100000
	 * arrList-641
	 * lnkList-10641
	 * 
	 * LinkedList 有明显的二次特征，即数量增加10倍，时间久增加100倍
	 * 
	 * @param lst
	 */
	public static void removeEvens1(List<Integer> lst) {
		int i = 0;
		while (i < lst.size()) {
			if (lst.get(i) % 2 == 0) {
				lst.remove(i);
			}
			// 这个要注意一下
			// 一开始以为不需要else，直接+
			else {
				i ++;
			}
		}
	}
	
	/**
	 * 会有异常：
	 * java.util.ConcurrentModificationException
	 * @param lst
	 */
	public static void removeEvens2(List<Integer> lst) {
		for (Integer i : lst) {
			if (i % 2 == 0) {
				lst.remove(i);
			}
		}
	}
	
	public static void removeEvens3(List<Integer> lst) {
		Iterator<Integer> itr = lst.iterator();
		
		while (itr.hasNext()) {
			if (itr.next() % 2 == 0) {
				itr.remove();
			}
		}
	}

	/**
	 * 从末端添加元素
	 * 
	 * @param lst
	 * @param n
	 */
	public static void addList1(List<Integer> lst, int n) {
		lst.clear();
		
		for (int i = 0; i < n; i++) {
			lst.add(i);
		}
	}
	
	/**
	 * 从顶端添加元素
	 * 
	 * @param lst
	 * @param n
	 */
	public static void addList2(List<Integer> lst, int n) {
		lst.clear();
		
		for (int i = 0; i < n; i++) {
			lst.add(0, i);
		}
	}
	
	/**
	 * 获取元素
	 * 
	 * @param lst
	 * @return
	 */
	public static int sum1(List<Integer> lst) {
		int total = 0;
		
		for (int i = 0; i < lst.size(); i++) {
			total += lst.get(i);
		}
		
		return total;
	}
	
	/**
	 * 通过增强for循环获取元素
	 * 
	 * @param lst
	 * @return
	 */
	public static int sum2(List<Integer> lst) {
		int total = 0;
		
		for (Integer i : lst) {
			total += i;
		}
		
		return total;
	}
}
