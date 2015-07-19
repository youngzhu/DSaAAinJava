package common.sort;

import java.util.Arrays;

import org.junit.Test;

public class BubbleSortTest {

	int[] arr1 = new int[]{8, 77, 6, 90, 12, 34, 656, 1, 1};
	int[] arr2 = new int[]{8, 77, 6, 90, 12, 34, 656, 1, 656};
	int[] arr3 = new int[]{8, 77, 6, 90, 12, 34, 656, 1, 6};
	
	@Test
	public void testSortByDesc() {
		System.out.println(Arrays.toString(arr1));
		arr1 = BubbleSort.sortByDesc(arr1);
		System.out.println(Arrays.toString(arr1));
		
		System.out.println(Arrays.toString(arr2));
		arr2 = BubbleSort.sortByDesc(arr2);
		System.out.println(Arrays.toString(arr2));
		
		System.out.println(Arrays.toString(arr3));
		arr3 = BubbleSort.sortByDesc(arr3);
		System.out.println(Arrays.toString(arr3));
	}
	
	@Test
	public void testSort() {
		System.out.println(Arrays.toString(arr1));
		arr1 = BubbleSort.sort(arr1);
		System.out.println(Arrays.toString(arr1));
		
		System.out.println(Arrays.toString(arr2));
		arr2 = BubbleSort.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
		System.out.println(Arrays.toString(arr3));
		arr3 = BubbleSort.sort(arr3);
		System.out.println(Arrays.toString(arr3));
	}
	

}
