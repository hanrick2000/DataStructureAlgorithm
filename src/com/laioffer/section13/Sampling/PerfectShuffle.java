package com.laioffer.section13.Sampling;

public class PerfectShuffle {
	public void shuffle(int[] array) {
	    // Write your solution here.
		if(array.length <= 1) {
			return;
		}
		for(int i = array.length; i >= 1; i--) {
			int idx = (int)(Math.random() * i);
			swap(array, i - 1, idx);
		}
	  }
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
