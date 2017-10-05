package com.laioffer.section17.middtermII;

public class MinimumCutsForPalindromes {
	public int minCuts(String input) {
		if(input == null || input.length() <= 1) {
			return 0;
		}
		
		int[] minCuts = new int[input.length()];
		for(int i = 1; i < input.length(); i++) {
			minCuts[i] = i;
			
			for(int j = i; j >= 0; j--) {
				if(isPalindrome(input, j, i)) {
					if(j == 0) {
						minCuts[i] = 0;
					} else {
						minCuts[i] = Math.min(minCuts[i], minCuts[j - 1] + 1);
					}
				}
			}
		}
		return minCuts[minCuts.length - 1];
	}
	
	private boolean isPalindrome(String input, int start, int end) {
		while(start <= end) {
			if(input.charAt(start) == input.charAt(end)) {
				start++;
				end--;
			} else {
				return false;
			}
		}
		return true;
	}
}
