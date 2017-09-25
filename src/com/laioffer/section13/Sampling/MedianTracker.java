package com.laioffer.section13.Sampling;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianTracker {
	private PriorityQueue<Integer> smallerHalf;
	private PriorityQueue<Integer> largerHalf;

	public MedianTracker() {
		largerHalf = new PriorityQueue<Integer>();
		smallerHalf = new PriorityQueue<Integer>(11, Collections.reverseOrder());
		// add new fields and complete the constructor if necessary.
	}

	public void read(int value) {
		// write your implementation here.
		if (smallerHalf.isEmpty() || value <= (int)smallerHalf.peek()) {
			smallerHalf.offer(value);
		} else {
			largerHalf.offer(value);
		}

		if (smallerHalf.size() - largerHalf.size() >= 2) {
			largerHalf.offer(smallerHalf.poll());
		} else if (smallerHalf.size() < largerHalf.size()) {
			smallerHalf.offer(largerHalf.poll());
		}
	}

	public Double median() {
		// write your implementation here.
		int size = smallerHalf.size() + largerHalf.size();
		if (size == 0) {
			return null;
		} else if (size % 2 != 0) {
			return (double) ((int)smallerHalf.peek());
		} else {
			return ((int)smallerHalf.peek() + (int)largerHalf.peek()) / 2.0;
		}
	}
}
