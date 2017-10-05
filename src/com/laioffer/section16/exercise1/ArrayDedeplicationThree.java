package com.laioffer.section16.exercise1;

import java.util.Arrays;

public class ArrayDedeplicationThree {
	public int[] dedup(int[] array) {
		if(array.length == 1 || array == null) {
			return array;
		}
		int slowIndex = 0;
		int fastIndex = 0;
		while(fastIndex < array.length) {
			int beginIndex = fastIndex;
			while(fastIndex < array.length && array[fastIndex] == array[beginIndex]) {
				fastIndex++;
			}
			
			if(fastIndex - beginIndex == 1) {
				array[slowIndex++] = array[beginIndex];
			}
		}
		
		return Arrays.copyOf(array, slowIndex);
	}
}
