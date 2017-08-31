package com.laioffer.homework4;

import java.util.ArrayList;
import java.util.List;

import com.laioffer.customdatastructure.TreeNode;

public class PreorderTraversal {
	public List<Integer> preOrder(TreeNode root) {
		// Write your solution here.
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) {
			return result; 
		}
		
		List<Integer> left = preOrder(root.left);
		List<Integer> right = preOrder(root.right);
		
		result.add(root.key);
		result.addAll(left);
		result.addAll(right);
		return result;
	}
}
