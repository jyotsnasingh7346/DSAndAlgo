package com.dsandalgo.ibmprep;

import java.util.HashSet;
import java.util.Set;

public class ArrayIntersectionAndUnion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {80, 35, 42, 56, 2, 97, 71};
		int[] arr2 = {9, 71, 65, 56, 80};
		
		getIntersectionAndUnion(arr1, arr2);
		

	}

	private static void getIntersectionAndUnion(int[] arr1, int[] arr2) {
		// We can add arr1 to a set, and check from arr2, if element is in set, that gives us intersection
		Set<Integer> set1 = new HashSet<>();
		
		for (int i=0; i<arr1.length; i++) {
			set1.add(arr1[i]);
		}
		
		System.out.print("Intersection : " );
		for (int i=0; i<arr2.length; i++) {
			if (set1.contains(arr2[i])) {
				System.out.print(arr2[i] + " ");
			} else {
				set1.add(arr2[i]);
			}
		}
		System.out.println();
		System.out.println("Union : " + set1);
		
	}

}
