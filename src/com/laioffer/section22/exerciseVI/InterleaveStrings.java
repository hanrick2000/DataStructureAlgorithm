package com.laioffer.section22.exerciseVI;

public class InterleaveStrings {
	public boolean canMerge(String a, String b, String c) {
		int alen = a.length();
		int blen = b.length();
		int clen = c.length();
		if(alen + blen != clen) {
			return false;
		}
		
		boolean[][] canMerge = new boolean[alen + 1][blen + 1];
		for(int i = 0; i < alen + 1; i++) {
			for(int j = 0; j < blen + 1; j++) {
				if(i == 0 && j == 0) {
					canMerge[i][j] = true;
				}
				
				if(i > 0 && a.charAt(i - 1) == c.charAt(i + j - 1)) {
					canMerge[i][j] |= canMerge[i - 1][j];
				}
				if(j > 0 && b.charAt(j - 1) == c.charAt(i + j - 1)) {
					canMerge[i][j] |= canMerge[i][j - 1];
				}
			}
		}
		return canMerge[alen][blen];
	}
}
