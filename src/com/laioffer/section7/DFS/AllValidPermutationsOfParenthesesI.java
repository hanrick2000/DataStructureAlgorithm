package com.laioffer.section7.DFS;

import java.util.*;

public class AllValidPermutationsOfParenthesesI {
	public List<String> validParentheses(int n) {
	    List<String> result = new ArrayList<String>();
	    if(n == 0) {
	    	return result;
	    }
	    char[] cur = new char[n * 2];
	    validParenthesesHelper(cur, 0, n, n, result);
	    return result;
	  }
	private void validParenthesesHelper(char[] cur, int index, int left, int right, List<String> result) {
		if(left == 0 && right == 0) {
			result.add(new String(cur));
			return;
		}
		
		if(left > 0) {
			cur[index] = '(';
			validParenthesesHelper(cur, index + 1, left - 1, right, result);
		} 
		
		if (right > left) {
			cur[index] = ')';
			validParenthesesHelper(cur, index + 1, left, right - 1, result);
		}
	}
	
	public static void main(String[] args) {
		AllValidPermutationsOfParenthesesI solution = new AllValidPermutationsOfParenthesesI();
		List<String> result =  solution.validParentheses(3);
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		
	}
}
