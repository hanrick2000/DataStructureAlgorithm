package com.laioffer.section15.DPThree;

public class LargestSubMatrixSum {
	public int largest(int[][] matrix) {
		// Write your solution here.
		int row = matrix.length;
		int column = matrix[0].length;
		int result = Integer.MIN_VALUE;
		for(int i = 0 ; i < row; i++) {
			int[] cur = new int[column];
			for(int j = i; j < row; j++) {
				add(cur, matrix[j]);
				result = Math.max(result, max(cur));
			}
		}
		return result;
	}
	
	private void add(int[] cur, int[] add) {
		for(int i = 0; i < cur.length; i++) {
			cur[i] += add[i];
		}
	}
	
	private int max(int[] cur) {
		int result = cur[0];
		int temp = cur[0];
		for(int i = 1; i < cur.length; i++) {
			if(temp > 0) {
				temp = temp + cur[i];
			} else {
				temp = cur[i];
			}
			result = Math.max(result, temp);
		}
		return result;
	}
}
