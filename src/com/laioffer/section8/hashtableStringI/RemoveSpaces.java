package com.laioffer.section8.hashtableStringI;

public class RemoveSpaces {
	public String removeSpaces(String input) {
		if(input == null || input.length() == 0) {
			return input;
		}
		char[] charArray = input.toCharArray();
		int fastIndex = 0;
		int slowIndex = 0;
		int wordCount = 0;
		while(true) {
			while(fastIndex < charArray.length && charArray[fastIndex] == ' ') {
				fastIndex++;
			}
			
			if(fastIndex == charArray.length) {
				break;
			}
			if(wordCount > 0) {
				charArray[slowIndex++] = ' ';
			}
			while(fastIndex < charArray.length && charArray[fastIndex] != ' ' ) {
				charArray[slowIndex++] = charArray[fastIndex++];
			}
			wordCount++;
		}
		return new String(charArray, 0, slowIndex);
	}
	
	public static void main(String[] args) {
		RemoveSpaces solution = new RemoveSpaces();
		String input= "  I love     new York     ";
		String result = solution.removeSpaces(input);
		System.out.print(result);
	}
}
