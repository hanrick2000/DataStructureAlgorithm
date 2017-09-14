package com.laioffer.section10.recurisivetwo;

public class SpiralGenerate {
	public int[][] spiralGenerate(int m, int n){
		int[][] result = new int[m][n];
		if(m == 0 || n == 0) {
			return result;
		}
		int num = 1;
		int left = 0;
		int right = n - 1;
		int top = 0;
		int down = m - 1;
		while(left < right && top < down) {
			for(int i = left; i <= right; i++) {
				result[top][i] = num++;
			}
			
			for(int i = top + 1; i <= down - 1; i++) {
				result[i][right] = num++;
			}
			
			for(int i = right; i >= left; i--) {
				result[down][i] = num++;
			}
			
			for(int i = down - 1; i >= top + 1; i--) {
				result[i][left] = num++;
			}
			
			left++;
			right--;
			top++;
			down--;
		}
		
		if(left > right || top > down) {
			return result;
		}
		
		if(left == right) {
			for(int i = top; i <= down; i++) {
				result[i][left] = num++;
			}
		} else {
			for(int i = left; i <= right; i++) {
				result[top][i] = num++;
			}
		}
		
		
		return result;
	}
}
