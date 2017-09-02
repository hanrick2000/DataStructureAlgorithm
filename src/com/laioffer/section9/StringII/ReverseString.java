package com.laioffer.section9.StringII;

public class ReverseString {
	public String reverseString(String input) {
		if(input.length() <= 1) {
			return input;
		}
		
		char[] charArray = input.toCharArray();
		for(int i = 0; i < charArray.length / 2; i++) {
			swap(charArray, i, charArray.length - 1 - i);
		}
		
		return new String(charArray);
	}
	
	private void swap(char[] charArray, int i, int j) {
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
	}
}
