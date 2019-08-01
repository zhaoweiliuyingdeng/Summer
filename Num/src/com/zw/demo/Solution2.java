package com.zw.demo;

public class Solution2 {
public int lengthOfLongestSubstring(String s) {
	int len = s.length() ; 
	char[] ch = s.toCharArray() ;
	int count = 0 ;
	int i = 0 ;
	for(int j = 0 ; j < len ;j ++) {
		for(int k = i ; k < j ; k++) {
			if(ch[k] == ch[j]) {
				i = k + 1 ;
				break ;
			}
		}
		if(j -i + 1 > count) {
			count = j -i + 1 ;
		}
	}
	
        return count ;
    }

}
