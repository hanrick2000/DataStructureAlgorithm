package com.laioffer.section8.hashtableStringI;

public class MissingNumberI {
	public int missing(int[] array) {
		if(array == null || array.length == 0) {
			return 1;
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
	
	public static void main(String[] args) {
		MissingNumberI solution = new MissingNumberI();
		int[] array = {1,2,4,5,6,7,8};
		int missingNumber = solution.missing(array);
		System.out.print(missingNumber);
	}
}
