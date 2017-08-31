package com.laioffer.homework2;
//This Method is about the recursive 
public class FibonacciDP {
	public long fibonacci(int k) {
	    // Write your solution here
		long a = 0; 
		long b = 1;
		if(k <= 0) {
			return 0;
		}
		
		while(k > 1) {
			long temp = a + b;
			a = b;
			b = temp;
			k--;
		}
		
		return b;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FibonacciDP solution = new FibonacciDP();
		long result = solution.fibonacci(100);
		System.out.println("The result of Fibonacci is " + result);		
	}
}


