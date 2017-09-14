package com.laioffer.section4.binarytree;

import java.util.*;
import com.laioffer.customdatastructure.TreeNode;

public class PostorderTraversalIterative {
	public List<Integer> postOrder(TreeNode root) {
		// Write your solution here.
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode prevNode = null;
		stack.offerFirst(root);
		
		while(!stack.isEmpty()) {
			TreeNode curNode = stack.peekFirst();
			if(prevNode == null || prevNode.left == curNode || prevNode.right == curNode) {
				if(curNode.left != null) {
					stack.offerFirst(curNode.left);
				} else if(curNode.right != null) {
					stack.offerFirst(curNode.right);
				} else {
					result.add(curNode.key);
					stack.pollFirst();
				}
			} else if (prevNode == curNode.left) {
				if(curNode.right != null) {
				stack.offerFirst(curNode.right);
				} else {
					result.add(curNode.key);
					stack.pollFirst();
				}
			} else {
				result.add(curNode.key);
				stack.pollFirst();
			}
			
			prevNode = curNode;
		}
		
		return result;
	}
}
