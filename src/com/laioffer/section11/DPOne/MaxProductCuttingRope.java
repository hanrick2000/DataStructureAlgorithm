package com.laioffer.section11.DPOne;

public class MaxProductCuttingRope {
	public int maxProduct(int length) {
		int[] M = new int[length + 1];
		M[1] = 0;
		M[2] = 1;
		for(int i = 3; i <= length; i++) {
			for(int j = 1; j < i; j++) {
				int temp = Math.max(j, M[j]) * (i - j);	
				M[i] = Math.max(temp, M[i]);
			}
		}
		return M[length];
	}
	
	public static void main(String[] args) {
		MaxProductCuttingRope solution = new MaxProductCuttingRope();
		int result = solution.maxProduct(12);
		System.out.print(result);
	}
}
