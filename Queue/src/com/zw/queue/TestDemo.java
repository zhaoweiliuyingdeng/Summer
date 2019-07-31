package com.zw.queue;

public class TestDemo {
	static int max = 8 ; // 放置皇后的数量
	static int num = 0 ; //有几种放置的方法
	static int[] array = new int[max] ;

	public static void main(String[] args) {
		check(0) ;
		System.out.println(num);

	}
	public static void check(int n ) { //如果皇后全部摆放完，总数加一并跳出方法
		if(n == max) {
			num++ ;
			return ;
		}
		for(int i = 0 ; i < max ; i++) { // 从第一列开始摆，到max列为止
			array[n] = i ; // 默认皇后都是从该行的第一列开始摆放
			if(ok(n)) {
				check(n+1) ;
			}
		}
	}
	private static boolean ok(int n) {
		for (int i = 0; i < n; i++) { //从第一列开始放值，然后判断是否和本行本列本斜线有冲突，如果OK，就进入下一行的逻辑
		//array[i] == array[n] 判断是否在同一斜线上
		//Math.abs(n - i) == Math.abs(array[n] - array[i]) 判断是否在同一行或列
		if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
		return false;
		}
		}
		return true;
		} 

}
