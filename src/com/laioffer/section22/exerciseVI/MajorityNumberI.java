package com.laioffer.section22.exerciseVI;

public class MajorityNumberI {
	public int majority(int[] array) {
		if(array.length == 0 || array == null) {
			return -1;
		}
		int candidate = array[0];
		int count = 1;
		for(int i =  1; i < array.length; i++) {
			if(count == 0) {
				count++;
				candidate = array[i];
			} else if(candidate == array[i]) {
				count++;
			} else {
				count--;
			}
		}
		return candidate;
	}
}
