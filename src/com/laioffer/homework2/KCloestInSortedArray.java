package com.laioffer.homework2;

public class KCloestInSortedArray {
	public int[] binarySearch(int[] array, int target, int k) {
		// Write your solution here.
		if (array == null || array.length == 0) {
			return array;
		}

		if (k == 0) {
			return new int[0];
		}
		int start = largestSmallerEqual(array, target);
		int end = start + 1;
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			if (end >= array.length || start >= 0 && target - array[start] <= array[end] - target) {
				result[i] = array[start--];
			} else {
				result[i] = array[end++];
			}
		}
		return result;
	}

	private int largestSmallerEqual(int[] array, int target) {
		int start = 0;
		int end = array.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (array[mid] <= target) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (array[end] <= target) {
			return end;
		}

		if (array[start] <= target) {
			return start;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KCloestInSortedArray solution = new KCloestInSortedArray();
		int[] array = { 1, 5 };
		int[] result = solution.binarySearch(array, 2, 2);
		for (int i : result) {
			System.out.print(i);
		}
	}
}

