package com.laioffer.section20.exerciseIV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumAllPairsI {
	public List<List<Integer>> allPairs(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int i = 0; i < array.length; i++) {
			List<Integer> indexes = map.get(target - array[i]);
			if(indexes != null) {
				for(int index : indexes) {
					result.add(Arrays.asList(index, i));
				}
			}
			if(!map.containsKey(array[i])) {
				map.put(array[i], new ArrayList<Integer>());
			}
			map.get(array[i]).add(i);
		}
		return result;
	}
}
