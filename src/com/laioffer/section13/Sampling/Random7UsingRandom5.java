package com.laioffer.section13.Sampling;

public class Random7UsingRandom5 {
	double random5 = Math.random() * 5;
	public int random7() {
		while(true) {
			int random25 = (int)(5 * random5 + random5);
			if(random25 < 21) {
				return random25 % 7;
			}
		}
	}
}
