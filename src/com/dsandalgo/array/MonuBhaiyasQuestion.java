package com.dsandalgo.array;

import java.util.Arrays;

public class MonuBhaiyasQuestion {

	/*
	 * An Array A = [0, 1, 0, 1, 1, 1, 0], which can only contains 0s & 1s,
	 * needs to be sorted without using extra memory (constant space complexity)
	 * */
	
	public void sortArray(int[] arr) {
		int lowIndex = 0;
		int highIndex = arr.length - 1;
		
		while (lowIndex < highIndex) {
			if (arr[lowIndex] == 1) {
				if (arr[highIndex] != 1) {
					swap (lowIndex, highIndex, arr);
				}
				highIndex--;
			} else {
				lowIndex++;
			}
		}
		System.out.println("Sorted Array : " + Arrays.toString(arr));
	}

	private void swap(int lowIndex, int highIndex, int[] arr) {
		arr[highIndex] = arr[highIndex] + arr[lowIndex];
		arr[lowIndex] = arr[highIndex] - arr[lowIndex];
		arr[highIndex] = arr[highIndex] - arr[lowIndex];
	}
	
}
