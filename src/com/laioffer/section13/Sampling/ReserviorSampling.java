package com.laioffer.section13.Sampling;

public class ReserviorSampling {
	private int count;
	private Integer sample;
	public ReserviorSampling() {
		this.count = 0;
		this.sample = null;
	}

	public void read(int value) {
		// Write your implementation here.
		count++;
		int probality = (int)(Math.random() * count);
		if(probality == 0) {
			sample = value;
		}
	}

	public Integer sample() {
		// Write your implementation here.
		return sample;
	}
}
