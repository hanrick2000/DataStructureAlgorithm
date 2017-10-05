package com.laioffer.section16.exercise1;

import java.util.*;

import com.laioffer.customdatastructure.TreeNode;

public class LowestCommonAncestorIV {
	public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
	    // Write your solution here.
		Set<TreeNode> nodesSet = new HashSet<>(nodes);
	    return LCAHelper(root, nodesSet);
	  }
	
	private TreeNode LCAHelper(TreeNode root, Set<TreeNode> nodesSet) {
		if(root == null) {
			return null;
		}
		
		if(nodesSet.contains(root)) {
			return root;
		}
		
		TreeNode leftNode = LCAHelper(root.left, nodesSet);
		TreeNode rightNode = LCAHelper(root.right, nodesSet);
		
		return leftNode != null ? leftNode : rightNode;
	}
}
