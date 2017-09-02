package com.laioffer.section1.sortingalgorithm;

import java.util.Arrays;

public class MergeSort {
	public int[] mergeSort(int[] array) {
	    // Write your solution here.
		if(array == null || array.length == 0) {
			return array;
		}
		
		if(array.length == 1) {
			return array;
		}
		
		int mid = array.length / 2;
		int[] left = Arrays.copyOfRange(array, 0, mid);
		left = mergeSort(left);
		int[] right = Arrays.copyOfRange(array, mid, array.length);
		right = mergeSort(right);
		
		int[] result = new int[array.length];
		combine(left, right, result);
	    return result;
	  }
	
	private void combine(int[] left, int[] right, int[] combined) {
		int leftIndex = 0;
		int rightIndex = 0;
		int combinedIndex = 0;
		
		while(leftIndex < left.length && rightIndex < right.length) {
			if(left[leftIndex] < right[rightIndex]) {
				combined[combinedIndex++] = left[leftIndex++];
			} else {
				combined[combinedIndex++] = right[rightIndex++];
			}
		}
		
		if(leftIndex == left.length) {
			while(rightIndex < right.length) {
				combined[combinedIndex++] = right[rightIndex++];
			}
		} else {
			while(leftIndex < left.length) {
				combined[combinedIndex++] = left[leftIndex++];
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort solution = new MergeSort();
		int[] array = { 4, 3, 2, 1 };
		int[] result = solution.mergeSort(array);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
