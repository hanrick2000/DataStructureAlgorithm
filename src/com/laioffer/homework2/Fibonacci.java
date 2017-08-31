package com.laioffer.homework2;
//This Method is about the recursive 
public class Fibonacci {
	public long fibonacci(int k) {
	    // Write your solution here
		if(k < 0) {
			return 0;
		}
		
		if(k <= 1) {
			return k;
		}
		
		return fibonacci(k - 1) + fibonacci(k - 2);
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci solution = new Fibonacci();
		long result = solution.fibonacci(40);
		System.out.println("The result of Fibonacci is " + result);		
	}
}


