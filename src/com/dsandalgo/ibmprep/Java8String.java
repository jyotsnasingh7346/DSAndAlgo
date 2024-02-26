package com.dsandalgo.ibmprep;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8String {

	public static void main(String[] args) {
		
		String str = "She sells sea shell on the sea shore";
		Character ch = 's';
		
		// 1. Given a string, remove all occurrences of the given character from that string
		String result = str
					.chars()
					.mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
					.filter(c -> c != ch)
					.map(c -> String.valueOf((char) c))
					.collect(Collectors.joining());
		System.out.println(result);
		
		// 2. Replace all occurrences of the given character from the given string
		String result1 = str
			.chars()
			.mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
			.map(c -> c == ch ? 'z' : c)
			.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
			.toString();
		System.out.println(result1);
		
		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("apple");
		list.add("orange");
		list.add("kiwi");
		list.add("apple");
		
		// 3. Count the number of occurrences of a apple in a list of string
		long apples = list.stream().filter(s -> s.equals("apple")).count();
		System.out.println("Number of apples : " + apples);
		
		// 4. Given a String with special characters, fetch only the special characters from it
		String str1 = "Hi, from @Heaven, y#&ou h@ave the po$wer";
		
		String result2 = str1
			.chars()
			.filter(c -> !Character.isLetterOrDigit(Character.valueOf((char) c)))
			.mapToObj(c -> (char) c)
			.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
			.toString();
		System.out.println(result2);
		
		// 5. fetch everything except special characters
		String result3 = str1.
			chars()
			.filter(c -> Character.isLetterOrDigit(Character.valueOf((char) c)))
			.mapToObj(c -> (char) c)
			.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
			.toString();
		System.out.println(result3);
		
		// 6. Given a string, return characters with their respective count :
		String result4 = str
				.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.toString();
		System.out.println(result4);
		
		// 7. Join list of Strings with prefix, suffix & delimiter
		String joiner = list.stream().collect(Collectors.joining(", ", "@", "$"));
		System.out.println("string joiner on list : " + joiner);
		
		// 8. Check if 2 Strings are anagrams
		String s1 = "fluster";
		String s2 = "restful";
		
		s1 = Stream.of(s1.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
		s2 = Stream.of(s2.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
		
		System.out.println("Are " + s1 + " and " + s2 +" anagrams ? " + s1.equals(s2));
		
		// 9. 
		
		
		
		
	}

}
