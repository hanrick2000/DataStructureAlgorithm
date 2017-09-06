package com.laioffer.section9.StringII;

public class Reorder {
	public int[] reorder(int[] array) {
		if(array.length % 2 == 0) {
			reorderHelper(array, 0, array.length - 1);
		} else {
			reorderHelper(array, 0, array.length - 2);
		}
		return array;
	}
	public void reorderHelper(int[] array, int start, int end) {
		int length = end - start + 1;
		if(length <= 2) {
			return;
		}
		
		int mid = start + length / 2;
		int startmid = start + length / 4;
		int endmid = start + 3 * length / 4;
		
		reverse(array, startmid, mid - 1);
		reverse(array, mid, endmid - 1);
		reverse(array, startmid, endmid - 1);
		
		reorderHelper(array, start, start + (startmid - start) * 2 - 1);
		reorderHelper(array, start + (startmid - start) * 2, end);
	}
	
	public void reverse(int[] array, int start, int end) {
		while(start < end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}
}
