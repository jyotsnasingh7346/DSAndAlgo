package com.dsandalgo.array;

public class ReverseArrayInPlace {
	 
	 /*
	  * TASK : Reverse the Array without using extra memory
	  * 
	  * ALGORITHM : 	1. REVERSE WITH RECURSION
	  * pre-requisite : start & end is provided.
	  * 
	  * */
	
	public void reverseWithRecursion(int a[], int start, int end) {
		
		// 1. if start > end, return
		if (start > end)
			return;
		
		// 2. swap
		swapWithoutThirdVariable(a, a[start], a[end]);
		
		// 3. call recursively for the rest of the array
		reverseWithRecursion(a, start+1, end-1);
		
		System.out.println(a[start]);
	}

	private void swapWithoutThirdVariable(int[] a, int start, int end) {
		a[start] = a[start] + a[end];
		a[end] = a[start] - a[end];
		a[start] = a[start] - a[end];
	}

	/*----------------------------------------------------------------------------------------------------------------*/
	
	/*
	 * ALGORITHM : 	2. REVERSE WITHOUT RECURSION
	 * 
	 * 				while (start < end)
	 * 						STEP 01 : Swap elements at start & end
	 * 						STEP 02 : Increment the start & Decrement the end & only stop when 
	 * 									start = end & no elements are left to be swapped.
	 * 
	 * */
	
	public int[] reverseWithoutRecursion(int a[]) {
		int start = 0;
		int end = a.length-1;
		
		while (start < end) {
			// 1. swap start & end
			swapWithoutThirdVariable(a, start, end);
			
			// 2. increment start & decrement end if start != end
			if (start != end) {
				start++;
				end--;
			}
		}
		
		return a;
	}
}
