package com.laioffer.section8.hashtableStringI;

public class RemoveAdjacentRepeatedCharactersI {
	public String deDup(String input) {
		if(input.length() == 0 || input == null) {
			return input;
		}
		char[] charArray = input.toCharArray();
		int endIndex = 0;
		for(int i = 0; i < charArray.length; i++) {
			if(i == 0 || charArray[i] != charArray[endIndex - 1]) {
				charArray[endIndex++] = charArray[i];
			}
		}
		
		return new String(charArray, 0, endIndex);
	}
	
	public static void main(String[] args) {
		RemoveAdjacentRepeatedCharactersI solution = new RemoveAdjacentRepeatedCharactersI();
		String result = solution.deDup("aabbcccccc");
		System.out.print(result);
	}
}
