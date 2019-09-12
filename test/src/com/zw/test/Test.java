package com.zw.test;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		int[] arr = {4,4,2,7,6} ;
		int len = arr.length ;
		int flag = 0 ;
		int[] arr2 = new int[len] ;
		for(int i = 0 ; i < len ; i++) {
			arr2[i] = arr[i] ;
		}
		for(int i = 0 ; i < len - 1; i ++) {
			for(int j = 0 ; j < len-i -1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j] ;
					arr[j] = arr[j+1] ;
					arr[j+1] = temp ;
				}
			}
		}
		 if(arr[0] != arr2[0]){
	            for(int i = 1 ; i < len-1 ; i++){
	                if(arr[i] != arr2[i])
	                    ++ flag ;
	            }
	            System.out.println(flag);
	        }else{
	            for(int i = 0 ; i < len ; i++){
	                if(arr[i] != arr2[i])
	                    flag ++ ;
	            }
	            System.out.println(flag);
	        }
		System.out.println(flag);
	}

}
