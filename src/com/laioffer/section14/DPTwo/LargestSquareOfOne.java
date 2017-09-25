package com.laioffer.section14.DPTwo;

public class LargestSquareOfOne {
	public int largest(int[][] matrix) {
		int N = matrix.length;
		if(N == 0) {
			return 0;
		}
		int result = 0;
		int[][] largest = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == 0 || j == 0) {
					largest[i][j] = matrix[i][j] == 0 ? 0 : 1;
				} else if(matrix[i][j] == 1) {
					largest[i][j] = Math.min(largest[i - 1][j] + 1, largest[i][j - 1] + 1);
					largest[i][j] = Math.min(largest[i][j], largest[i - 1][j - 1] + 1);
				} else {
					largest[i][j] = 0;
				}
				result = Math.max(result, largest[i][j]);
			}
		}
		return result;
	}
}
