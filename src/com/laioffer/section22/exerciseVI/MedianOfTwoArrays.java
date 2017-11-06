package com.laioffer.section22.exerciseVI;

import java.util.Arrays;

public class MedianOfTwoArrays {
	public double median(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		int totalLength = a.length + b.length;
		if (totalLength % 2 == 1) {
			return findKth(a, 0, b, 0, totalLength / 2 + 1);
		}
		return (findKth(a, 0, b, 0, totalLength / 2) + findKth(a, 0, b, 0, totalLength / 2 + 1)) / 2.0;
	}

	private double findKth(int[] a, int aIndex, int[] b, int bIndex, int k) {
		if (aIndex >= a.length) {
			return b[bIndex + k - 1];
		}

		if (bIndex >= b.length) {
			return a[aIndex + k - 1];
		}

		if (k == 1) {
			return Math.min(a[aIndex], b[bIndex]);
		}

		int amidIndex = aIndex + k / 2 - 1;
		int bmidIndex = bIndex + k / 2 - 1;

		int amidValue = amidIndex >= a.length ? Integer.MAX_VALUE : a[amidIndex];
		int bmidValue = bmidIndex >= b.length ? Integer.MAX_VALUE : b[bmidIndex];

		if (amidValue <= bmidValue) {
			return findKth(a, amidIndex + 1, b, bIndex, k - k / 2);
		} else {
			return findKth(a, aIndex, b, bmidIndex + 1, k - k / 2);
		}
	}
}
