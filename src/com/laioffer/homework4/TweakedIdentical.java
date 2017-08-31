package com.laioffer.homework4;

import com.laioffer.customdatastructure.TreeNode;

public class TweakedIdentical {
	
	public boolean isTweakedIdentical(TreeNode left, TreeNode right) {
		
		if(left == null && right == null) {
			return true;
		} else if(left == null || right == null) {
			return false;
		} else if(left.key != right.key) {
			return false;
		}
		
		
		return isTweakedIdentical(left.left, right.left) && isTweakedIdentical(left.right, right.right) ||
			   isTweakedIdentical(left.right, right.left) && isTweakedIdentical(left.left, right.right)	;
	}
}




