package com.laioffer.section16.exercise1;

import java.util.*;

import com.laioffer.customdatastructure.TreeNode;

public class GetKeysInBinaryTreeLayerByLayerZigZagOrder {
	public List<Integer> zigZag(TreeNode root) {
	    // Write your solution here.
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		
		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		deque.offer(root);
		int layer = 0;
		while(!deque.isEmpty()) {
			int size = deque.size();
			for(int i = 0; i < size; i++) {
				if(layer == 0) {
					TreeNode temp = deque.pollLast();
					result.add(temp.key);
					if(temp.right != null) {
						deque.offerFirst(temp.right);
					}
					if(temp.left != null) {
						deque.offerFirst(temp.left);
					}
				} else {
					TreeNode temp = deque.pollFirst();
					result.add(temp.key);
					if(temp.left != null) {
						deque.offerLast(temp.left);
					}
					if(temp.right != null) {
						deque.offerLast(temp.right);
					}
				}
			}
			
			layer = (layer == 1) ? 0 : 1;
		}
	    return result;
	  }
}
