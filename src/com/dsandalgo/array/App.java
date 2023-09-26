package com.dsandalgo.array;

import java.util.Arrays;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*-----------------------------------------------------------------------------------------------------*/
		// 3. DutchNationalFlag.java
		
		System.out.println("Enter the size of the array : ");
		int size1 = sc.nextInt();
		int[] b = new int[size1];
		
		System.out.println("Enter the elements of the array : ");
		for (int i=0; i<size1; i++) {
			b[i] = sc.nextInt();
		}
		
		
		sc.close();
		System.exit(0);
		/*-----------------------------------------------------------------------------------------------------*/
		// 2. ReverseArrayInPlace.java
		
		System.out.println("Enter the size of the array : ");
		int size = sc.nextInt();
		int[] a = new int[size];
		
		System.out.println("Enter the elements of the array : ");
		for (int i=0; i<size; i++) {
			a[i] = sc.nextInt();
		}
		
		ReverseArrayInPlace revWithoutRecursion = new ReverseArrayInPlace();
		System.out.println("Array after being reversed (Without Recrsion) : ");
		System.out.println(Arrays.toString(revWithoutRecursion.reverseWithoutRecursion(a)));
		
		ReverseArrayInPlace revWithRecursion = new ReverseArrayInPlace();
		System.out.println("Array after being reversed (With Recrsion) : ");
		revWithRecursion.reverseWithRecursion(a, 0, size-1);
		
		sc.close();
		System.exit(0);
		
		/*-----------------------------------------------------------------------------------------------------*/
	}

}
