package com.laioffer.homework3;
import java.util.Stack;


public class QueueByTwoStacks {
	private Stack<Integer> in;
	private Stack<Integer> out;

	public QueueByTwoStacks() {
		in = new Stack<Integer>();
		out = new Stack<Integer>();
	}

	public Integer poll() {
		if (out.empty()) {
			move();
		}
		return out.empty() ? null : out.pop();
	}

	public void offer(int element) {
		in.push(element);
	}

	public Integer peek() {
		if (out.empty()) {
			move();
		}
		return out.empty() ? null : out.peek();
	}

	private void move() {
		while (!in.empty()) {
			out.push(in.pop());
		}
	}

	public int size() {
		return in.size() + out.size();
	}

	public boolean isEmpty() {
		return in.size() == 0 && out.size() == 0;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueByTwoStacks solution = new QueueByTwoStacks();
		solution.offer(2);
		solution.offer(3);
		solution.offer(4);
		solution.offer(5);
		System.out.println(solution.size());
		System.out.println(solution.isEmpty());
		System.out.println(solution.poll());
		System.out.println(solution.peek());
	}
}
