package com.laioffer.section18.exerciseII;

import com.laioffer.customdatastructure.TreeNode;

public class LargestNumberSmallerInBinaryTree {
	public int largestSmaller(TreeNode root, int target) {
		int result = Integer.MIN_VALUE;
		while(root != null) {
			if(root.key < target) {
				result = root.key;
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return result;
	}
}
