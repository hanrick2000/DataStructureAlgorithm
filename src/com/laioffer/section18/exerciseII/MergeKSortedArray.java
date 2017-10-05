package com.laioffer.section18.exerciseII;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArray {
	static class Element {
		int x;
		int y;
		int value;
		
		Element(int x, int y, int value){
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	
	static class MyComparator implements Comparator<Element>{
		@Override
		public int compare(Element e1, Element e2) {
			if(e1.value == e2.value) {
				return 0;
			}
			
			return e1.value < e2.value ? -1 : 1;
		}
		
	}
	public int[] merge(int[][] arrayOfArrays) {
		PriorityQueue<Element> minHeap = new PriorityQueue<Element>(11, new MyComparator());
		int length = 0;
		for(int i = 0; i < arrayOfArrays.length; i++) {
			int[] array = arrayOfArrays[i];
			length += array.length;
			if(array.length != 0) {
				minHeap.offer(new Element(i, 0, array[0]));
			}
		}
		int[] result = new int[length];
		int cur = 0;
		while(!minHeap.isEmpty()) {
			Element temp = minHeap.poll();
			result[cur++] = temp.value;
			if(temp.y + 1 < arrayOfArrays[temp.x].length) {
				temp.y++;
				temp.value = arrayOfArrays[temp.x][temp.y];
				minHeap.offer(temp);
			}
		}
		return result;
	}
}
