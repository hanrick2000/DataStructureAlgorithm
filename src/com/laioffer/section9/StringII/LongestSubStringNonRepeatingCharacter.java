package com.laioffer.section9.StringII;

import java.util.*;

public class LongestSubStringNonRepeatingCharacter {
	public int longest(String input) {
		if(input.length() == 0) {
			return 0;
		}
		Set<Character> characterSet = new HashSet<>();
		int slowIndex = 0;
		int fastIndex = 0;
		int longest = 0;
		
		while(fastIndex < input.length()) {
			if(characterSet.contains(input.charAt(fastIndex))) {
				characterSet.remove(input.charAt(slowIndex++));
			} else {
			characterSet.add(input.charAt(fastIndex++));
			longest = Math.max(longest, fastIndex - slowIndex);
			}
		}
		return longest;
	}
}
