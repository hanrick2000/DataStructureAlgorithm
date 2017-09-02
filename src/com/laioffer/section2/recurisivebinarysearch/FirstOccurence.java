package com.laioffer.section2.recurisivebinarysearch;

public class FirstOccurence {
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
				end = mid;
			} else if(array[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		if(array[start] == target) {
			return start;
		} else if (array[end] == target){
			return end;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstOccurence solution = new FirstOccurence();
		int[] array = {1, 2, 2, 2, 5};
		int result = solution.binarySearch(array, 2);
		System.out.print(result);
	}
}

