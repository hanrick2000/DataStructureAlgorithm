package com.laioffer.homework7;

import java.util.*;

public class AllPermutationsI {
	public List<String> permutations(String set){
		List<String> result = new ArrayList<String>();
		if(set == null) {
			return result;
		}
		char[] arraySet = set.toCharArray();
		permutationsHelper(arraySet, 0, result);
		return result;
	}
	
	private void permutationsHelper(char[] arraySet, int index, List<String> result) {
		if(index == arraySet.length) {
			result.add(new String(arraySet));
			return;
		}
		
		for(int i = index; i < arraySet.length; i++) {
			swap(arraySet, index, i);
			permutationsHelper(arraySet, index + 1, result);
			swap(arraySet, index, i);
		}
	}
	
	private void swap(char[] arraySet, int i, int j) {
		char temp = arraySet[i];
		arraySet[i] = arraySet[j];
		arraySet[j] = temp;
	}
	public static void main(String[] args) {
		AllPermutationsI solution = new AllPermutationsI();
		String test = "abc";
		List<String> result =  solution.permutations(test);
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		
	}
}
