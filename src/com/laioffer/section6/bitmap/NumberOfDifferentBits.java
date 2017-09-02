package com.laioffer.section6.bitmap;

public class NumberOfDifferentBits {
	public int diffBits(int a, int b) {
	    int diff = a ^ b;
	    //count how many 1 in diff
	    int count = 0;
	    int mask = 1;
	    for(int i = 0; i < 32; i++) {
	    			count += (mask & diff);
	    			diff >>= 1;
	    }
	    return count;
	}
	
	public static void main(String[] args) {
		NumberOfDifferentBits solution = new NumberOfDifferentBits();
		int result = solution.diffBits(5, 8);
		System.out.print(result);
	}
}
