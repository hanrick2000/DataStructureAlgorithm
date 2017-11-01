package com.laioffer.section20.exerciseIV;

import com.laioffer.customdatastructure.TreeNode;

public class ReverseBinaryTreeUpsideDown {
	public TreeNode reverse(TreeNode root) {
		if(root == null || root.left == null) {
			return root;
		}
		
		TreeNode newRoot = reverse(root.left);
		root.left.left = root.right;
		root.right = null;
		root.left.right = root;
		root.left = null;
		return newRoot;
	}
}
