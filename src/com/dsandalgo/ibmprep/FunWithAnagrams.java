package com.dsandalgo.ibmprep;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunWithAnagrams {

	public static void main(String[] args) {
		
		/*
		 * QUESTION : Given an array of words and its anagrams, 
		 * return only unique words and discard their anagrams
		 * 
		 * Sample Input : [code, edoc, cdoe, framer, frame]
		 * Sample Output : [code, framer, frame]
		 * 
		 * STEPS : 
		 * 1. Save arr[0] in map
		 * 2. if the next element is anagram of arr[0], dont save 
		 */
		
		String[] input = {"code", "edoc", "cdoe", "framer", "frame"};
		String[] result = getUniqueStringsOnly(input);
		for (int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}

	private static String[] getUniqueStringsOnly(String[] input) {
		// 1. create a map which stores original element as value, and its sorted order as key
		// 2. add element in map if it does not exist
		// 3. add all keys to an array and return
		
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		List<String> result = new ArrayList<>();
		
		for (int i=0; i<input.length; i++) {
			String temp = input[i];
			temp = Stream.of(temp.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
			
			if (!map.containsKey(temp)) {
				map.put(temp, input[i]);
				result.add(input[i]);
			}
		}		
		
		String[] res = result.toArray(new String[0]);
		
		return res;
	}

}
