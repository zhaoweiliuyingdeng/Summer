package com.zw.test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in) ;
		System.out.println("������Ҫ��֤��ipV4��ipV6�ĵ�ַ��");
		String str = in.nextLine() ;
		int len = str.length() ;
		char[] chat = str.toCharArray() ;
		int flag = 0 ;
		int temp = 0 ;
		while(temp < len ) {
			if(chat[temp] == '.') {
				flag++ ;
			}
			temp++ ;
		}
		if(flag<3&&flag>0) {
			System.out.println("������ȷ��Ipv4��ַ");
		}
		if(flag == 4) {
			
		}
		System.out.println(flag);
	}

}
