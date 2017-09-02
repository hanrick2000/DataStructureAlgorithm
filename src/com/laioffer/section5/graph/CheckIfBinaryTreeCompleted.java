package com.laioffer.section5.graph;

import java.util.*;

import com.laioffer.customdatastructure.TreeNode;

public class CheckIfBinaryTreeCompleted {
	public boolean isCompleted(TreeNode root) {
		// Write your solution here.
		if(root == null) {
			return true;
		}
		Queue<TreeNode> curNodes = new LinkedList<TreeNode>();
		boolean flag = false;
		//if the flag is set to true, there should not be any nodes have children after this node
		// no matter this level or next level
		curNodes.offer(root);
		while(!curNodes.isEmpty()) {
			TreeNode cur = curNodes.poll();
			if(cur.left == null) {
				flag = true;
			}else if(flag) {
				return false;
			}else {
				curNodes.offer(cur.left);
			}
			
			if(cur.right == null) {
				flag = true;
			}else if(flag) {
				return false;
			}else {
				curNodes.offer(cur.right);
			}
		}
		return true;
	}
}
