package com.dsandalgo.array;

import java.util.Arrays;

public class DutchNationalFlag {

	/*
	 * TASK : 		Given a 1D array T[] containing any number of 0s, 1s & 2s in an unsorted manner, sort them in O(N)
	 * 
	 * SOLUTION : 	we will have 3 indices. low, mid & high. 
	 * 				low & mid point to T[0] & high points to T[length-1]
	 * 				pivot = 1
	 * 
	 * ALGORITHM : 	while (mid <= high)
	 * 					if (mid < 1) -> swap low & mid, increment low & mid
	 * 					else if (mid > 1) -> swap mid & high, decrement mid
	 * 					else -> increment mid
	 * */
	
	private int[] nums;

	public DutchNationalFlag(int[] nums) {
		super();
		this.nums = nums;
	}
	
	public void dutchNationalFlag(int[] nums) {
		int low = 0;
		int mid = 0;
		int high = nums.length - 1;
		
		while (mid <= high) {
			if (nums[mid] < 1) {
				swap(low, mid);
				low++;
				mid++;
			} else if (nums[mid] > 1) {
				swap(mid, high);
				high--;
			} else {
				mid++;
			}
		}
		
		printResult(nums);
		
	}

	private void printResult(int[] nums) {
		// TODO Auto-generated method stub
		System.out.println("DutchNationalflag solution : "+Arrays.toString(nums));
	}

	private void swap(int a, int b) {
		// TODO Auto-generated method stub
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
}
