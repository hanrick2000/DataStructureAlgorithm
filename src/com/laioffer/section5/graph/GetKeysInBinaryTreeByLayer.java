package com.laioffer.section5.graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.laioffer.customdatastructure.TreeNode;

public class GetKeysInBinaryTreeByLayer {
	public List<List<Integer>> LayerByLayer(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) {
			return result; 
		}
		Queue<TreeNode> layer = new LinkedList<TreeNode>();
		layer.offer(root);
		while(!layer.isEmpty()) {
			int size = layer.size();
			List<Integer> curLayer = new ArrayList<Integer>();
			for(int i = 0; i < size; i++) {
				TreeNode cur = layer.poll();
				curLayer.add(cur.key);
				if(cur.left != null) {
					layer.offer(cur.left);
				}
				if(cur.right != null) {
					layer.offer(cur.right);
				}
			}
			result.add(curLayer);
		}
		return result;
	}
}
