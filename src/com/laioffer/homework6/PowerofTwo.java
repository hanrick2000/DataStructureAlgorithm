package com.laioffer.homework6;

public class PowerofTwo {
// This solution is Timeout
//	public boolean isPowerOfTwo(int number) {
//		int result = 1;
//		while(result <= number) {
//			if(result == number) {
//				return true;
//			}
//			result = 2 * result;	
//		}
//		return false;
//	}
	
	public boolean isPowerOfTwo(int number) {
		int mask = 1;
		int count = 0;
		for(int i = 0; i < 32; i++) {
			if((number & mask) == 1) {
				count += 1;
			}
			number >>= 1;
		}
		return count == 1;
	}
	
	public static void main(String[] args) {
		PowerofTwo solution = new PowerofTwo();
		boolean result = solution.isPowerOfTwo(8);
		System.out.print(result);
	}
}
