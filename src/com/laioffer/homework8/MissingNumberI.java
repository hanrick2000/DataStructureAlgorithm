package com.laioffer.homework8;

public class MissingNumberI {
	public int missing(int[] array) {
		if(array == null || array.length == 0) {
			return -1;
		}
		
		int n  = array.length + 1;
		int xor = 0;
		for (int i = 1; i < n + 1; i++) {
			xor ^= i;
		}
		
		for(int num : array) {
			xor ^= num;
		}
		return xor;
	}
}
