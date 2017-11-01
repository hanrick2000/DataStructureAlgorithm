package com.laioffer.section19.exerciseIII;

import com.laioffer.customdatastructure.TreeNode;

public class ReconstructBTInPost {
	public TreeNode reconstruct(int[] post) {
		int[] index = new int[] {post.length - 1};
		return reconstructHelper(post, index, Integer.MIN_VALUE);
	}
	
	private TreeNode reconstructHelper(int[] post, int[] index, int min) {
		if(index[0] < 0 || post[index[0]] <= min) {
			return null;
		}
		
		TreeNode root = new TreeNode(post[index[0]--]);
		root.right = reconstructHelper(post, index, root.key);
		root.left = reconstructHelper(post, index, min);
		
		return root;
	}
}
