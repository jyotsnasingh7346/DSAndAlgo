package com.dsandalgo.interviewPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CiscoMaxSubString {

	/*
	 * A substring is a contiguous sequence of characters within a string, 
	 * given a string determine the alphabetically maximum substring.
		Example : s = 'baca'

		The unique substrings: ['b', 'ba', 'bac', 'baca',
		'a', 'ac', 'aca', 'c', 'ca']
		
		Arranging the substrings alphabetically: ['a',
		'ac', 'aca', 'b', 'ba', 'bac', 'baca', 'c', 'ca']
		
		The maximum substring alphabetically: 'ca'
		return this subtring
	 */
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string : ");
		String str = scan.next();
		
		System.out.println("Maximum substring : " + getMaxSubString(str));

	}

	private static String getMaxSubString(String str) {
		String res = "";
		
		List<String> subStrings = new ArrayList<>();
		
		// this should get us all possible substrings
		for (int i=0; i<str.length(); i++) {
			for (int j=i+1; j<str.length(); j++) {
				subStrings.add(str.substring(i, j));
				
			}
		}
		
		// sort each word in subStrings list individually
		List<String> list2 = subStrings.stream()
					.map(word -> word.chars())
					.sorted()
					.map(word -> word.toString())
					.collect(Collectors.toList());
		
		System.out.println(subStrings);
		System.out.println(list2);
		// sort the entire substring
		
		
		// add the list to a map with each words count
		
		
		// return the one with the highest count
		
		return res;
	}

}
