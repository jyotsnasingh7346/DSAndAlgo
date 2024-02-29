package com.dsandalgo.ibmprep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Number {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 6, 7, 5);
		
		// 1. Find duplicate elements
		List<Integer> collect = list.stream()
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet()
			.stream()
			.filter(i -> i.getValue() > 1)
			.map(Map.Entry::getKey)
			.collect(Collectors.toList());
		System.out.println(collect);
		
		// 1. Find duplicate elements
		Set<Integer> set = new HashSet<>();
		list.stream()
			.filter(i -> !set.add(i))
			.forEach(i -> System.out.print(i + " "));		// or use .collect(Collectors.toList());
		System.out.println();

		// 2. Find sum of all elements
		int sum = list.stream()
			.mapToInt(Integer::intValue)
			.sum();
		System.out.println(sum);
		
		// 3. Count the number of occurrences of all element in a list
		Map<Integer, Long> collect2 = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(collect2);
		
		// 4. Find unique numbers only
		list.stream().distinct().forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		// 4. Find unique numbers only
		List<Integer> collect3 = list.stream().distinct().collect(Collectors.toList());
		System.out.println("Unique numbers only : " + collect3);
		
		// 4. Find unique numbers only
		Set<Integer> collect4 = list.stream().collect(Collectors.toSet());
		System.out.println("Unique numbers only : " + collect4);
		
		// 5. Write the same code using java stream api
		
		int sum1 = 0;
		for (int i = 0; i <= 50; i++) {
			sum1 += i;
		}
		System.out.println("Sum of 1 to 50 = " + sum1);
		
		int sum2 = IntStream.range(0, 51).sum();
		System.out.println("Sum of 1 to 50 = " + sum2);
		
		int sum3 = IntStream.rangeClosed(1, 50).sum();
		System.out.println("Sum of 1 to 50 = " + sum3);
		
		// 6. Find only even numbers from the list
		List<Integer> evens = list.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
		System.out.println("Even numbers from the list : " + evens);
		
		// 7. Find only odd numbers from the list
		List<Integer> odds = list.stream().filter(i -> i%2 != 0).collect(Collectors.toList());
		System.out.println("Odd numbers from the list : " + odds);
		
		// 8. Print odd numbers from 1 - 100
		System.out.println("Print odd numbers from 1 - 100 : ");
		IntStream.rangeClosed(1, 100).filter(i -> i%2 != 0).forEach(i -> System.out.print(" " + i));
		System.out.println();
		
		// 9. Print multiple of 5 from the list of numbers
		List<Integer> collect5 = list.stream().filter(i -> i%5 == 0).collect(Collectors.toList());
		System.out.println("Multiples of 5 from the list : " + collect5);
		
		// 10. Print maximum from the list
		int max1 = list.stream().max(Comparator.naturalOrder()).get();
		int max2 = list.stream().max(Integer::compare).get();
		int max3 = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("Max = " + max1 + ", " + max2 + ", " + max3);
		
		// 11. Print minimum from the list
		int min1 = list.stream().min(Comparator.naturalOrder()).get();
		int min2 = list.stream().min(Comparator.comparingInt(Integer::valueOf)).get();
		int min3 = list.stream().min(Integer::compare).get();
		System.out.println("Min = " + min1 + ", " + min2 + ", " + min3);
		
		// 12. Reverse a list
		List<Integer> reversedList = IntStream.range(0, list.size())
                .mapToObj(i -> list.get(list.size() -i -1))
                .collect(Collectors.toList());

        System.out.println("Original List: " + list);
        System.out.println("Reversed List: " + reversedList);
        
        int midElement = list.stream().map(i -> list.get(list.size()/2)).findFirst().get();
        System.out.println("Mid element : " + midElement);
		
	}

}
