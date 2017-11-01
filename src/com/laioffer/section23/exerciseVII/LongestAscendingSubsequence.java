package com.laioffer.section23.exerciseVII;

public class LongestAscendingSubsequence {
	public int longest(int[] array) {
		if(array.length == 0) {
			return 0;
		}
		
		int[] longest = new int[array.length];
		int result = 1;
		for(int i = 0; i < array.length; i++) {
			longest[i] = 1;
			for(int j = 0; j < i; j++) {
				if(array[j] < array[i]) {
					longest[i] = Math.max(longest[i], longest[j] + 1);
				}
			}
			result = Math.max(result, longest[i]);
		}
		return result;
	}
}
