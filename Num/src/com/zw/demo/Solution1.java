package com.zw.demo;

public class Solution1 {
	public int[] twoSum(int[] nums , int target) {
		int[] num = new int[nums.length];
		int k = 0 ;
		int count = 0 ;
		for(int i = 0 ; i < nums.length ; i++) {
			for(int j = i + 1 ; j < nums.length ; j ++) {
				if(nums[i] + nums[j] == target) {
					num[k++] = i ;
					num[k++] = j ;
					count+=2 ;
					
				}
			}
		}
		return num ;
		
	}

}
