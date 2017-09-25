package com.laioffer.section15.DPThree;

public class LongestConsecutiveOne {
	public int longest(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		int curLength = array[0];
		int result = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] == 1) {
				curLength = curLength + 1;
			} else {
				curLength = 0;
			}
			result = Math.max(result, curLength);
		}
		return result;
	}
}
