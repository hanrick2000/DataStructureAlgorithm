package com.laioffer.section20.exerciseIV;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsInThreeSortedArray {
	public List<Integer> common(int[] a, int[] b, int[] c) {
		// Write your solution here.
		List<Integer> result = new ArrayList<>();
		int aIndex = 0;
		int bIndex = 0;
		int cIndex = 0;
		while(aIndex < a.length && bIndex < b.length && cIndex < c.length) {
			if(a[aIndex] == b[bIndex] && b[bIndex] == c[cIndex]) {
				result.add(a[aIndex++]);
				bIndex++;
				cIndex++;
			} else if(a[aIndex] <= b[bIndex] && a[aIndex] <= c[cIndex]) {
				aIndex++;
			} else if(b[bIndex] <= a[aIndex] && b[bIndex] <= c[cIndex]) {
				bIndex++;
			} else {
				cIndex++;
			}
		}
		return result;
	}
}
