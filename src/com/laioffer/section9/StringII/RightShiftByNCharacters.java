package com.laioffer.section9.StringII;

public class RightShiftByNCharacters {
	public String rightShift(String input, int n) {
		if(input.length() <= 1 || input == null || n == input.length()) {
			return input;
		}
		
		if(n > input.length()) {
			n %= input.length();
		}
		char[] charArray = input.toCharArray();
		reverse(charArray, 0, charArray.length - 1 - n);
		reverse(charArray, charArray.length - n, charArray.length - 1);
		reverse(charArray, 0, charArray.length - 1);
		
		return new String(charArray);
	}
	
	private void reverse(char[] charArray, int i, int j) {
		while (i < j) {
			char temp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = temp;
			i++;
			j--;
		}
	}
}
