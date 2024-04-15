package com.dsandalgo.interviewPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountDuplicateElements {

	public static void main(String[] args) {
		
		// Given an array of integers, count the number of elements that occur more than once
		
		int[] num = {1,3,3,4,4,5,6,7,8,8,8};
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(8);
		list.add(8);
		
		
		int count = getDuplicateCount(list);
		
		System.out.println(count);

	}

	private static int getDuplicateCount(List<Integer> list) {

		int count = 0;
		
		Map<Integer, Integer> elements = new HashMap<>();
		
		for (int i : list) {
			if (!elements.containsKey(i)) {
				elements.put(i, 1);
			} else {
				elements.put(i, elements.get(i)+1);
			}
		}
		
//		for (int i : elements.values()) {
//			if (i > 1) count++;
//		}
		
		for (Map.Entry<Integer, Integer> entry : elements.entrySet()) {
			if (entry.getValue() > 1) {
				count++;
			}
		}
		
		// Map looks like ->
		//	1 , 1
		//	3 , 2
		//	4 , 2
		//	5 , 1
		//	6 , 1
		//	7 , 1
		//	8 , 3
		
		return count;
	}

}
