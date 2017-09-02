package com.laioffer.section8.hashtableStringI;

import java.util.*;

public class RemoveCertainString {
	public String remove(String input, String t) {
		if(t == null || t.length() == 0) {
			return input;
		}
		char[] inputArray = input.toCharArray();
		Set<Character> set = buildSet(t);
		int slowIndex = 0;
		for(int fastIndex = 0; fastIndex < inputArray.length; fastIndex++) {
			if(!set.contains(inputArray[fastIndex])) {
				inputArray[slowIndex++] = inputArray[fastIndex];
			}
		}	
		return new String(inputArray, 0, slowIndex);
	}
	
	private Set<Character> buildSet(String input){
		Set<Character> result = new HashSet<Character>();
		for(int i = 0; i < input.length(); i++) {
			result.add(input.charAt(i));
		}
		return result;
	}
}
