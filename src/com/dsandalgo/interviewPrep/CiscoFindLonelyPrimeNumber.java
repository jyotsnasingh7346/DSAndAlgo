package com.dsandalgo.interviewPrep;

import java.util.HashMap;
import java.util.Map;

public class CiscoFindLonelyPrimeNumber {

	public static void main(String[] args) {
		
		String input = "12,3,3,4,5,5,7,8,21,23,2,2,47,23,7";
		
		int lonely = getLonelyPrime(input);
		System.out.println("Lonely Prime number is : " + lonely);
	}

	private static int getLonelyPrime(String input) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		String[] str = input.split(",");
		int[] nums = new int[str.length];
		
		for (int i=0; i<nums.length; i++) {
			nums[i] = Integer.parseInt(str[i]);
			System.out.print(nums[i] + " ");
			if (isPrime(nums[i])) {
				map.computeIfPresent(nums[i], (k,v) -> v+1);
				map.putIfAbsent(nums[i], 1);
				
			}
		}
		
		System.out.println("Updated Map : " + map);
		
		int lonely = map.entrySet()
				.stream()
				.filter(entry -> entry.getValue() == 1)
				.map(Map.Entry::getKey)
				.findFirst().orElse(null);

		
		
		return lonely;
	}

	private static boolean isPrime(int num) {
		// prime number check code
		
		if (num <= 1 || num == 4)
			return false;
		
		for (int i=2; i< Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
				
		}
		
		System.out.println(num + " is prime");
		return true;
	}

}
