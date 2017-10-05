package com.laioffer.section17.middtermII;

import com.laioffer.customdatastructure.TreeNode;

public class MaximumPathSumBinaryTreeI {
	public int maxPathSum(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int[] maxSum = new int[]{Integer.MIN_VALUE};
		maxPathSumHelper(root, maxSum);
		return maxSum[0];
	}
	
	private int maxPathSumHelper(TreeNode root, int[] maxSum) {
		if(root == null) {
			return 0;
		}
		
		int left = maxPathSumHelper(root.left, maxSum);
		int right = maxPathSumHelper(root.right, maxSum);
		
		if(root.left != null && root.right != null) {
			maxSum[0] = Math.max(maxSum[0], left + right + root.key);
			return Math.max(left, right) + root.key;
		}
		
		return root.left == null ? right + root.key : left + root.key;
	}
}
