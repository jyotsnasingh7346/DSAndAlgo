package com.dsandalgo.array;

public class TrappingRainWaterProblem {

	public int trappedWater (int[] height) {
		
		int waterTrapped = 0;
		
		if (height.length < 3) {
			return 0;
		}
		
		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];
		
		// 1. calculate maximum left values from left to right
		leftMax[0] = 0;
		for (int i=1; i<leftMax.length; ++i) {
			leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
		}
		
		// 2. calculate maximum right values from right to left
		rightMax[rightMax.length - 1] = 0;
		for (int i=rightMax.length-1; i>=0; --i) {
			rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
		}
		
		// 3. waterTrapped is minimum of left & right - height
		for (int i=1; i<height.length-1; i++) {
			if (Math.min(leftMax[i], rightMax[i]) > height[i]) {
				waterTrapped += Math.min(leftMax[i], rightMax[i]) - height[i];
			}
		}
		
		return waterTrapped;
	}
	
}
