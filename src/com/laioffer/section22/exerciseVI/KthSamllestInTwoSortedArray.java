package com.laioffer.section22.exerciseVI;

public class KthSamllestInTwoSortedArray {
	public int kth(int[] a, int[] b, int k) {
		if(k > a.length + b.length) {
			return -1;
		}
		return findkth(a, 0, b, 0, k);
	}
	private int findkth(int[] a, int aIndex, int[] b, int bIndex, int k) {
		if(aIndex >= a.length) {
			return b[bIndex + k - 1];
		}
		if(bIndex >= b.length) {
			return a[aIndex + k - 1];
		}
		if(k == 1) {
			return Math.min(a[aIndex], b[bIndex]);
		}
		
		int amidIndex = aIndex + k / 2 - 1;
		int bmidIndex = bIndex + k / 2 - 1;
		
		int amidval = amidIndex >= a.length ? Integer.MAX_VALUE : a[amidIndex];
		int bmidval = bmidIndex >= b.length ? Integer.MAX_VALUE : b[bmidIndex];
		
		if(amidval <= bmidval) {
			return findkth(a, amidIndex + 1, b, bIndex, k - k / 2);
		} else {
			return findkth(a, aIndex, b, bmidIndex + 1, k - k / 2);
		}
	}
}
