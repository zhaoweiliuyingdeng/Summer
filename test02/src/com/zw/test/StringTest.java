package com.zw.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in) ;
		System.out.println("ÇëÊäÈëÒªÌæ»»µÄ×Ö·û´®£º");
		String str = in.nextLine() ;
		char[] ch = str.toCharArray() ;
		int len = ch.length ;
		int temp = 0 ;
		int num = 0 ;
		while(len > 0) {
			if(ch[temp] == '?') {
				num ++ ;
			}
			temp++ ;
			len-- ;
		}
		System.out.println(num);
		List list = new ArrayList<char[]>() ;
		
		int flag = 1 ;
		for(int i = 0 ; i < num ; i++) {
			char[] c = new char[ch.length] ;
			for(int j = 0 ; j < ch.length ; j++) {
				if(ch[j] != '?') {
					c[j] = ch[j] ;
				}else {
					c[j] = Integer.toString(flag%2).charAt(0) ;
				}
				flag++ ;
			}
			//c.toString() ;
			flag = 0 ;
			System.out.println(c);
			list.add(c) ;
		}
		System.out.println(list.size());
		for(int i = 0 ; i < list.size() ; i++) {
			char[] ct = (char[])list.get(i) ;
			for(int j = 0 ; j < ct.length ; j++) {
				System.out.print(ct[j]);
				
			}
			System.out.println();
		}

	}
	

}
