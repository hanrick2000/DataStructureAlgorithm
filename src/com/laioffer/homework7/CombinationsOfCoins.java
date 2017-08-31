package com.laioffer.homework7;

import java.util.*;

public class CombinationsOfCoins {
	public List<List<Integer>> combinations(int target, int[] coins) {
	    // Write your solution here.
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();
		combinationsHelper(target, coins, cur, 0, result);
	    return result;
	}
	
	private void combinationsHelper(int target, int[] coins, List<Integer> cur, int index, List<List<Integer>> result) {
		if(index == coins.length) {
			if(target == 0) {
			result.add(new ArrayList<Integer>(cur));
			}
			return;
		}
		
		for(int i = 0; i <= target / coins[index]; i++) {
			cur.add(i);
			combinationsHelper(target - i * coins[index], coins, cur, index + 1, result);
			cur.remove(cur.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		CombinationsOfCoins solution = new CombinationsOfCoins();
		int[] coins = {2,1};
		List<List<Integer>> result =  solution.combinations(4, coins);
		System.out.println(result);
		
	}
}
