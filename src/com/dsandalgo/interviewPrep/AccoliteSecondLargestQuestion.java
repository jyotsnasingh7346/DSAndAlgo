package com.dsandalgo.interviewPrep;

public class AccoliteSecondLargestQuestion {

	public static void main(String[] args) {
		
		// Find the 2nd largest element in an array without using sorting / inbuilt methods
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		
		int[] arr = {1,2,3,4,5,6};
		
		for (int num : arr) {
			if (num > largest) {
				secondLargest = largest;
				largest = num;
			} else if (num > secondLargest && num != largest) {
				secondLargest = num;
			}
		}
		
		System.out.println("Second Largest : " + secondLargest);
		
	}

}
