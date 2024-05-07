package com.dsandalgo.interviewPrep;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Array {

	public static void main(String[] args) {

		int[] arr = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5};
		
		// 1. Find sum of all elements in array : 
		int sum = Arrays.stream(arr).sum();
		System.out.println("sum of all : "+ sum);
		
		// 2. Find count
		long count = Arrays.stream(arr).count();
		System.out.println("count of all : "+ count);
		
		// 3. Find count of unique
		long count2 = Arrays.stream(arr).distinct().count();
		System.out.println("count of unique elements only : " + count2);
		
		// 3. Find average
		OptionalDouble avg = Arrays.stream(arr).average();
		System.out.println("avg of all : "+ avg);
		
		// 4. Find only unique
		IntStream distinct = Arrays.stream(arr).distinct();
		System.out.println("unique elements only : "+ distinct);
		
		// 5. Find max
		OptionalInt max = Arrays.stream(arr).max();
		System.out.println("max : "+ max);
		
		// 6. Find min
		OptionalInt min = Arrays.stream(arr).min();
		System.out.println("min : "+ min);

		// 7. Find only duplicates without count
		Set<Integer> set = new HashSet<>();
		System.out.print("duplicates : ");
		Arrays.stream(arr)
			.filter(i -> !set.add(i))
			.distinct()
			.forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		
		Arrays.stream(arr).boxed()
        .collect(Collectors.groupingBy(i -> i, Collectors.counting())) // Group by element and count occurrences
        .entrySet()
		.stream()
        .filter(entry -> entry.getValue() > 1) // Filter entries with count greater than 1 (duplicates)
        .map(Map.Entry::getKey) // Get the key (duplicate element)
        .collect(Collectors.toList()); // Collect duplicate elements into a list
		
		// 8. Sum of even elements of an array
		int sum2 = Arrays.stream(arr).filter(i -> i%2 == 0).sum();
		System.out.println("sum of even elements : " + sum2);
		
		// 9. Frequency of each element in an array
		Map<Integer, Long> array1 = Arrays.stream(arr).boxed()
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(array1);
		
		// 10. sort the list
		List<Integer> ascend = Arrays.stream(arr).sorted().boxed().collect(Collectors.toList());
		System.out.println("ascend : " + ascend);
		
		// 11. sort the list in reverse order
		List<Integer> descend = Arrays.stream(arr).boxed()
			.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("descend : " + descend);
		
		// 12. merge 2 unsorted arrays to a sorted one
		int[] arr1 = {9,4,6,2,0};
		int[] arr2 = {2,3,6,5,4,8};
		
		List<Integer> sorted = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
										.sorted().boxed().collect(Collectors.toList());
		System.out.println("Sorted array : " + sorted);
		
		// 13. merge 2 unsorted arrays to a sorted one without duplicates
		List<Integer> sortedDistinct = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
						.sorted().distinct().boxed().collect(Collectors.toList());
		
		System.out.println("Sorted Distinct array : " + sortedDistinct);
		
		// 14. 2nd largest & smallest number in an array
		int secondLargest = Arrays.stream(arr).distinct().boxed().sorted(Comparator.reverseOrder())
								.skip(1).findFirst().get();
		System.out.println("2nd largest number in the array: " + secondLargest);
		
		int secondSmallest = Arrays.stream(arr).boxed().distinct().sorted().skip(1).findFirst().get();
		System.out.println("2nd smallest number in the array: " + secondSmallest);
		
		// 15. Common elements between 2 arrays
		int[] common = IntStream.of(arr1).filter(x -> Arrays.stream(arr2).anyMatch(y -> y == x)).toArray();
		
		System.out.println("Common elements : " + Arrays.asList(common));
		
		// 16. sum & avg of all elements in an array
		int summer = Arrays.stream(arr1).sum();
		double avgr = Arrays.stream(arr2).average().getAsDouble();
		
		System.out.println("Sum = " + summer + ", Average = " + avgr);
		
		// 17. reverse an integer array
		int[] reversedArray = Arrays.stream(arr1)
				  .boxed() // Convert int stream to Stream<Integer>
				  .sorted(Collections.reverseOrder()) // Sort in descending order
				  .mapToInt(Integer::intValue) // Convert back to int stream
				  .toArray();
		
		for (int i : reversedArray) {System.out.print(i+ " ");}
		
		// 18. Last element of an array
		Arrays.stream(arr).skip(arr.length-1).findFirst();
		
		Optional<Integer> last = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).findFirst();
		System.out.println("Last index : " + last);
		
		// 19. 
		Optional<Integer> find2ndLargest = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).skip(1)
				.findFirst();
		
		
		
	}

}
