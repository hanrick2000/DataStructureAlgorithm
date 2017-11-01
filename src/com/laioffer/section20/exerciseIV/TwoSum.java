package com.laioffer.section20.exerciseIV;

import java.util.Arrays;

public class TwoSum {
	public boolean existSum(int[] array, int target) {
		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;
		while(left < right) {
			int sum = array[left] + array[right];
			if(sum == target) {
				return true;
			} else if(sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}
}
