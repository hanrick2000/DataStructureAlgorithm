package com.laioffer.homework4;

import com.laioffer.customdatastructure.TreeNode;

public class SymmetricBinaryTree {
	public boolean isSymmetric(TreeNode root) {
		// Write your solution here.
		if(root == null) {
			return true;
		}
		return isSysmmeticHelper(root.left, root.right);
	}
	
	private boolean isSysmmeticHelper(TreeNode left, TreeNode right) {
		
		if(left == null && right == null) {
			return true;
		} else if(left == null || right == null) {
			return false;
		} else if(left.key != right.key) {
			return false;
		}
		
		
		return isSysmmeticHelper(left.left, right.right) && isSysmmeticHelper(left.right, right.left);
	}
}
