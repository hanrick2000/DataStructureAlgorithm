package com.laioffer.homework6;

public class UniqueCharactersII {
	public boolean allUnique(String word) {
		// write your solution here
		if(word.length() == 0 || word == null) {
			return false;
		}
		int[] dict = new int[8];
		int mask = 1;
		
		for(int i = 0; i < word.length(); i++) {
			int current = word.charAt(i);
			int column = current % 32;
			int row = current / 32;
			int shift = (mask << column);
			if((shift & dict[row]) != 0) {
				return false;
			} else {
				dict[row] |= shift;
			} 	
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		UniqueCharactersII solution = new UniqueCharactersII();
		boolean result = solution.allUnique("aasscc");
		System.out.println("The result is " + result);
	}
}
