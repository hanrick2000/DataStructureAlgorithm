package com.laioffer.section24.finalexam;

import com.laioffer.customdatastructure.TreeNode;

public class CheckIfCousinsDFS {
	public boolean ifCousins(TreeNode root, TreeNode node1, TreeNode node2) {
		if(root == null || node1 == null || node2 == null || node1 == node2) {
			return false;
		}
		boolean[] areCousins = new boolean[1];
		isCousin(root, node1, node2, 0, areCousins);
		return areCousins[0];
	}
	
	private int isCousin(TreeNode root, TreeNode node1, TreeNode node2, int level, boolean[] areCousins) {
		if(root == null) {
			return -1;
		}
		if(root == node1 || root == node2) {
			return level;
		}
		int left = isCousin(root.left, node1, node2, level + 1, areCousins);
		int right = isCousin(root.right, node1, node2, level + 1, areCousins);
		
		if(left == right && left - 1 > level) {
			areCousins[0] = true;
		}
		
		return left > right ? left : right;
	}
}
