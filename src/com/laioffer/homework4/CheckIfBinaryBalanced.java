package com.laioffer.homework4;

import com.laioffer.customdatastructure.TreeNode;

public class CheckIfBinaryBalanced {
	public boolean isBalanced(TreeNode root) {
	    // Write your solution here.
		if(root == null) {
			return true;
		}
		
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		if(Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		}
	    return isBalanced(root.left) && isBalanced(root.right);
	  }
	
	public int getHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
}
