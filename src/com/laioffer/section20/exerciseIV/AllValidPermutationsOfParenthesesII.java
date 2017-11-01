package com.laioffer.section20.exerciseIV;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AllValidPermutationsOfParenthesesII {
	private static final char[] Paththeses = new char[] {'(', ')', '[',']', '{','}'};
	public static void main(String[] args) {
		AllValidPermutationsOfParenthesesII solution = new AllValidPermutationsOfParenthesesII();
		List<String> result = solution.validParentheses(2,1,0);
		System.out.print(result);
	}
	public List<String> validParentheses(int l, int m, int n){
		List<String> result = new ArrayList<>();
		int[] remain = new int[] {l, l, m, m, n, n};
		int length = 2 * (l + m + n);
		StringBuilder sb = new StringBuilder();
		Deque<Character> charStack = new LinkedList<>();
		permutationHelper(sb, charStack, remain, length, result);
		return result;
	}
	
	private void permutationHelper(StringBuilder sb, Deque<Character> charStack, int[] remain, int length, List<String> result) {
		if(sb.length() == length) {
			result.add(sb.toString());
			return;
		}
		
		for(int i = 0; i < remain.length; i++) {
			if(i % 2 == 0) {
				if(remain[i] > 0) {
					sb.append(Paththeses[i]);
					charStack.offerFirst(Paththeses[i]);
					remain[i]--;
					permutationHelper(sb, charStack, remain, length, result);
					sb.deleteCharAt(sb.length() - 1);
					charStack.pollFirst();
					remain[i]++;
				}
			} else {
				if(!charStack.isEmpty() && charStack.peekFirst() == Paththeses[i - 1]) {
					sb.append(Paththeses[i]);
					charStack.pollFirst();
					remain[i]--;
					permutationHelper(sb, charStack, remain, length, result);
					sb.deleteCharAt(sb.length() - 1);
					charStack.offerFirst(Paththeses[i - 1]);
					remain[i]++;
				}
			}
		}
	}
}
