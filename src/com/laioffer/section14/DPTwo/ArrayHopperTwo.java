package com.laioffer.section14.DPTwo;

public class ArrayHopperTwo {
	public int minJump(int[] array) {
		// Write your solution here.
		int length = array.length;
		int[] minJump = new int[length];
		minJump[array.length - 1] = 0;
		for (int i = length - 2; i >= 0; i--) {
			if (array[i] == 0) {
				minJump[i] = -1;
			} else if (array[i] >= length - i - 1) {
				minJump[i] = 1;
			} else {
				int min = minJump[i + 1];
				for (int j = i + 1; j <= i + array[i]; j++) {
					if (minJump[j] != -1 && minJump[j] < min) {
						min = minJump[j];
					}
				}
				if(min != -1) {
					minJump[i] = min + 1;
				} else {
					minJump[i] = min;
				}
				
			}
		}
		return minJump[0];
	}
	
	public static void main(String[] args) {
		ArrayHopperTwo solution = new ArrayHopperTwo();
		int[] input = new int[] {2,1,0, 3,1};
		int result = solution.minJump(input);
		System.out.print(result);
	}
}
