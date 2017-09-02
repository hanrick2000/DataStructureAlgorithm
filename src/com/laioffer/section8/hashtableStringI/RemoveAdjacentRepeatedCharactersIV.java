package com.laioffer.section8.hashtableStringI;

public class RemoveAdjacentRepeatedCharactersIV {
	public String deDup(String input) {
		// Write your solution here.
		if(input == null || input.length() <= 1) {
			return input;
		}
		char[] charArray = input.toCharArray();
		int slowIndex = 0;
		for(int fastIndex = 1; fastIndex < charArray.length; fastIndex++) {
			if(slowIndex == -1 || charArray[fastIndex] != charArray[slowIndex]) {
				charArray[++slowIndex] = charArray[fastIndex];
			} else {
				slowIndex--;
				while(fastIndex + 1 < charArray.length && charArray[fastIndex] == charArray[fastIndex + 1]) {
					fastIndex++;
				}
			}
			
		}
		return new String(charArray, 0, slowIndex + 1);
	}
	
	public static void main(String[] args) {
		RemoveAdjacentRepeatedCharactersIV solution = new RemoveAdjacentRepeatedCharactersIV();
		String input = "acccacb";
		String result = solution.deDup(input);
		System.out.print(result);
	}
}
