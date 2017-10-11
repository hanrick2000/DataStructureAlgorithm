package com.laioffer.section19.exerciseIII;

import com.laioffer.customdatastructure.TreeNode;

public class MaxPathSumBinaryTreeII {
	public int maxPathSum(TreeNode root) {
		int[] max = new int[]{Integer.MIN_VALUE};
		helperMax(root, max);
		return max[0];
	}
	
	private int helperMax(TreeNode root, int[] max) {
		if(root == null) {
			return 0;
		}
		
		int left = helperMax(root.left, max);
		int right = helperMax(root.left, max);
		
		left = left < 0 ? 0 : left;
		right = right < 0 ? 0 : right;
		max[0] = Math.max(max[0], left + right + root.key);
		return root.key + Math.max(left, right);
	}
}
