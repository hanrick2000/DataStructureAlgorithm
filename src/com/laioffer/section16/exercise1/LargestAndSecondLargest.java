package com.laioffer.section16.exercise1;

import java.util.ArrayList;
import java.util.List;

public class LargestAndSecondLargest {
	static class Element{
		int value;
		List<Integer> comparedValues;
		
		Element(int value){
			this.value = value;
			this.comparedValues = new ArrayList<>();
		}
	}
	public int[] largestAndSecond(int[] array) {
		if(array == null) {
			return array;
		}
		
		Element[] helperArray = convert(array);
		int length = array.length;
		while(length > 1) {
			compareAndSwap(helperArray, length);
			length = (length + 1) / 2;
		}
		return new int[] {helperArray[0].value, largest(helperArray[0].comparedValues)};
	}
	
	private int largest(List<Integer> list) {
		int max = list.get(0);
		for(int i : list) {
			max = Math.max(i, max);
		}
		return max;
	}
	private void compareAndSwap(Element[] array, int length) {
		for(int i = 0; i < length / 2; i++) {
			if(array[i].value < array[length - i - 1].value) {
				swap(array, i, length - i - 1);
			}
			array[i].comparedValues.add(array[length - i - 1].value);
		}
	}
	
	private void swap(Element[] array, int i, int j) {
		Element temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	}
	private Element[] convert(int[] array) {
		Element[] helper = new Element[array.length];
		for(int i = 0; i < array.length; i++) {
			helper[i] = new Element(array[i]);
		}
		
		return helper;
	}
}
