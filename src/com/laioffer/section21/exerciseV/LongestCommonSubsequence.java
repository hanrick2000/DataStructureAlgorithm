package com.laioffer.section21.exerciseV;

public class LongestCommonSubsequence {
	public int longest(String s, String t) {
		int[][] longest = new int[s.length() + 1][t.length() + 1];
		for(int i = 1; i <= s.length(); i++) {
			for(int j = 1; j <= t.length(); j++) {
				if(s.charAt(i - 1) == t.charAt(j - 1)) {
					longest[i][j] = longest[i - 1][j - 1] + 1;
				} else {
					longest[i][j] = Math.max(longest[i - 1][j], longest[i][j - 1]);
				}
			}
		}
		return longest[s.length()][t.length()];
	}
}
