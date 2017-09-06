package com.laioffer.section10.recurisivetwo;

import java.util.*;

public class SpiralOrderTrverseOne {
	public List<Integer> spiral(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if(matrix.length == 0 && matrix[0].length == 0) {
			return result;
		}
		spiralHelper(matrix, 0, matrix.length, result);
		return result;
	}
	
	private void spiralHelper(int[][] matrix, int offset, int size, List<Integer> result) {
		if(size == 0) {
			return;
		}
		if(size == 1) {
			result.add(matrix[offset][offset]);
			return;
		}
		//left top to right top
		for(int i = 0; i < size - 1; i++) {
			result.add(matrix[offset][offset + i]);
		}
		//right top to right bottom
		for(int i = 0; i < size - 1; i++) {
			result.add(matrix[offset + i][offset + size - 1]);
		}
		
		//right bottom to left bottom
		for(int i = size - 1; i > 0; i--) {
			result.add(matrix[offset + size - 1][offset + i]);
		}
		
		//left bottom to left top
		for(int i = size - 1; i > 0; i--) {
			result.add(matrix[offset + i][offset]);
		}
		spiralHelper(matrix, offset + 1, size - 2, result);
	}
	
	public static void main(String[] args) {
		SpiralOrderTrverseOne solution = new SpiralOrderTrverseOne();
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		List<Integer> result = solution.spiral(matrix);
		System.out.print(result);
	}
}
