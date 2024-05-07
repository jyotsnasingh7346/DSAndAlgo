package com.dsandalgo.interviewPrep;

public class MergedSorted {
	
	// given 2 sorted arrays, 
	// return a final merged array that is sorted. do not use any inbuilt methods.
	
	public static void main(String[] args) {

		int[] arr1 = { 2, 3, 6, 8, 9 };
		int[] arr2 = { 8, 16, 19, 28, 54, 62 };
		
		int[] mergedArray = getMergedArray(arr1, arr2);
		
		for (int i : mergedArray) {
			System.out.print(i + " ");
		}
		
	}

	private static int[] getMergedArray(int[] arr1, int[] arr2) {

		int m = arr1.length;
		int n = arr2.length;

		int[] mergedArray = new int[m + n];

		int i = 0, j = 0, k = 0;

		while (i < m && j < n) {
			if (arr1[i] < arr2[j]) {
				mergedArray[k++] = arr1[i++];
			} else {
				mergedArray[k++] = arr2[j++];
			}
		}
		
		// remaining elements in arr1
		while (i < m) {
			mergedArray[k++] = arr1[i++];
		}
		
		// remaining elements in arr2
		while (j < n) {
			mergedArray[k++] = arr2[j++];
		}

		return mergedArray;
	}

}
