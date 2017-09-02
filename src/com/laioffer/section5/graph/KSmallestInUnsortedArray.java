package com.laioffer.section5.graph;

import java.util.PriorityQueue;

public class KSmallestInUnsortedArray {
	public int[] kSmallest(int[] array, int k) {
		//use the minHeap to solve this problem
		if(array == null || array.length == 0 || k > array.length) {
			return array;
		}
		if(k <= 0) {
			return null;
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
		
		for(int i = 0; i < array.length; i++) {
			minHeap.add(array[i]);
		}
		int[] result = new int[k];
		for(int i = 0; i < k; i++) {
			result[i] = minHeap.poll();
		}
		return result;
	}
	
	public static void main(String[] args) {
		KSmallestInUnsortedArray solution = new KSmallestInUnsortedArray();
		int[] array = {2,3,4,5,1,2,7};
		int[] result = solution.kSmallest(array, 4);
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
