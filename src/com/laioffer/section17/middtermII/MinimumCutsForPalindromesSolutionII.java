package com.laioffer.section17.middtermII;

public class MinimumCutsForPalindromesSolutionII {
	public int minCuts(String input) {
		if (input == null || input.length() <= 1) {
			return 0;
		}
		int length = input.length();
		boolean[][] isPalidorm = new boolean[length][length];
		int[] minCuts = new int[input.length()];
		for (int i = 1; i < input.length(); i++) {
			minCuts[i] = i;

			for (int j = i; j >= 0; j--) {
				if (input.charAt(j - 1) == input.charAt(i - 1)) {
					isPalidorm[j][i] = i - j < 2 || isPalidorm[j + 1][i - 1];
				}
				if (isPalidorm[j][i]) {
					minCuts[i] = Math.min(minCuts[i], minCuts[j - 1] + 1);
				}
			}
		}
		return minCuts[minCuts.length - 1];
	}
}
