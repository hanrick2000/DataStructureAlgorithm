package com.laioffer.section18.exerciseII;

import com.laioffer.customdatastructure.TreeNode;

public class CloestNumberInBinarySearchTree {
	public int cloest(TreeNode root, int target) {
		int result = root.key;
		while(root != null) {
			if(root.key == target) {
				return root.key;
			} else {
				if(Math.abs(root.key - target) < Math.abs(result - target)) {
					result = root.key;
				}
				if(root.key < target) {
					root = root.right;
				} else {
					root = root.left;
				}
			}
		}
		return result;
	}
}
