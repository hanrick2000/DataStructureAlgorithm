package com.laioffer.homework2;

public class PowerofB {
	public double myPow(double x, int n) {
		if (n < 0) {
			return 1 / power(x, -n);
		} else {
			return power(x, n);
		}
	}

	public double power(double x, int n) {
		if (n == 0) {
			return 1;
		}

		double half = power(x, n / 2);

		return (n % 2 == 0) ? half * half : half * half * x;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerofB solution = new PowerofB();
		double result = solution.myPow(2.0000, -2147483648);
		System.out.println("The result is " + result);
	}

}

