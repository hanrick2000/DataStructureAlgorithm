package com.laioffer.section4.binarytree;

import java.util.ArrayList;
import java.util.List;

import com.laioffer.customdatastructure.TreeNode;

public class InorderTraversal {
	public List<Integer> inOrder(TreeNode root) {
		// Write your solution here.
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) {
			return result; 
		}
		
		List<Integer> left = inOrder(root.left);
		List<Integer> right = inOrder(root.right);
		
	
		result.addAll(left);
		result.add(root.key);
		result.addAll(right);
		return result;
	}
}
