package com.zw.test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in) ;
		System.out.println("请输入要验证的ipV4或ipV6的地址：");
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
			System.out.println("不是正确的Ipv4地址");
		}
		if(flag == 4) {
			
		}
		System.out.println(flag);
	}

}
