package com.laioffer.section24.finalexam;

public class SplitSquareNumber {
	public int minSplit(int num) {
		if(num == 1) {
			return 1;
		}
		int[] dp = new int[num + 1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i <= num; i++) {
			dp[i] = i;
			for(int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
			}
		}
		return dp[num];
	}
}
