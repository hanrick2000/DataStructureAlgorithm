package com.laioffer.homework1;

public class SelectionSort {

	private int[] selectionSort(int[] array) {
		// Write your solution here.
		if (array.length <= 1 || array == null) {
			return array;
		}

		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}

			if (min == i) {
				continue;
			}

			swap(array, i, min);

		}
		return array;
	}

	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectionSort solution = new SelectionSort();
		int[] array = { 4, 3, 2, 1 };
		int[] result = solution.selectionSort(array);
		for (int i : result) {
			System.out.print(i);
		}
	}
}
