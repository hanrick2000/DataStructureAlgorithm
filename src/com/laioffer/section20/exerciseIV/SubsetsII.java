package com.laioffer.section20.exerciseIV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	public List<String> subSets(String set) {
		List<String> result = new ArrayList<>();
		if(set == null || set.length() == 0) {
			return result;
		}
		char[] charSet = set.toCharArray();
		Arrays.sort(charSet);
		StringBuilder sb = new StringBuilder();
		subSetHelper(charSet, sb, 0, result);
		return result;	
	}
	
	private void subSetHelper(char[] charSet, StringBuilder sb, int index, List<String> result) {
		if(index == charSet.length) {
			result.add(sb.toString());
			return;
		}
		subSetHelper(charSet, sb.append(charSet[index]), index + 1, result);
		sb.deleteCharAt(sb.length() - 1);
		
		while(index < charSet.length - 1 && charSet[index] == charSet[index + 1]) {
			index++;
		}
		subSetHelper(charSet, sb, index + 1, result);	
	}
}
