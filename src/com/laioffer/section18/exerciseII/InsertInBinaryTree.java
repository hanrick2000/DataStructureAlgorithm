package com.laioffer.section18.exerciseII;

import com.laioffer.customdatastructure.TreeNode;

public class InsertInBinaryTree {
	public TreeNode insert(TreeNode root, int key) {
		if(root == null) {
			root = new TreeNode(key);
			return root;
		}
		TreeNode parent = null;
		TreeNode curNode = root;
		TreeNode insertNode = new TreeNode(key);
		while(curNode != null) {
			parent = curNode;
			if(key > curNode.key) {
				curNode = curNode.right;
			} else if(key < curNode.key) {
				curNode = curNode.left;
			} else {
				return root;
			}
		}
		if(parent.key > key) {
			parent.left = insertNode;
		} else if(parent.key < key) {
			parent.right = insertNode;
		}
		
		return root;
	}
}
