package com.laioffer.section19.exerciseIII;

import java.util.HashMap;
import java.util.Map;

import com.laioffer.customdatastructure.TreeNode;

public class ReconstructBTInPre {
	public TreeNode reconstruct(int[] in, int[] pre) {
		Map<Integer, Integer> inIndexMap = indexMap(in);
		return reconstructHelper(in, 0, in.length - 1, pre, 0, pre.length - 1, inIndexMap);
	}
	
	private Map<Integer, Integer> indexMap(int[] in){
		Map<Integer, Integer> inIndexMap = new HashMap<>();
		for(int i = 0; i < in.length; i++) {
			inIndexMap.put(in[i], i);
		}
		return inIndexMap;
	}
	
	private TreeNode reconstructHelper(int[] in, int inLeft, int inRight, int[] pre, int preLeft, int preRight, Map<Integer, Integer> inIndexMap) {
		if(inLeft > inRight) {
			return null;
		}
		TreeNode root = new TreeNode(pre[preLeft]);
		int leftSize = inIndexMap.get(root.key) - inLeft;
		root.left = reconstructHelper(in, inLeft, inLeft + leftSize - 1, pre, preLeft + 1, preLeft + leftSize, inIndexMap);
		root.right = reconstructHelper(in, inLeft + leftSize + 1, inRight, pre, preLeft + leftSize + 1, preRight, inIndexMap);
		
		return root;
		
	}
}
