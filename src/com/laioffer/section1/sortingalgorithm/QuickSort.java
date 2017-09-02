package com.laioffer.section1.sortingalgorithm;

public class QuickSort {
	public int[] quickSort(int[] array) {
	    // Write your solution here
		if(array == null || array.length <= 1) {
			return array;
		}
		quickSortHelper(array, 0, array.length - 1);
	    return array;
	  }
	
	private void quickSortHelper(int[] array, int start, int end) {
		if(start >= end) {
			return;
		}
		int pivotPos = position(array, start, end);
		quickSortHelper(array, start, pivotPos - 1);
		quickSortHelper(array, pivotPos + 1, end);
	}
	
	private int position(int[] array, int left, int right) {
		int pivotIndex = pivotIndex(left, right);
		int pivot = array[pivotIndex];
		swap(array, pivotIndex, right);
		int leftBound = left;
		int rightBound = right - 1;
		while(leftBound <= rightBound) {
			if(array[leftBound] < pivot) {
				leftBound++;
			} else if(array[rightBound] >= pivot) {
				rightBound--;
			} else {
				swap(array, leftBound++, rightBound--);
			}
		}
		
		swap(array, leftBound, right);
		return leftBound;
	}
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private int pivotIndex(int start, int end) {
		return start + (int)(Math.random() * (end - start + 1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort solution = new QuickSort();
		int[] array = { 4, 3, 2, 1 };
		int[] result = solution.quickSort(array);
		for (int i : result) {
			System.out.println(i);
		}

	}

}
