package com.laioffer.section18.exerciseII;
import com.laioffer.customdatastructure.TreeNode;

public class SearchInBinarySearchTree {
	public TreeNode search(TreeNode root, int key) {
		while(root != null) {
			if(root.key == key) {
				return root;
			} else if(root.key < key) {
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return null;
	}
}
