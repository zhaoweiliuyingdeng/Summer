package com.zw.huisu;

import java.util.* ;

public class TestDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>() ;
		list.add("A");
		list.add("B") ;
		list.add("C") ;
		List<String > li = new ArrayList<String>() ;
		Print(0, list , li) ;
		

	}
	public static void Print(int i , List<String> list ,List<String> li) {
		if(i > list.size() - 1 ) {
			System.out.println(li);
		}else {
			li.add(list.get(i)) ;
			Print(i+1 , list , li) ;
			li.remove(list.get(i)) ;
			Print(i+1 , list , li) ;
		}
	}

}
