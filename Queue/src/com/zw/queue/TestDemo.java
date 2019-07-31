package com.zw.queue;

public class TestDemo {
	static int max = 8 ; // ���ûʺ������
	static int num = 0 ; //�м��ַ��õķ���
	static int[] array = new int[max] ;

	public static void main(String[] args) {
		check(0) ;
		System.out.println(num);

	}
	public static void check(int n ) { //����ʺ�ȫ���ڷ��꣬������һ����������
		if(n == max) {
			num++ ;
			return ;
		}
		for(int i = 0 ; i < max ; i++) { // �ӵ�һ�п�ʼ�ڣ���max��Ϊֹ
			array[n] = i ; // Ĭ�ϻʺ��ǴӸ��еĵ�һ�п�ʼ�ڷ�
			if(ok(n)) {
				check(n+1) ;
			}
		}
	}
	private static boolean ok(int n) {
		for (int i = 0; i < n; i++) { //�ӵ�һ�п�ʼ��ֵ��Ȼ���ж��Ƿ�ͱ��б��б�б���г�ͻ�����OK���ͽ�����һ�е��߼�
		//array[i] == array[n] �ж��Ƿ���ͬһб����
		//Math.abs(n - i) == Math.abs(array[n] - array[i]) �ж��Ƿ���ͬһ�л���
		if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
		return false;
		}
		}
		return true;
		} 

}
