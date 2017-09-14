package com.laioffer.section10.recurisivetwo;

public class StringAbbreviationMatching {
	public boolean match(String input, String pattern) {
		return matchHelper(input, pattern, 0 , 0);
	}
	
	private boolean matchHelper(String input, String pattern, int inputIndex, int patternIndex) {
		if(inputIndex == input.length() && patternIndex == pattern.length()) {
			return true;
		}
		
		if(inputIndex >= input.length() || patternIndex >= pattern.length()) {
			return false;
		}
		
		if(pattern.charAt(patternIndex) < '0' || pattern.charAt(patternIndex) > '9') {
			if(pattern.charAt(patternIndex) == input.charAt(inputIndex)) {
				matchHelper(input, pattern, inputIndex + 1, patternIndex + 1);
			}
			return false;
		}
		
		int count = 0;
		while(patternIndex < pattern.length() && pattern.charAt(patternIndex) >= '0' && pattern.charAt(patternIndex) <= '9') {
			count = count * 10 + (pattern.charAt(patternIndex) - '0');
			patternIndex++;
		}
		
		return matchHelper(input, pattern, inputIndex + count, patternIndex);
	}
}
