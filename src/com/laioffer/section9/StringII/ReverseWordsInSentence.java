package com.laioffer.section9.StringII;

public class ReverseWordsInSentence {
	public String reverseWords(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] charArray = input.toCharArray();
		reverse(charArray, 0, charArray.length - 1);
		int start = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] != ' ' && (i == 0 || charArray[i - 1] == ' ')) {
				start = i;
			}

			if (charArray[i] != ' ' && (i == charArray.length - 1 || charArray[i + 1] == ' ')) {
				reverse(charArray, start, i);
			}
		}
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

	public static void main(String[] args) {
		ReverseWordsInSentence solution = new ReverseWordsInSentence();
		String input = "I love Google";
		String result = solution.reverseWords(input);
		System.out.print(result);
	}
}
