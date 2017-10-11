package com.laioffer.section18.exerciseII;

public class CuttingWoodI {
	public int minCost(int[] cuts, int length) {
		int[] helperCuts = new int[cuts.length + 2];
		helperCuts[0] = 0;
		for(int i = 1; i <= cuts.length; i++) {
			helperCuts[i] = cuts[i - 1];
		}
		helperCuts[helperCuts.length - 1] = length;
		int[][] minCost = new int[helperCuts.length][helperCuts.length];
		for(int end = 1; end < helperCuts.length; end++) {
			for(int start = end - 1; start >= 0; start--) {
				if(start + 1 == end) {
					minCost[start][end] = 0;
				} else {
					minCost[start][end] = Integer.MAX_VALUE;
					for(int k = start + 1; k < end; k++) {
						minCost[start][end] = Math.min(minCost[start][end], minCost[start][k] + minCost[k][end]);
					}
					minCost[start][end] = minCost[start][end] + (helperCuts[end] - helperCuts[start]);
				}
			}
		}
		return minCost[0][helperCuts.length - 1];
	}
}
