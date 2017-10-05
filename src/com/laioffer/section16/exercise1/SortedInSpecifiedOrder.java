package com.laioffer.section16.exercise1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortedInSpecifiedOrder {
	static class MyComparator implements Comparator<Integer> {
		private Map<Integer, Integer> map;
		public MyComparator(int[] array) {
			map = new HashMap<>();
			for(int i = 0; i < array.length; i++) {
				map.put(array[i], i);
			}
		}
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			Integer index1 = map.get(o1);
			Integer index2 = map.get(o2);
			if(index1 != null && index2 != null) {
				return index1.compareTo(index2);
			} else if(index1 == null && index2 == null) {
				return o1.compareTo(o2);
			}
			return index1 != null ? -1 : 1;
		}
		
	}
	public int[] sortSpecial(int[] array1, int[] array2) {
		Integer[] orderArray = toIntegerArray(array1);
		Arrays.sort(orderArray, new MyComparator(array2));
		toIntArray(orderArray, array1);
		return array1;
	}
	
	private void toIntArray(Integer[] array, int[] result) {
		for(int i = 0; i < array.length; i++) {
			result[i] = array[i];
		}
	}
	private Integer[] toIntegerArray(int[] array) {
		Integer[] result = new Integer[array.length];
		for(int i = 0; i < array.length; i++) {
			result[i] = array[i];
		}
		return result;
	}
}
