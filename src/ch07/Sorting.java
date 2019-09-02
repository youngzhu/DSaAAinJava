package ch07;

import common.util.CollectionUtil;

public class Sorting {
	
	public static void main(String[] args) {
//		Double[] arr = {3.0, 9.1, 10.01, 4.54, 3.333, 1.2, 2.11};
		Integer[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
		insertionSort(arr);
		CollectionUtil.printArray(arr);
	}

	/**
	 * 插入排序法
	 * 
	 * @param a
	 */
	public static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] a) {
		int j;
		
		for(int p = 1; p < a.length; p++) {
			/*
			 * 将 p 元素置于 tmp
			 * 将 p 之前的比它大的元素都右移一位
			 * 将 tmp 放到正确的位置上
			 */
			AnyType tmp = a[p];
			for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;
		}
	}
}
