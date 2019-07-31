package com.zw.kmp;

public class SimpleUtil {
	public static int Search(char[] s , char[] p) {
		int sLen = s.length ;
		int pLen = p.length ;
		int i = 0 ;
		int j = 0 ;
		while(i < sLen && j < pLen) {
			if(s[i] == p[j]) {
				//ƥ��ɹ�
				i++ ;
				j++ ;
			}
			else {
				//ƥ��ʧ��
				i = i-j+1 ;
				j = 0 ;
			}
		}
		if(j == pLen) {
			return i - j ;
		}else {
			return -1 ;
		}
		
	}

}
