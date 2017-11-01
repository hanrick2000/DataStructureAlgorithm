package com.laioffer.section21.exerciseV;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestProductOfLength {
	static class Cell{
		String s1;
		String s2;
		int index1;
		int index2;
		int product;
		
		Cell(String s1, String s2, int index1, int index2){
			this.s1 = s1;
			this.s2 = s2;
			this.index1 = index1;
			this.index2 = index2;
			this.product = s1.length() * s2.length();
		}
	}
	public int largestProduct(String[] dict) {
		Arrays.sort(dict, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return 0;
				}
				return s1.length() > s2.length() ? -1 : 1;
			}
		});
		PriorityQueue<Cell> maxHeap = new PriorityQueue<Cell>(11, new Comparator<Cell>() {
			public int compare(Cell c1, Cell c2) {
				if(c1.product == c2.product) {
					return 0;
				}
				return c1.product > c2.product ? -1 : 1;
			}
		});
		maxHeap.offer(new Cell(dict[0], dict[1], 0, 1));
		while(!maxHeap.isEmpty()){
			Cell cur = maxHeap.poll();
			if(qualifyNonCommon(cur)) {
				return cur.product;
			} 
			if(cur.index1 + 1 < dict.length) {
				maxHeap.offer(new Cell(dict[cur.index1 + 1], dict[cur.index2], cur.index1 + 1, cur.index2));
			}
			if(cur.index2 + 1 < dict.length) {
				maxHeap.offer(new Cell(dict[cur.index1], dict[cur.index2 + 1], cur.index1, cur.index2 + 1));
			}
		}
		return 0;
	}
	
	private boolean qualifyNonCommon(Cell cur) {
		String s1 = cur.s1;
		String s2 = cur.s2;
		int s1Mask = 0;
		int s2Mask = 0;
		for(int i = 0; i < s1.length(); i++) {
			s1Mask |= 1 << (s1.charAt(i) - 'a');
		}
		for(int i = 0; i < s2.length(); i++) {
			s2Mask |= 1 << (s2.charAt(i) - 'a');
		}
		
		return (s1Mask & s2Mask) == 0;
	}
}
