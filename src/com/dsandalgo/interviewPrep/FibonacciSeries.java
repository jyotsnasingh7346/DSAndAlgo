package com.dsandalgo.interviewPrep;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		// Fibonacci using Dynamic Programming
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number till which you want the Fibonacci Series: ");
		int n = sc.nextInt();
		
		generateFibonacciSeries(n);
		
		sc.close();
	}

	private static void generateFibonacciSeries(int n) {

		if (n <= 1)
			System.out.println(n);

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		Arrays.stream(dp).forEach(i -> System.out.println(i));

	}

}
