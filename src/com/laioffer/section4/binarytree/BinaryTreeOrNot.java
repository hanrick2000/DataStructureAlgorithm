package com.laioffer.section4.binarytree;

import com.laioffer.customdatastructure.TreeNode;

public class BinaryTreeOrNot {
	public boolean isBST(TreeNode root) {
		return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBSTHelper(TreeNode root, int min, int max) {
		if(root == null) {
			return true;
		}
		if(root.key < min || root.key > max) {
			return false;
		}
		
		return isBSTHelper(root.left, min, root.key - 1) && 
				isBSTHelper(root.right, root.key + 1, max);
	}
}
