package com.laioffer.section11.DPOne;

public class ArrayHopperOne {
	public boolean canJump(int[] array) {
		if (array == null || array.length == 0) {
			return false;
		}
		boolean[] M = new boolean[array.length];
		M[array.length - 1] = true;
		for (int i = array.length - 2; i >= 0; i--) {
			if (i + array[i] >= array.length - 1) {
				M[i] = true;
			} else {
				for (int j = array[i]; j < array.length - 1; j++) {
					if (M[j] == true && (array[i] > j - i)) {
						M[i] = true;
						break;
					} 
				}
			}
		}
		return true;
	}

}
