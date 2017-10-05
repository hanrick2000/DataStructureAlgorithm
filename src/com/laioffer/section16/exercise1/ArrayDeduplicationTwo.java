package com.laioffer.section16.exercise1;

import java.util.Arrays;

public class ArrayDeduplicationTwo {
	public int[] dedup(int[] array) {
		// Write your solution here.
		if(array.length <= 2 || array == null) {
			return array;
		}
		
		int slowIndex = 2;
		for(int fastIndex = 2; fastIndex < array.length; fastIndex++) {
			if(array[fastIndex] == array[slowIndex - 2]) {
				continue;
			}
			array[slowIndex++] = array[fastIndex];
		}
		
		return Arrays.copyOf(array, slowIndex);
	}
}
