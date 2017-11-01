package com.laioffer.section24.finalexam;

public class CheckIfChainedCircle {
	public boolean ifCircle(String[] input) {
		if(input == null || input.length <= 1) {
			return false;
		}
		
		return dfsHelper(input, 0);
	}
	
	private boolean dfsHelper(String[] input, int index) {
		//base case 
		if(index == input.length) {
			return (input[index - 1].charAt(input[index - 1].length() - 1) == input[0].charAt(0));
		}
		for(int i = index; i < input.length; i++) {
			if(index == 0 || input[i].charAt(0) == input[index - 1].charAt(input[index - 1].length() - 1)) {
				swap(input, index, i);
				if(dfsHelper(input, index + 1)) {
					return true;
				}
				swap(input, i, index);
			}
		}
		return false;
	}
	
	private void swap(String[] input, int i, int j) {
		String temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
