package com.laioffer.section8.hashtableStringI;

public class OneStringAnotherSubstring {
	public int strstr(String large, String small) {
		if(small.length() == 0) {
			return 0;
		}
		
		if(large.length() < small.length()) {
			return -1;
		}
		
		for(int i = 0; i < large.length() - small.length() + 1; i++) {
			int j = 0;
			while(j < small.length()) {
				if(large.charAt(i) != small.charAt(j)) {
					break;
				}
				j++;
			}
			if(j == small.length()) {
				return i;
			}
			
		}
		return -1;
	}
}
