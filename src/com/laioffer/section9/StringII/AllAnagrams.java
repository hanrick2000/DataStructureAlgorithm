package com.laioffer.section9.StringII;

import java.util.*;

public class AllAnagrams {
	public List<Integer> allAnagrams(String s, String l) {
		List<Integer> result = new ArrayList<>();
		if(l.length() == 0 || s.length() > l.length()) {
			return result;
		}
		Map<Character, Integer> charMap = countMap(s);
		int match = 0;
		for(int i = 0; i < l.length(); i++) {
			char temp = l.charAt(i);
			Integer count = charMap.get(temp);
			if(count != null) {
				charMap.put(temp, --count);
				if(count == 0) {
					match++;
				}
			}
			
			if(i >= s.length()) {
				temp = l.charAt(i - s.length());
				count = charMap.get(temp);
				if(count != null) {
					charMap.put(temp, ++count);
					if(count == 1) {
						match--;
					}
				}
			}
			
			if(match == charMap.size()) {
				result.add(i - s.length() + 1);
			}
		}
		return result;
	}
	
	private Map<Character, Integer> countMap(String s) {
		Map<Character, Integer> charMap = new HashMap<>();
		for(char ch : s.toCharArray()) {
			Integer count = charMap.get(ch);
			if(count == null) {
				charMap.put(ch, 1);
			} else {
				charMap.put(ch, ++count);
			}
		}
		return charMap;
	}
	
}
