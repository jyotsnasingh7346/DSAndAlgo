package com.dsandalgo.dataStructures;

public class BinarySearch {

	public int binarySearch(int arr[], int low, int high, int key) {
		
		int mid = low + high / 2;
		
		while (low <= high) {
			
			if (arr[mid] < key) {
				low = mid + 1;
			} else if (arr[mid] == key) {
				return mid;
			} else {
				high = mid - 1;
			}
			mid = (low + high) / 2;
			
		}
		
		if (low > high) return -1;
		
		return -1;
		
	}
	
	public static void main(String[] args) {

		BinarySearch obj = new BinarySearch();
		int arr[] = {1,2,3,4,5,6};
		System.out.println("Binary Search - Key was found at position : " + obj.binarySearch(arr, 1, 6, 5));
		
	}

}
