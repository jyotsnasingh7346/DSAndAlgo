package com.dsandalgo.array;

public class MaxMinInArray {

	/*
	 * TASK : 		Given an array, return its max & min values.
	 * 
	 * ALGORITHM : 	Assign 1st 2 elements to max & min and then start comparing from the 3rd place
	 * 
	 * */
	
	private int min;
	private int max;
	
	public MaxMinInArray() {
		super();
		this.min = 0;
		this.max = 0;
	}
	
	public MaxMinInArray getMinAndMax(int arr[]) {
		MaxMinInArray maxmin = new MaxMinInArray();
		
		int len = arr.length;
		
		// CASE 01 : WHEN ARR HAS ONLY 1 ELEMENT
		if (len == 1) {
			maxmin.min = arr[0];
			maxmin.max = arr[0];
			return maxmin;
		}
		
		// CASE 02 : WHEN ARR HAS ONLY 2 ELEMENTS
		if (len == 2) {
			// check which element is greater
			if (arr[0] > arr[1]) {
				maxmin.max = arr[0];
				maxmin.min = arr[1];
			} else {
				maxmin.max = arr[1];
				maxmin.min = arr[0];
			}
			return maxmin;
		}
		
		// CASE 03 : WHEN ARR HAS MORE THAN 2 ELEMENTS
		if (len > 2) {
			if (arr[0] < arr[1]) {
				maxmin.min = arr[0];
				maxmin.max = arr[1];
			} else {
				maxmin.min = arr[1];
				maxmin.max = arr[0];
			}
			for (int i = 2; i<len; i++) {
				if (arr[i] > maxmin.max) {
					maxmin.max = arr[i];
				} else if (arr[i] < maxmin.min) {
					maxmin.min = arr[i];
				}
			}
		}
		
		return maxmin;
	}

	@Override
	public String toString() {
		return "MaxMinInArray [min=" + min + ", max=" + max + "]";
	}
	
}
