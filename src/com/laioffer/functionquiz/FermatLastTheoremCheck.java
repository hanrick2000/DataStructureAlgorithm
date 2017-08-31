package com.laioffer.functionquiz;

public class FermatLastTheoremCheck {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FermatLastTheoremCheck solution = new FermatLastTheoremCheck();
		solution.check(2);
	}
	
	private void check(int n) {
		for(int i = 1; i < 100; i++) {
			for(int j = 1; j < 100; j++) {
				if(check(n, i, j)) {
					System.out.print("You have proved it!!");
					return;
				}
			}
		}
	}
	
	private boolean check(int n, int i, int j) {
		//1.0 is very important
		long c  = (long) Math.pow(Math.pow(i, n) + Math.pow(j, n), 1.0 / n);
		return Math.pow(c, n) == Math.pow(i, n) + Math.pow(j, n);
	}
	

}
