package com.laioffer.section18.exerciseII;

import com.laioffer.customdatastructure.TreeNode;

public class DeleteInBinarySearchTree {
	public TreeNode delete(TreeNode root, int key) {
		if(root == null) {
			return root;
		}
		
		if(root.key < key) {
			root.right = delete(root.right, key);
		} else if(root.key > key) {
			root.left = delete(root.left, key);
		} else {
			if(root.left == null) {
				return root.right;
			}
			if(root.right == null) {
				return root.left;
			}
			TreeNode smallest = findSmallest(root.right);
			root.key = smallest.key;
			root.right = delete(root.right, smallest.key);
		}
		
		return root;
	}
	
	private TreeNode findSmallest(TreeNode root) {
		while(root != null) {
			root = root.left;
		}
		return root;
	}
}
