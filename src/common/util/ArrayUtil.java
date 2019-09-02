package common.util;

import java.util.Random;

/**
 * 数组的工具类
 *
 * @author by youngz
 *      on 2015年8月2日
 *
 * Package&FileName: util.ArrayUtil
 */
public class ArrayUtil {

	/**
	 * 随机生成一个固定长度的数组
	 * 
	 * @param len － 数组长度
	 * @return
	 */
	public static int[] buildRandomArr(int len) {

		int[] arr = new int[len];
		
		for (int i = 0; i < len; i++) {
			// 随机赋值
			// 两个相减，保证有正有负
			arr[i] = new Random().nextInt(10000) - new Random().nextInt(10000);
		}
		
		return arr;
	}
}
