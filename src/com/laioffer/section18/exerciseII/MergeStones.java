package com.laioffer.section18.exerciseII;

public class MergeStones {
	public int minCost(int[] stones) {
		int length = stones.length;
		if(length == 1) {
			return 0;
		}
		
		int[][] cost = new int[length][length];
		int[][] subSum = new int[length][length];
		for(int end = 0; end < length; end++) {
			for(int start = end; start >= 0; start--) {
				if(end == start) {
					cost[start][end] = 0;
					subSum[start][end] = stones[start];
				} else {
					subSum[start][end] = subSum[start][end - 1] + stones[end];
					cost[start][end] = Integer.MAX_VALUE;
					for(int k = start; k < end; k++) {
						cost[start][end] = Math.min(cost[start][end], cost[start][k] + cost[k + 1][end] + subSum[start][end]);
					}
				}
			}
		}
		return cost[0][length - 1];
	}
}
