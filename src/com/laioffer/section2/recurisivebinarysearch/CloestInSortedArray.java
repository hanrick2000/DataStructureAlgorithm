package com.laioffer.section2.recurisivebinarysearch;

public class CloestInSortedArray {
	public int binarySearch(int[] array, int target) {
		// Write your solution here.
		if(array == null || array.length == 0) {
			return -1;
		}
		
		int start = 0;
		int end = array.length - 1;
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if(array[mid] == target) {
				return mid;
			} else if(array[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		if(Math.abs(array[start] - target) < Math.abs(array[end] - target)) {
			return start;
		} else {
			return end;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CloestInSortedArray solution = new CloestInSortedArray();
		int[] array = {1, 2, 2, 2, 5};
		int result = solution.binarySearch(array, 4);
		System.out.print(result);
	}
}

