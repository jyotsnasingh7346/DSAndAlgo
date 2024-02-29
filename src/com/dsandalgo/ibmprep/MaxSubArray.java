package com.dsandalgo.ibmprep;

import java.util.Arrays;

public class MaxSubArray {
	public static void main(String[] args) {
		
		/*
		 * In this implementation:
		 * We initialize maxSum, currentSum, start, and end variables to keep track of 
		 * the maximum subArray sum and its starting and ending indices.
		 * 
		 * We iterate through the array, updating currentSum by adding each element.
		 * 
		 * If currentSum becomes greater than maxSum, we update maxSum, start, and end to the current values.
		 * 
		 * If currentSum becomes negative, we reset it to 0 and update tempStart to the next index.
		 * 
		 * Finally, we copy the maximum subArray from the original array to a new array and return it.
		 * 
		 * This implementation of Kadane's algorithm has a time complexity of O(n), 
		 * where n is the size of the input array.
		 */
		
        int[] array = {1, -2, 3, -4, 5, -6, 7};
        int[] maxSubarray = findMaxSubarray(array);
        
        // Print the maximum subArray
        System.out.println("Max Subarray: " + Arrays.toString(maxSubarray));
    }

    public static int[] findMaxSubarray(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 0; i < array.length; i++) {
            currentSum += array[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        // Copy the maximum subArray to a new array
        int[] maxSubarray = new int[end - start + 1];
        System.arraycopy(array, start, maxSubarray, 0, end - start + 1);

        return maxSubarray;
    }
}
