package com.laioffer.section7.DFS;
import java.util.*;

public class SubsetsI {
	public List<String> subSets(String set){
		if(set.length() == 0) {
			return null;
		}
		List<String> result = new ArrayList<String>();
		StringBuilder currentSet = new StringBuilder();
		char[] arraySet = set.toCharArray();
		subSetsHelper(arraySet, currentSet, 0, result);
		return result;
	}
	
	private void subSetsHelper(char[] arraySet, StringBuilder currentSet, int index, List<String> result) {
		if(index == arraySet.length) {
			result.add(currentSet.toString());
			return;
		}
		
		subSetsHelper(arraySet, currentSet, index + 1, result);
		subSetsHelper(arraySet, currentSet.append(arraySet[index]), index + 1, result);
		currentSet.deleteCharAt(currentSet.length() - 1);
	}
	
	public static void main(String[] args) {
		SubsetsI solution = new SubsetsI();
		String test = "abc";
		List<String> result =  solution.subSets(test);
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		
	}
}
