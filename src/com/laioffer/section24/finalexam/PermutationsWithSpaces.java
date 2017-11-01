package com.laioffer.section24.finalexam;

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithSpaces {
	public List<String> permutations(String input) {
		List<String> result = new ArrayList<>();
		if(input == null || input.length() == 0) {
			return result;
		}
		StringBuilder cur = new StringBuilder();
		dfsHelper(input, result, cur, 0);
		return result;
	}
	
	private void dfsHelper(String input, List<String> result, StringBuilder cur, int index) {
		if(index == input.length() - 1) {
			cur.append(input.charAt(index));
			result.add(cur.toString());
			cur.deleteCharAt(cur.length() - 1);
			return;
		}
		cur.append(input.charAt(index));
		cur.append(" ");
		dfsHelper(input, result, cur, index + 1);
		cur.deleteCharAt(cur.length() - 1);
		dfsHelper(input, result, cur, index + 1);
		cur.deleteCharAt(cur.length() - 1);
	}
	
}
