package ch03.exercise;

import java.util.LinkedList;

/**
 * 习题6：约瑟夫环（Josephus Problem）
 * 
 * N个人编号从1到N，围坐成一圈。
 * 从1号开始传递一个物品。经过M次传递后拿到物品的人出局。
 * 游戏从下一个人开始继续传递。
 * 最后剩下的人胜出。
 * 
 * 如果M=0，N=5，依次出局，5号胜出
 * 如果M=1，N=5，则2,4,1,5依次出局，3号胜出
 * 如果M=6，N=5，则2,5,1,3依次出局，4号胜出
 * 
 * ch03.exercise.Exercise06
 * on 2019年5月21日
 * @author by Yang.ZHU
 */
public class Exercise06 {
	
	public static void main(String[] args) {
//		josephusProblem(5, 0);
//		josephusProblem(5, 1);
		josephusProblem(5, 6);
	}

	/**
	 * 
	 * @param n - 总人数
	 * @param m - 传递次数
	 */
	public static void josephusProblem(int n, int m) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		// 初始化数据
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		LinkedList<Integer> tempList, newList;
		while (n > 1) {
			tempList = new LinkedList<Integer>();
			
			int i = 0;
			while (i < m % list.size()) {
				tempList.add(list.get(i));
				i++;
			}
			
			i = i % list.size();
			Integer out = list.remove(i);
			System.out.println(out + " 出局");
			
			// 新一轮开始
			newList = new LinkedList<Integer>();
			for (int j = i; j < list.size(); j++) {
				newList.add(list.get(j));
			}
			newList.addAll(tempList);
			
			list = newList;
			
			n --;
		}
		
		Integer winner = list.get(0);
		System.out.println(winner + " 胜出！！！！");
	}
}
