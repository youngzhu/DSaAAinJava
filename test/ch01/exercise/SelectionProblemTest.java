package ch01.exercise;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import util.ArrayUtil;
import common.sort.BubbleSort;

public class SelectionProblemTest {

	@Test
	public void test() throws Exception {
		// 4545, 99, 98, 65, 45, 2, -34
		int[] arr = new int[] {98, 99, 2, 45, 4545, -34, 65};
		
		assertEquals(4545, SelectionProblem.select(arr, 1));
		assertEquals(99, SelectionProblem.select(arr, 2));
		assertEquals(98, SelectionProblem.select(arr, 3));
		assertEquals(65, SelectionProblem.select(arr, 4));
		assertEquals(45, SelectionProblem.select(arr, 5));
		assertEquals(2, SelectionProblem.select(arr, 6));
		assertEquals(-34, SelectionProblem.select(arr, 7));
	}
	
	/**
	 * 生成随机数进行测试
	 * @throws Exception 
	 */
	@Test
	public void testRandom() throws Exception {
		int len = new Random().nextInt(100) + 1; // 至少要有一个数
		
		int[] arr = ArrayUtil.buildRandomArr(len);
		
		// 1 <= k <= len
		int k = new Random().nextInt(len) + 1;
		
		// 为了不影响原始数组，复制一个
		int[] copyArr = Arrays.copyOf(arr, len);
		int[] sortedArr = BubbleSort.sortByDesc(copyArr);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(sortedArr));
		
		// 已排好序（从大到小）的数组的第 k 个元素
		int expected = sortedArr[k - 1]; 
		int actual = SelectionProblem.select(arr, k);
		
		assertEquals(expected, actual);
	}
}
