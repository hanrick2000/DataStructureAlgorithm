package com.laioffer.section6.bitmap;

public class HexadecimalRepresentation {
	public String hex(int number) {
	    // Write your solution here.
		if(number == 0) {
			return "0x0";
		}
		StringBuilder result = new StringBuilder();
		while(number != 0) {
			int mod = number % 16;
			number = number / 16;
			if(mod < 10) {
				result.append((char)(mod + '0'));
			} else {
				result.append((char)(mod - 10 + 'A'));
			}
		}
		
		result.append("x0");
		return result.reverse().toString();
	}
	
	public static void main(String[] args) {
		HexadecimalRepresentation solution = new HexadecimalRepresentation();
		String result = solution.hex(16);
		System.out.print(result);
	}
}
