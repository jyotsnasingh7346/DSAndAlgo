package com.dsandalgo.array;

import java.util.Arrays;

public class DutchNationalFlag {

	/*
	 * TASK : 		Given a 1D array T[] containing any number of 
	 * 				0s, 1s & 2s in an unsorted manner, sort them in O(N)
	 * 
	 * */
	
	public static void main(String[] args) {
		int arr[]= {0, 2, 1, 2, 0};
		dutchNationalFlag(arr);
	}
	
	public static void dutchNationalFlag(int[] nums) {
		// The Dutch National Flag Problem
        
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        
        while (mid <= high) {
            
            switch (nums[mid]) {
                
                case 0:
                    swap (nums, low, mid);
                    low++; mid++;
                    break;
                
                case 1:
                    mid++;
                    break;
                
                case 2:
                    swap (nums, mid, high);
                    high--;
                    break;
            }
        }
		
		printResult(nums);
		
	}

	private static void printResult(int[] nums) {
		System.out.println("DutchNationalflag solution : "+Arrays.toString(nums));
	}

	private static void swap (int a[], int first, int second) {
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }
	
}
