package com.zw.Test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("ÊäÈë×Ö·û´®");
		String str = in.nextLine() ;
		String[] str2 = str.split(",") ;
		int len = str2.length ;
		int flag = len ;
		for(int i = 0 ; i < len -1 ; i++) {
			if(str2[i].equals(str2[i+1])) {
				flag -- ;
			}
		}
		System.out.println(flag);
		System.out.println(str2[0].equals(str2[2]));
		

	}
}
