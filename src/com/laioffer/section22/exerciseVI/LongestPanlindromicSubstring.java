package com.laioffer.section22.exerciseVI;

public class LongestPanlindromicSubstring {
	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		int length = s.length();
		int max = 1;
		boolean[][] dp = new boolean[length][length];
		String result = "";
		for (int k = 0; k < length; k++) {
			for (int i = 0; i < length - k; i++) {
				int j = i + k;
				if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
					dp[i][j] = true;

					if (j - i + 1 > max) {
						max = j - i + 1;
						result = s.substring(i, j + 1);
					}
				}
			}
		}

		return result;
	}
}
