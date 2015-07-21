package ch01.exercise;

import common.sort.BubbleSort;

/**
 * 找出 N 个数中第 k 个最大者
 *
 * @author by youngz
 *      on 2015年7月19日
 *
 * Package&FileName: ch01.exercise.SelectionProblem
 */
public class SelectionProblem {

	/**
	 * 1 先将原始数组的前 k 个数据放到一个新数组中
	 * 2 将新数组按倒序排列（这样，第 k 个最大者直接返回新数组的第 k 个元素即可）
	 * 3 将原始数组剩余的元素插入到新数组合适的位置
	 * 4 返回新数组第 k 个元素
	 * 
	 * @param sourceArr
	 * @param k
	 * @return
	 * @throws Exception 
	 */
	public static int select(int[] sourceArr, int k) throws Exception {
		int len = sourceArr.length;
		
		if (len < 0) {
			throw new Exception("The array is empty.");
		}
		
		if (k < 1
				|| k > len) {
			throw new Exception("The value of k must between 1 and "
					+ len + " .");
		}
		
		int[] retArr = new int[k];
		
		for (int i = 0; i < k; i++) {
			retArr[i] = sourceArr[i];
		}
		
		// 给新数组排序
		retArr = BubbleSort.sortByDesc(retArr);
		
		if (k == len) {
			return retArr[k - 1];
		}
		
		// 将第 k 个元素之后的值，放到新数组合适的位置
		boolean flag = false; // 是否有比新数组最小值还大的数
		int temp=0; // 临时存放较大值
		for (int i = k; i < len; i ++) {
			flag = false;
			/*
			 * 本来是想，先和新数组的最小值（retArr[k-1]）比较
			 * 如果有值大于它的最小值，再去插入／移位等操作；
			 * 否则，直接过
			 * 以为这样效率会高一点
			 * 
			 * 可这种方法，一旦连续大于新数组中的2个以上的数，就会有问题
//			if (k == 1) {
//				if (sourceArr[i] > retArr[0]) {
//					retArr[0] = sourceArr[i];
//				}
//			} else {
				for (int j = k - 1; j >=0; j--) {
					if (sourceArr[i] > retArr[j]) {
						flag = true;
						temp = sourceArr[i];
					} else {
						if (flag) {
							// retArr[j] > temp > retArr[j+1]
							for (int n = k - 1; n > j + 1; n--) {
								retArr[n] = retArr[n - 1];
							}
							
							retArr[j + 1] = temp;
							
							break;
						}
					}
					
					if (flag && 0 == j) {
						retArr[0] = temp;
					}
				}
//			}
			 * 
			 */
			
			// 从新数组的最大值开始比较，即retArr[0]
			for (int j = 0; j < k; j++) {
				if (sourceArr[i] > retArr[j]) {
					if (k - 1 == j) {
						retArr[k - 1] = sourceArr[i];
					} else {
						temp = retArr[j];
						retArr[j] = sourceArr[i];
						
						for (int n = k - 1; n > j + 1; n--) {
							retArr[n] = retArr[n - 1];
						}
						
						retArr[j + 1] = temp;
						
						break;
					}
					
				}
			}
			
		}
		
		return retArr[k - 1];
	}
}
