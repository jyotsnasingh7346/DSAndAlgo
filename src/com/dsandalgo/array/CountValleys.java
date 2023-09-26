package com.dsandalgo.array;

public class CountValleys {

	/*
	 * TASK : Given an array consisting a number of 'Ds' & 'As', for Descending &
	 * Ascending, respectively, You are required to count how many valleys has the
	 * hiker crossed. A valley starts from the ground level, goes down & is counted
	 * when the hiker reaches the ground level again.
	 * 
	 */

	public static int valleyCount(char[] a) {

		// Before starting the code, let's first convert the character array to int
		// array. Assign D = -1 & A = 1
		int[] arr = new int[a.length];
		for (int i = 0; i < arr.length; i++) {
			if (a[i] == 'D') {
				arr[i] = -1;
			} else if (a[i] == 'A') {
				arr[i] = 1;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		// Here, we have our int array with -1s & 1s.

		// 1. Initialize required variables. 3 variables are required.
		// sum, valleyCount, tempVariable

		int sum = 0, valleyCount = 0;
		int tempVariable = arr[0];

		// 2. Iterate through the array & count valleys

		for (int i = 0; i < arr.length; i++) {

			// 3. Add in sum
			sum += arr[i];

			// 4. Count Valleys & Assign & correct tempVariable
			if (sum == 0) {
				if (tempVariable == -1) {
					valleyCount++;
				}
				if (i < arr.length - 1) {
					tempVariable = arr[i + 1];
				}
			}
		}

		return valleyCount;
	}

	public static void main(String[] args) {
		char[] a = { 'D', 'D', 'A', 'A', 'A', 'D', 'A' };
		int valleys = valleyCount(a);
		System.out.println("Number of valleys = " + valleys);
	}

}
