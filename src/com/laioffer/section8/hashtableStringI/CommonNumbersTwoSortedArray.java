package com.laioffer.section8.hashtableStringI;

import java.util.*;

public class CommonNumbersTwoSortedArray {
	public List<Integer> common(List<Integer> A, List<Integer> B) {
		List<Integer> result = new ArrayList<Integer>();
		int AIndex = 0;
		int BIndex = 0;
		
		while(AIndex < A.size() && BIndex < B.size()) {
			if(A.get(AIndex) == B.get(BIndex)) {
				result.add(A.get(AIndex));
				AIndex++;
				BIndex++;
			} else if(A.get(AIndex) < B.get(BIndex)) {
				AIndex++;
			} else {
				BIndex++;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		CommonNumbersTwoSortedArray solution = new CommonNumbersTwoSortedArray();
		List<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(5);
		A.add(6);
		List<Integer> B = new ArrayList<Integer>();
		B.add(2);
		B.add(3);
		List<Integer> result = solution.common(A, B);
		System.out.print(result);
	}
}
