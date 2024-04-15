package com.dsandalgo.interviewPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MorganStanleyTaskQueue {
	
	public static void main(String[] args) {
		
		List<Integer> batchSize = Arrays.asList(4,3);
		List<Integer> processingTime = Arrays.asList(6,5);
		List<Integer> numTasks = Arrays.asList(8,8);
		
		/*
		 * Meaning : 
		 * Q1 can process 4 tasks in 6 minutes, and has to process total 8 tasks.
		 * Q2 can process 3 tasks in 5 minutes, and has to process total 8 tasks.
		 * 
		 * TO DO : Given this info, calculate the minimum time needed to process 
		 * 			the given tasks.
		 */
		
		long time = minTime(batchSize, processingTime, numTasks);
		System.out.println("Minimum Time needed : " + time);

	}

	private static long minTime(List<Integer> batchSize, List<Integer> processingTime, List<Integer> numTasks) {
		// Can we try to process how much time each queue would take to process 1 task?
		// and then use it as a multiplier.
		
		if (batchSize.size() != processingTime.size() 
				|| batchSize.size() != numTasks.size()) {
			return 0;
		}
		
		int n = batchSize.size();
		long minTime = 0;
		
		List<Long> timetaken = new ArrayList<>();
		for (int i=0; i<n; i++) {
			
			long batch = batchSize.get(i);
			long processTime = processingTime.get(i);
			long tasks = numTasks.get(i);
			
			long timeTakenToProcessOne = processTime / batch;
			long totalTimeTakenForBatch = (long) (timeTakenToProcessOne * tasks);
			
			timetaken.add(totalTimeTakenForBatch);
			
		}
		
		minTime = timetaken.stream().collect(Collectors.summingLong(Long::longValue));
		
		return minTime;
	}

}
