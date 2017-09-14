package com.laioffer.section10.recurisivetwo;

import com.laioffer.customdatastructure.TreeNode;

public class LowestCommonAncestorOne {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		if(root == null) {
			return root;
		}
		
		if(root == one || root == two) {
			return root;
		}
		
		TreeNode lowestLeft = lowestCommonAncestor(root.left, one, two);
		TreeNode lowestRight = lowestCommonAncestor(root.right, one, two);
		
		if(lowestLeft != null && lowestRight != null) {
			return root;
		}
		return lowestLeft == null ? lowestRight : lowestLeft;
	}
}
