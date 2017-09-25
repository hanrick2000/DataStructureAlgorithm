package com.laioffer.section13.Sampling;

public class Random1000UsingRandom5 {
	double random5 = Math.random() * 5;
	public int random1000() {
		// Write your solution here.
		// you can use RandomFive.random5() for generating
		// 0 - 4 with equal probability.
		while (true) {
			int random = 0;
			for(int i = 0; i < 5; i++) {
				random = (int)(5 * random + random5); 
			}
			if(random < 3000) {
				return random % 1000;
			}
		}
	}
}
