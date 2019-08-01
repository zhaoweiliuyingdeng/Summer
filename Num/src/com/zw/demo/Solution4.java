package com.zw.demo;

import java.util.ArrayList;

public class Solution4 {
	 public static int removeDuplicates(int[] nums) {
		 ArrayList<Integer> array = new ArrayList<Integer>() ;
		 for(int i = 0 ; i < nums.length ; i ++) {
			 int tem = 0 ;
			 for(int j = i+1 ; j < nums.length ; j ++) {
				 if(nums[i] == nums[j]) {
					 break ;
				 }
				 tem = 1 ;
			 }
			 if(tem == 1) {
				 array.add(nums[i]) ;
			 }
		 }
		 return array.size() ;
	        
	    }
	 public static void main(String[] args) {
		 int[] nums = {1,1,2,3,4,3,5,6} ;
		 int n = Solution4.removeDuplicates(nums) ;
		 System.out.println(n);
	 }

}
