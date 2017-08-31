package com.laioffer.homework3;

import java.util.Stack;

public class StackWithMin {
	private Stack<Integer> originalStack;
	private Stack<Integer> minStack;

	public StackWithMin() {
		originalStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	

	public int pop() {
		if(originalStack.empty()) {
			return -1;
		}
		int result = originalStack.pop();
		if(minStack.peek() == result) {
			minStack.pop();
		}
		
		return result;
	}

	public void push(int element) {
		originalStack.push(element);
		if(minStack.empty() || minStack.peek() >= element) {
			minStack.push(element);
		}
	}

	public int top() {
		if(originalStack.empty()) {
			return -1;
		}
		return originalStack.peek();
	}

	public int min() {
		if(minStack.empty()) {
			return -1;
		}
		return minStack.peek();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackWithMin solution = new StackWithMin();
		solution.push(1);
		solution.push(5);
		solution.push(4);
		solution.push(6);
		System.out.println(solution.top());
		System.out.println(solution.min());

	}
}
