package com.laioffer.section24.finalexam;

import java.util.*;

import com.laioffer.customdatastructure.TreeNode;

public class CheckIfCousinsBFS {
	public boolean areCousins(TreeNode root, TreeNode node1, TreeNode node2) {
		if(root == null || node1 == null || node2 == null || node1 == node2) {
			return false;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int counter = 0;
			TreeNode curNode = queue.poll();
			if(curNode.left == node1 && curNode.right == node2 ||
			   curNode.left == node2 && curNode.right == node1) {
				return false;
			}
			for(int i = 0; i < size; i++) {
				if(curNode.left != null) {
					if(curNode.left == node1 || curNode.left == node2) {
						counter++;
					}
					queue.offer(curNode.left);
				}
				if(curNode.right != null) {
					if(curNode.right == node1 || curNode.right == node2) {
						counter++;
					}
					queue.offer(curNode.right);
				}	
			}
			if(counter == 1) {
				return false;
			}
			if(counter == 2) {
				return true;
			}
		}
		return false;
	}
}
