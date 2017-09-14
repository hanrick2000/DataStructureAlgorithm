package com.laioffer.section4.binarytree;

import java.util.*;

import com.laioffer.customdatastructure.TreeNode;

public class InorderTraversalIterative {
	public List<Integer> inOrder(TreeNode root) {
		// Write your solution here.
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode helper = root;
		
		while(helper != null || !stack.isEmpty()) {
			if(helper != null) {
				stack.offerFirst(helper);
				helper = helper.left;
			} else {
				helper = stack.pollFirst();
				result.add(helper.key);
				helper = helper.right;
			}
		}
		return result;
	}
}
