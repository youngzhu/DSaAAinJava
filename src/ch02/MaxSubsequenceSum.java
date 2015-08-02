package ch02;

/**
 * 最大子序列和问题
 * 
 * 给定序列 A1，A2,A3...An，
 * 求 Ai...Aj 之和的最大值
 *
 * @author by youngz
 *      on 2015年8月1日
 *
 * Package&FileName: ch02.MaxSubsequenceSum
 */
public class MaxSubsequenceSum {

	/**
	 * Cubic maximun contiguous subsequence sum algorithm.
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	public static int maxSubSum1(int [] arr) {
		int maxSum = 0;
		int minIndex = 0; // 最大子序列和的起始下标
		int maxIndex = 0; // 最大子序列和的结束下标
		
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int sum = 0;
				
				for (int k = i; k <= j; k++) {
					sum += arr[k];
				}
				
				if (sum > maxSum) {
					maxSum = sum;
					minIndex = i;
					maxIndex = j;
				}
				
			}
		}
		
		System.out.println("最大子序列和为：" + maxSum 
				+ "，起止坐标：［" +  minIndex + ", " + maxIndex + "]");
		
		long end = System.currentTimeMillis();
		System.out.println("maxSubSum1耗时：" + (end - start));
		
		return maxSum;
	}
	
	public static int maxSubSum2(int[] arr) {

		int maxSum = 0;
		int minIndex = 0; // 最大子序列和的起始下标
		int maxIndex = 0; // 最大子序列和的结束下标
		
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			
			for (int j = i; j < arr.length; j ++) {
				sum += arr[j];
				
				if (sum > maxSum) {
					maxSum = sum;
					minIndex = i;
					maxIndex = j;
				}
				
			}
		}
		

		System.out.println("最大子序列和为：" + maxSum 
				+ "，起止坐标：［" +  minIndex + ", " + maxIndex + "]");
		
		long end = System.currentTimeMillis();
		System.out.println("maxSubSum2耗时：" + (end - start));
		
		return maxSum;
	}
	
	/**
	 * Driver for divide-and-conquer maximum contiguous
	 * subsequence sum algorithm.
	 * 
	 * @param arr
	 * @return
	 */
	public static int maxSubSum3(int[] arr) {
		long start = System.currentTimeMillis();
		
		int ret = maxSumRec(arr, 0, arr.length - 1);
		
		long end = System.currentTimeMillis();
		System.out.println("maxSubSum3耗时：" + (end - start));
		
		return ret;
	}

	/**
	 * Recurisive maximum contiguous subsequence sum algorithm.
	 * Finds maximum sum in subarray spanning a[left, right].
	 * Does not attempt to maintain actual best sequence.
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	private static int maxSumRec(int[] arr, int left, int right) {

		if (left == right) {
			// Base case
			if (arr[left] > 0) {
				return arr[left];
			} else {
				return 0;
			}
			
		}
		
		int center = (left + right) / 2;
		
		int maxLeftSum = 0, maxRightSum = 0;
		maxLeftSum = maxSumRec(arr, left, center);
		maxRightSum = maxSumRec(arr, center + 1, right);
		
		int maxLeftBorderSum = 0, leftBorderSum = 0;
		for (int i = center; i >= left; i--) {
			leftBorderSum += arr[i];
			if (leftBorderSum > maxLeftBorderSum) {
				maxLeftBorderSum = leftBorderSum;
			}
		}
		
		int maxRightBorderSum = 0, rightBorderSum = 0;
		for (int i = center + 1; i <= right; i++) {
			rightBorderSum += arr[i];
			if (rightBorderSum > maxRightBorderSum) {
				maxRightBorderSum = rightBorderSum;
			}
		}
		
		return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum + maxRightBorderSum);
	}
	
	/**
	 * Linear-time maximum contiguous subseqence sum algorithm.
	 * 
	 * @param arr
	 * @return
	 */
	public static int maxSubSum4(int[] arr) {
		int maxSum = 0, sum = 0;
		
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			
			if (sum > maxSum) {
				maxSum = sum;
			} else if (sum < 0) {
				sum = 0;
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("maxSubSum4耗时：" + (end - start));
		
		return maxSum;
	}
}
