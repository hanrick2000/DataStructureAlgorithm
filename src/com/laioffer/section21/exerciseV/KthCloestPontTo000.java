package com.laioffer.section21.exerciseV;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Comparator;

public class KthCloestPontTo000 {
	public List<Integer> cloest(int[] a, int[] b, int[]c, int k) {
		PriorityQueue<List<Integer>> minHeap = new PriorityQueue<List<Integer>>(2 * k, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> l1, List<Integer> l2) {
				long d1 = distance(l1, a, b, c);
				long d2 = distance(l2, a, b, c);
				if(d1 == d2) {
					return 0;
				}
				return d1 < d2 ? -1 : 1;
			}
		});
		Set<List<Integer>> visited = new HashSet<>();
		List<Integer> cur = Arrays.asList(0, 0 ,0);
		minHeap.offer(cur);
		visited.add(cur);
		while(k > 0) {
			cur = minHeap.poll();
			List<Integer> curList = Arrays.asList(cur.get(0) + 1, cur.get(1) ,cur.get(2));
			if(curList.get(0) < a.length && visited.add(curList)) {
				minHeap.offer(curList);
			}
			curList = Arrays.asList(cur.get(0), cur.get(1) + 1,cur.get(2));
			if(curList.get(1) < b.length && visited.add(curList)) {
				minHeap.offer(curList);
			}
			curList = Arrays.asList(cur.get(0), cur.get(1),cur.get(2) + 1);
			if(curList.get(2) < c.length && visited.add(curList)) {
				minHeap.offer(curList);
			}
			k--;
		}
		cur.set(0,  a[cur.get(0)]);
		cur.set(1,  b[cur.get(1)]);
		cur.set(2,  c[cur.get(2)]);
		return cur;
	}
	
	private long distance(List<Integer> point, int[] a, int[] b, int[] c) {
		long dist = 0;
		dist += a[point.get(0)] * a[point.get(0)];
		dist += b[point.get(1)] * b[point.get(1)];
		dist += c[point.get(2)] * c[point.get(2)];
		return dist;
	}
}
