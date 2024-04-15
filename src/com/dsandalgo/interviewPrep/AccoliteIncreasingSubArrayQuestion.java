package com.dsandalgo.interviewPrep;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AccoliteIncreasingSubArrayQuestion {

	public static void main(String[] args) {
		
		// Given an array with n numbers, find the length of the longest contiguous sub array
		// such that every element in that sub array is strictly greater than the previous one. 
		
		// int[] arr = {11,13,2,3,4,5,2,3};		// output : 4
		
		// start with count=1, while i<arr.length
		// keep incrementing the count every time arr[i] < arr[i+1].
		// when arr[i] > arr[i+1], add this count to a list & reset the count to 1
		// return max of the list
		
		int[] arr = {11,13,2,3,4,5,2,3,4,5,6,7,8,9,0};
		int max = findMaxSubArray(arr);
		System.out.println("Max length : " + max);
	}

	private static int findMaxSubArray(int[] arr) {
		int max = 0;
		List<Integer> list = new ArrayList<>();
		
		int count = 1;
		int i=1;
		while (i < arr.length) {	// 11,2,3,4,5,12,11
			if (arr[i] > arr[i-1]) {
				count++;
			} else {
				list.add(count);
				count = 1;
			}
			i++;
			list.add(count);
		}
		
		max = list.stream().max(Comparator.naturalOrder()).get();
		
		return  max;
	}
}
