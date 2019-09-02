package ch04.exercise;

import java.io.File;

/**
 * 列出指定目录中所有的文件及其大小
 * 
 * ch04.exercise.Exercise10
 * on 2019年5月22日
 * @author by Yang.ZHU
 */
public class Exercise10 {

	public static void main(String[] args) {
		File path;
		// 测试目录
		path = new File("E:\\temp");
		// 测试文件
//		path = new File("");
		
		list(path, 0);
	}

	/**
	 * 递归
	 * 
	 * @param file
	 */
	private static void list(File file, int depth) {
		print(file.getName(), depth, size(file));
		
		if (! file.isDirectory()) {
			return;
		}
		depth++;
		for(File f : file.listFiles()) {
			list(f, depth);
		}
	}

	/**
	 * 计算文件的大小
	 * 
	 * 如果是文件，直接返回大小
	 * 如果是文件夹，返回其目录下总文件的大小
	 * 
	 * @param file
	 * @return
	 */
	private static long size(File file) {
		long totalSize = 0;
		
		if (file.isFile()) {
			return file.length();
		}
		
		for(File f : file.listFiles()) {
			totalSize += size(f);
		}
		
		return totalSize;
	}

	/**
	 * 按层级打印目录名称
	 * 层级间以Tab递进
	 * 
	 * @param name
	 * @param depth
	 * @param size 
	 */
	private static void print(String name, int depth, long size) {
		for (int i  = 0; i < depth; i++) {
			System.out.print("\t");
		}
		System.out.println(name + "(" + size + ")");
	}
}
