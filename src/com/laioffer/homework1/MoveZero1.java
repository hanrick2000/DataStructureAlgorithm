package com.laioffer.homework1;

public class MoveZero1 {
	public int[] moveZero(int[] array) {
	    // Write your solution here.
		if(array == null || array.length == 0) {
			return array;
		}
		
		if(array.length == 1) {
			return array;
		}
		int insertPosition = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] != 0) {
				array[insertPosition++] = array[i];
			}
		}
		
		while(insertPosition < array.length) {
			array[insertPosition++] = 0;
		}
	    return array;
	  }  
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveZero1 solution = new MoveZero1();
		int[] array = { 6,6,6,0,6,6 };
		int[] result = solution.moveZero(array);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
