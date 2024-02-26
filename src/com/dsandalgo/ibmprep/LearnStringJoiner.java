package com.dsandalgo.ibmprep;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class LearnStringJoiner {

	public static void main(String[] args) {
		
		stringJoiner();
		
		if (are2ArraysEqual()) {
			System.out.println("Both arrays are equal");
		} else {
			System.out.println("Arrays are not equal");
		}
		
	}

	private static boolean are2ArraysEqual() {
		// TODO Auto-generated method stub
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {5,4,3,2,6};
		
		if (arr1.length == arr2.length) {
			List<Integer> list = new ArrayList<>();
			
			for (int i=0; i<arr1.length; i++) {
				list.add(arr1[i]);
			}
			
			for (int i=0; i<arr1.length; i++) {
				if(!list.contains(arr2[i])) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	private static void stringJoiner() {
		// TODO Auto-generated method stub
		StringJoiner joiner1 = new StringJoiner(",", "[", "]");

		joiner1.add("A"); joiner1.add("B"); joiner1.add("C");

		StringJoiner joiner2 = new StringJoiner(":", "[", "]");
		joiner2.add("P"); joiner2.add("Q"); 

		System.out.println(joiner1);
		System.out.println(joiner2);
		System.out.println(joiner1.merge(joiner2));
		System.out.println(1+2+3+"welcome"+5+6);
	}

}
