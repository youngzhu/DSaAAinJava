package ch01;

/**
 * 递归（Recursion）
 * 两个基本法则：
 * 1. 基准情形（base case），不用递归就能求解
 * 2. 不断推进（making progress），递归，朝着基准情形推进
 *
 * @author by youngz
 *      on 2015年6月26日
 *
 * Package&FileName: ch01.Recursion
 */
public class Recursion {

	/**
	 * 打印输出整数
	 * 
	 * @param n - nonnegative
	 */
	public static void printOut(int n) {
		if (n >= 10) {
			printOut(n / 10); // 向基准情形推进
		}
		
		printDigit(n % 10); // 基准情形
	}

	/**
	 * 只处理单个数字并将其输出到终端
	 * 
	 * @param i － [0, 9]
	 */
	private static void printDigit(int i) {

		System.out.print(i);
	}
	
	public static void main(String[] args) {
		
		printOut(76234);
	}
}
