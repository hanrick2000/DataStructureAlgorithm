package com.laioffer.homework4;

import java.util.*;

import com.laioffer.customdatastructure.TreeNode;

public class PostorderTraversal {
	public List<Integer> postOrder(TreeNode root) {
	    // Write your solution here.
	    List<Integer> result = new ArrayList<Integer>();
			if(root == null) {
				return result; 
			}
			
			List<Integer> left = postOrder(root.left);
			List<Integer> right = postOrder(root.right);
			

			result.addAll(left);
			result.addAll(right);
			result.add(root.key);
			return result;
	  }
}
