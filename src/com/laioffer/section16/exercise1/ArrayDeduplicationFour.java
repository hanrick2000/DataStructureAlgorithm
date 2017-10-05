package com.laioffer.section16.exercise1;

import java.util.Arrays;

public class ArrayDeduplicationFour {
	public int[] dedup(int[] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		int end = -1;
		for(int i = 0; i < array.length; i++) {
			if(end == -1 ||array[end] != array[i]) {
				array[++end] = array[i];
			} else {
				while(i + 1 < array.length && array[i + 1] == array[end]) {
					i++;
				}
				end--;
			}
		}
		
		return Arrays.copyOf(array, end + 1);
	}
}
