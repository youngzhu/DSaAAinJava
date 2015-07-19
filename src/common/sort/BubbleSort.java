package common.sort;

/**
 * 冒泡排序（Bubble Sort）
 * 
 * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 * 这个算法的名字由来是因为越大的元素会经由交换慢慢“浮”到数列的顶端，故名。
 * 
 * 冒泡排序算法的原理：（以升序为例 ）
 * 1 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 3 针对所有的元素重复以上的步骤，直到最后一个。
 *
 * @author by youngz
 *      on 2015年7月19日
 *
 * Package&FileName: common.sort.BubbleSort
 */
public class BubbleSort {

	/**
	 * 降序排列
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] sortByDesc(int[] arr) {
		int temp;
		
		for (int j = 0 ; j < arr.length - 1; j++) {
			for (int i = arr.length - 1; i > j; i --) {
				if (arr[i] > arr[i - 1]) {
					temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
				}
			}
		}
		
		return arr;
	}
	
	
	/**
	 * 升序排列
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] sort(int[] arr) {
		int temp;
		
		for (int j = arr.length - 1; j > 0; j --) {
			for (int i = 0; i < j; i++) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
		return arr;
	}
}
