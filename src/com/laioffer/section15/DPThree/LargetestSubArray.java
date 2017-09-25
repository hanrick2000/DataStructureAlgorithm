package com.laioffer.section15.DPThree;

public class LargetestSubArray {
	public int largestSum(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		int curMax = array[0];
		for(int i = 1; i < array.length; i++) {
			if(curMax > 0) {
				curMax = curMax + array[i];
			} else {
				curMax = array[i];
			}
		}
		return curMax;
	}
}
