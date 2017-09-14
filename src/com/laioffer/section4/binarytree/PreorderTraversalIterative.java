package com.laioffer.section4.binarytree;

import java.util.*;

import com.laioffer.customdatastructure.TreeNode;

public class PreorderTraversalIterative {
	public List<Integer> preOrder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) {
			return result; 
		}
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.offerFirst(root);
		while(!stack.isEmpty()) {
			TreeNode curNode = stack.pollFirst();
			result.add(curNode.key);
			if(curNode.right != null) {
				stack.offerFirst(curNode.right);
			}
			if(curNode.left != null) {
				stack.offerFirst(curNode.left);
			}	
		}
		return result;
	}
}
