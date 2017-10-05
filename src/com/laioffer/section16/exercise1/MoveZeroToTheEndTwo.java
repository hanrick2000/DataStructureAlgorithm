package com.laioffer.section16.exercise1;

public class MoveZeroToTheEndTwo {
	public int[] moveZero(int[] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		
		int slowIndex = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] != 0) {
				array[slowIndex++] = array[i];
			}
		}
		
		while(slowIndex < array.length) {
			array[slowIndex++] = 0;
		}
		return array;
	}
}
