package com.laioffer.section10.recurisivetwo;

import java.util.*;

public class NQueens {
	public List<List<Integer>> nqueens(int n){
		List<List<Integer>> result = new ArrayList<>();
		if(n == 0) {
			return result;
		}
		List<Integer> cur = new ArrayList<>();
		nqueensHelper(n, cur, result);
		return result;
	}
	
	private void nqueensHelper(int n, List<Integer> cur, List<List<Integer>> result) {
		if(cur.size() == n) {
			result.add(new ArrayList<>(cur));
			return;
		}
		for(int i = 0; i < n; i++) {
			if(valid(cur, i)) {
				cur.add(i);
				nqueensHelper(n, cur, result);
				cur.remove(cur.size() - 1);
			}
		}
	}
	
	private boolean valid(List<Integer> cur, int column) {
		int row = cur.size();
		for(int i = 0; i < row; i++) {
			if(cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		NQueens solution = new NQueens();
		List<List<Integer>> result = solution.nqueens(1);
		System.out.println(result);
	}
}
