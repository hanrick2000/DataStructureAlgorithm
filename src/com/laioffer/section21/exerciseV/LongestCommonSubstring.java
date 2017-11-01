package com.laioffer.section21.exerciseV;

public class LongestCommonSubstring {
	public String longestCommon(String s, String t) {
		int m = s.length();
		int n = t.length();
		int start = 0;
		int resultLength = 0;
		int[][] commonHelper = new int[m][n];
		
		for(int i = 0 ; i < m; i++) {
			for(int j = 0 ; j < n; j++) {
				if(s.charAt(i) == t.charAt(j)) {
					if(i == 0 || j == 0) {
						commonHelper[i][j] = 1;
					} else {
						commonHelper[i][j] = commonHelper[i - 1][j - 1] + 1;
					}
					
					if(commonHelper[i][j] > resultLength) {
						resultLength = commonHelper[i][j];
						start = i - resultLength + 1;
					}
					
				}
			}
		}
		return s.substring(start, start + resultLength);
	}
	
	public static void main(String[] args) {
		LongestCommonSubstring solution = new LongestCommonSubstring();
		String result = solution.longestCommon("abc", "bc");
		System.out.println(result);
	}
}
