package com.zw.demo;

public class Solution2 {
public int lengthOfLongestSubstring(String s) {
	int len = s.length() ; 
	char[] ch = s.toCharArray() ;
	int count = 1 ;
	int i = 0 ;
	while( i < len) {
		for(int j = i+1 ; j < len ; j++) {
			int k = j ;
			while(k>i) {
				if(ch[i]!=ch[k]) {
					k--;
				}else {
					break ;
				}
			}
			if(k - i > 1) {
				count++ ;
			}
		}
	}
	
        return count ;
    }

}
