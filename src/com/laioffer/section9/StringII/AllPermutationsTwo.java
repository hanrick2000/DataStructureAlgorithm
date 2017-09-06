package com.laioffer.section9.StringII;

import java.util.*;

public class AllPermutationsTwo {
	public List<String> permutations(String set) {
		List<String> result = new ArrayList<>();
		if(set == null) {
			return result;
		}
		char[] inputSet = set.toCharArray();
		permutationHelper(inputSet, 0, result);
		return result;
	}
	
	private void permutationHelper(char[] inputSet, int index, List<String> result) {
		if(index == inputSet.length) {
			result.add(new String(inputSet));
			return;
		}
		
		Set<Character> usedSet = new HashSet<>();
		for(int i = index; i < inputSet.length; i++) {
			if(usedSet.add(inputSet[i])) {
				swap(inputSet, i, index);
				permutationHelper(inputSet, index + 1, result);
				swap(inputSet, i, index);
			}
		}
	}
	
	private void swap(char[] input, int i, int j) {
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	public static void main(String[] args) {
		AllPermutationsTwo solution = new AllPermutationsTwo();
		String input = "abb";
		List<String> result = solution.permutations(input);
		System.out.println(result);
	}
}
