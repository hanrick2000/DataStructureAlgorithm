package com.laioffer.section14.DPTwo;

import java.util.HashSet;
import java.util.Set;

public class DictionaryWordOne {
	public boolean canBreak(String input, String[] dict) {
		// Write your solution here.
		Set<String> dictSet = toSet(dict);
		boolean[] M = new boolean[input.length() + 1];
		M[0] = false;
		for(int i = 1; i < M.length; i++) {
			if(dictSet.contains(input.substring(0, i))) {
				M[i] = true;
				continue;
			}
			for(int j = 0; j < i; j++) {
				if(M[j] && dictSet.contains(input.substring(j, i))) {
					M[i] = true;
					break;
				}
			}
		}
		return M[M.length - 1];
		
	}
	private Set<String> toSet(String[] dict){
		Set<String> set = new HashSet<>();
		for(String s : dict) {
			set.add(s);
		}
		return set;
	}
}
