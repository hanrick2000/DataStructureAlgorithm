package com.laioffer.homework2;

public class ClassicalBinarySearch {
	public int binarySearch(int[] array, int target) {
		// Write your solution here.
		if(array == null || array.length == 0) {
			return -1;
		}
		
		int start = 0;
		int end = array.length - 1;
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(array[mid] == target) {
				return mid;
			} else if(array[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassicalBinarySearch solution = new ClassicalBinarySearch();
		int[] array = {1, 2, 3, 4, 5};
		int result = solution.binarySearch(array, 4);
		System.out.print(result);
	}
}
