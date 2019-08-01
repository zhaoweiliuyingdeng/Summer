package com.zw.demo;

import java.util.Scanner;

import javax.sound.midi.Synthesizer;

public class Solution3 {
	 public static String longestPalindrome(String s) {
		 int len = s.length() ;
		 int i = 2 ;
		 String str = null ;
		 while(i < len) {
			 for(int j = 0 ; j < len - i + 1 ; j ++) {
			  String st = (String)s.subSequence(j , i+j) ;
			  char[] ch = st.toCharArray() ;
			  int len2 = ch.length ;
			  boolean flag = false ;
			  int k = 0 ;
			  while(k < len2/2) {
				  if(ch[k]!=ch[len2-k-1]) {
					  break ;
				  }
				  else {
					  k++ ;
					  flag = true ;
				  }
			  }
			  if(flag  ) {
				  str = (String)ch.toString();
				  System.out.println(str);
			  }
			 }
			 i ++ ;
		 }
		 return str ;
	 }
	       
	 public static void main(String[] args) {
		 String s = "acaa";
		 String str = Solution3.longestPalindrome(s) ;
		 System.out.println(str.toString());
		 
		 
		 
	 }

}
