package com.laioffer.section16.exercise1;

import java.util.Arrays;

public class ArrayDeduplicationOne {
	public int[] dedup(int[] array) {
		if(array.length <= 1 || array == null) {
			return array;
		}
		
		int slowIndex = 1;
		for(int fastIndex = 1; fastIndex < array.length; fastIndex++) {
			if(array[fastIndex] == array[slowIndex - 1]) {
				continue;
			}
			array[slowIndex++] = array[fastIndex];
		}
		
		return Arrays.copyOf(array, slowIndex);
	}
}
