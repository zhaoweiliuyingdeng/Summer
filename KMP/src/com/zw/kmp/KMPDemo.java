package com.zw.kmp;

import java.util.Scanner;

public class KMPDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;

		System.out.println("������ԭʼ�ַ�����");
		String str = sc.nextLine() ;
		char[] s = str.toCharArray() ;
		System.out.println("������ƥ���ַ�����");
		String str2 = sc.nextLine() ;
		char[] p = str2.toCharArray() ;
		
		int i = SimpleUtil.Search(s, p) ;
		System.out.println(i);

	}

}
