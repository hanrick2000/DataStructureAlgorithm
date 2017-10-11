package com.laioffer.section19.exerciseIII;

import java.util.*;

import com.laioffer.customdatastructure.TreeNode;

public class PathSumToTargetBinaryTreeII {
	public boolean exist(TreeNode root, int target) {
		if(root == null) {
			return false;
		}
		
		List<TreeNode> path = new ArrayList<>();
		return helper(root, path, target);
	}
	
	private boolean helper(TreeNode root, List<TreeNode> path, int target) {
		path.add(root);
		int temp = 0;
		for(int i = path.size() - 1; i >= 0; i--) {
			temp += path.get(i).key;
			if(temp == target) {
				return true;
			}
		}
		
		if(root.left != null && helper(root.left, path, target)) {
			return true;
		}
		if(root.right != null && helper(root.right, path, target)) {
			return true;
		}
		
		path.remove(path.size() - 1);
		
		return false;
	}
}
