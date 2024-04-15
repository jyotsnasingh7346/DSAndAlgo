package com.dsandalgo.interviewPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindMajorityElement {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Question -> Find the majority element in the array. 
		 * A majority element in an array of size n is an element that appears more than n/2 times (
		 * and hence there is at most one such element).		 * 
		 * Input : array1= {3, 3, 4, 2, 4, 4, 2, 4, 4} 
		 * Output : 4 
		 * Explanation: The frequency of 4 is 5 which is greater than the half of the size of the array size.
		 * 
		 * Input : array2 = {3, 3, 4, 2, 4, 4, 2, 4}
		 * Output : No Majority Element
		 * Explanation: There is no element whose frequency is greater than half of the size of array.
		 */
		
		int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		int n = arr.length/2;
		
		List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet().stream().filter(i -> i.getValue()>n).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(collect);
	}

}
