package com.dsandalgo.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class ComparingRunningTimes {

	public static void main(String[] args) {
		
		// In this class, we will try to add 5 million elements at the beginning of an ArrayList & a LinkedList.
		// And we will compare the time taken by both of the Data Structures & print the time taken.
		/*------------------------------------------------------------------------------------------------------------*/
		// 1. ArrayList
		
		ArrayList<Integer> array = new ArrayList<>();
		long now = System.currentTimeMillis();
		
		for (int i = 0; i < 500000; i++) {
			array.add(0, i);
		}
		System.out.println("Time taken by ArrayList : "+(System.currentTimeMillis() - now));
		/*------------------------------------------------------------------------------------------------------------*/
		// 2. LinkedList
		
		LinkedList<Integer> list = new LinkedList<>();
		now = System.currentTimeMillis();
		for (int i = 0; i < 500000; ++i) {
			list.addFirst(i);
		}
		System.out.println("Time taken by LinkedList : "+(System.currentTimeMillis() - now));
		/*------------------------------------------------------------------------------------------------------------*/
	}
	
}
