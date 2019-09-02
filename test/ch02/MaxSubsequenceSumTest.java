package ch02;

import static org.junit.Assert.*;

import org.junit.Test;

import common.util.ArrayUtil;

/**
 * 耗时只是参考，不同的机器时间不一样
 *
 * @author by Young.ZHU
 *      on 2015年8月2日
 *
 * Package&FileName: ch02.MaxSubsequenceSumTest
 */
public class MaxSubsequenceSumTest extends MaxSubsequenceSum {

	@Test
	public void test() {
		int[] arr = {-2, 11, -4, 13, -5, -2};
		
		assertEquals(20, MaxSubsequenceSum.maxSubSum1(arr));
		assertEquals(20, MaxSubsequenceSum.maxSubSum2(arr));
		assertEquals(20, MaxSubsequenceSum.maxSubSum3(arr));
		assertEquals(20, MaxSubsequenceSum.maxSubSum4(arr));
		assertEquals(20, MaxSumTest.maxSubSum3(arr));
	}
	
	@Test
	public void test2() {
		int[] arr = {-2,  -4};
		
		System.out.println(MaxSubsequenceSum.maxSubSum1(arr));
		System.out.println(MaxSubsequenceSum.maxSubSum2(arr));
		System.out.println(MaxSubsequenceSum.maxSubSum3(arr));
		System.out.println(MaxSubsequenceSum.maxSubSum4(arr));
		System.out.println(MaxSumTest.maxSubSum3(arr));
	}
	
	/**
	 * maxSubSum1耗时：2
		maxSubSum2耗时：0
		maxSubSum3耗时：0
		maxSubSum4耗时：0
	 */
	@Test
	public void testRandom100() {
		testRandom(100);
	}
	
	/**
	 * maxSubSum1耗时：100
		maxSubSum2耗时：3
		maxSubSum3耗时：1
		maxSubSum4耗时：0
	 */
	@Test
	public void testRandom1000() {
		testRandom(1000);
	}
	
	/**
	 * maxSubSum1耗时：84313
		maxSubSum2耗时：34
		maxSubSum3耗时：2
		maxSubSum4耗时：0
	 * 
	 */
	@Test
	public void testRandom10000() {
		testRandom(10000);
	}

	private void testRandom(int len) {
		int[] arr = ArrayUtil.buildRandomArr(len);
		
		int maxSum = MaxSubsequenceSum.maxSubSum1(arr);
		assertEquals(maxSum, MaxSubsequenceSum.maxSubSum2(arr));
		assertEquals(maxSum, MaxSubsequenceSum.maxSubSum3(arr));
		assertEquals(maxSum, MaxSubsequenceSum.maxSubSum4(arr));
	}
}
