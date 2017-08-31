package com.laioffer.homework1;

public class RainbowSort {
	public int[] rainbowSort(int[] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		rainbowSortHelper(array, 0, 0, array.length - 1);
		return array;
	}
	
	private void rainbowSortHelper(int[] array, int negativepivot, int zeropivot, int positivepivot) {
		//the left of negativepivot shoule be negative number
		//the zero should between negativepivot and zeropivot
		//the right side of positivepivot should be positive
		//the part to be discovered should between zeropivot and positivepivot
		
		int neg = negativepivot;
		int zero = zeropivot;
		int pos = positivepivot;
		
		while(zero <= pos) {
			if(array[zero] == -1) {
				swap(array, neg++, zero++);
			} else if(array[zero] == 0) {
				zero++;
			} else if(array[zero] == 1) {
				swap(array, zero, pos--);
			}
		}
			
	}
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RainbowSort solution = new RainbowSort();
		int[] array = { -1, 1, 1, 0, 0, 1, 1, -1 };
		int[] result = solution.rainbowSort(array);
		for (int i : result) {
			System.out.println(i);
		}

	}
}
