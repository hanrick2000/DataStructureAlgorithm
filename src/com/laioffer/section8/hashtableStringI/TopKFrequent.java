package com.laioffer.section8.hashtableStringI;

import java.util.*;

public class TopKFrequent {
	public String[] topKFrequent(String[] combo, int k) {
		if(combo.length == 0) {
			return new String[0];
		}
		Map<String, Integer> freqMap = getFreqMap(combo);
		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<Map.Entry<String, Integer>>(k, new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				if(e1.getValue() == e2.getValue()) {
					return 0;
				} else if(e1.getValue() > e2.getValue()){
					return 1;
				} else {
					return -1;
				}
			}
		});
		
		for(Map.Entry<String, Integer> entry: freqMap.entrySet()) {
			if(minHeap.size() < k) {
				minHeap.offer(entry);
			} else if(entry.getValue() > minHeap.peek().getValue()) {
				minHeap.poll();
				minHeap.offer(entry);
			}
		}
		return freqArray(minHeap);
	}
	
	private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
		String[] result = new String[minHeap.size()];
		for(int i = minHeap.size() - 1; i >= 0; i--) {
			result[i] = minHeap.poll().getKey();
		}
		return result;
	}
	
	private Map<String, Integer> getFreqMap(String[] combo) {
		Map<String, Integer> freqMap = new HashMap<>();
		for(String s : combo) {
			Integer freq = freqMap.get(s);
			if(freq == null) {
				freqMap.put(s, 1);
			} else {
				freqMap.put(s, freq + 1);
			}
		}
		return freqMap;
	}
	
	public static void main(String[] args) {
		TopKFrequent solution = new TopKFrequent();
		String[] test = {"a", "a", "b", "b", "b", "b", "c", "c", "c", "d"};
		String[] result =  solution.topKFrequent(test, 2);
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
	}
}
