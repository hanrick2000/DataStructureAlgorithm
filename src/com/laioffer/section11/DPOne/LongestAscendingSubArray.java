package com.laioffer.section11.DPOne;

public class LongestAscendingSubArray {
	public int longest(int[] array) {
		if(array.length == 0 || array == null) {
			return 0;
		}
		int[] M = new int[array.length];
		M[0] = 0;
		M[1] = 1;
		int max = 1;
		for(int i = 2; i < array.length; i++) {
			if(array[i - 1] < array[i]) {
				M[i] = M[i - 1] + 1;
			}
			max = Math.max(max, M[i]);
		}
		return max;
	}
}
