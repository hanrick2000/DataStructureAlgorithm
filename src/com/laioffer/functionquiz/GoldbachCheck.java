package com.laioffer.functionquiz;

public class GoldbachCheck {
	public static void main(String[] args) {
		GoldbachCheck solution = new GoldbachCheck();
		solution.check();
	}
	
	private void check() {
		for(int i = 4; i < 100000000 ; i+=2) {
			if(checkEvenIsPrime(i)) {
				System.out.print("You have Proved it!!");
				break;
			}
			if(i % 10000 == 0) {
				System.out.print("Holds <=" + i);
			}
		}
	}
	private boolean checkEvenIsPrime(int n) {
		for(int i = 2; i <= n / 2; i++) {
			if(isPrime(i) && isPrime(n - i)) {
				return true;
			}	
		}
		return false;
	}
	private boolean isPrime(int n) {
		for(int i = n ; i * i < n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
