package com.laioffer.homework1;

import java.util.Arrays;

public class MoveZero {
	public int[] moveZero(int[] array) {
	    // Write your solution here.
		if(array == null || array.length == 0) {
			return array;
		}
		
		if(array.length == 1) {
			return array;
		}
		
		int mid = array.length / 2;
		int[] left = Arrays.copyOfRange(array, 0, mid);
		int[] right = Arrays.copyOfRange(array, mid, array.length);
		
		left = moveZero(left);
		right = moveZero(right);
		
		array = combine(left, right);
	    return array;
	  }  
	
	private int[] combine(int[] left, int[] right) {
		int[] combined = new int[left.length + right.length];
		int leftIndex = 0;
		int rightIndex = 0;
		int combinedIndex = 0;
		
		while(leftIndex < left.length && rightIndex < right.length) {
			if(left[leftIndex] != 0) {
				combined[combinedIndex++] = left[leftIndex++];
			} else if(right[rightIndex] != 0) {
				combined[combinedIndex++] = right[rightIndex++];
			} else {
				break;
			}		
		}
		
		while(leftIndex < left.length) {
			combined[combinedIndex++] = left[leftIndex++];
		}
			
		while(rightIndex < right.length) {
			combined[combinedIndex++] = right[rightIndex++];
		}
		
		
		return combined;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveZero solution = new MoveZero();
		int[] array = { 6,6,6,0,6,6 };
		int[] result = solution.moveZero(array);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
