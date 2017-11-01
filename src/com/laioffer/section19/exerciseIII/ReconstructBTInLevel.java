package com.laioffer.section19.exerciseIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.laioffer.customdatastructure.TreeNode;

public class ReconstructBTInLevel {
	public TreeNode reconstruct(int[] in, int[] level) {
		Map<Integer, Integer> inIndexMap = getIndexMap(in);
		List<Integer> levelList = getList(level);
		return helperReconstructHelper(inIndexMap, levelList);
	}
	
	private TreeNode helperReconstructHelper(Map<Integer, Integer> inIndexMap, List<Integer> levelList) {
		if(levelList.isEmpty()) {
			return null;
		}
		
		TreeNode root = new TreeNode(levelList.remove(0));
		List<Integer> leftList = new ArrayList<>();
		List<Integer> rightList = new ArrayList<>();
		for(int num : levelList) {
			if(inIndexMap.get(num) < inIndexMap.get(root.key)) {
				leftList.add(num);
			} else {
				rightList.add(num);
			}
		}
		
		root.left = helperReconstructHelper(inIndexMap, leftList);
		root.right = helperReconstructHelper(inIndexMap, rightList);
		return root;
	}
	private List<Integer> getList(int[] level) {
		List<Integer> levelList = new ArrayList<>();
		for(int num : level) {
			levelList.add(num);
		}
		return levelList;
	}
	private Map<Integer, Integer> getIndexMap(int[] in){
		Map<Integer, Integer> inIndexMap = new HashMap<>();
		for(int i = 0; i < in.length; i++) {
			inIndexMap.put(in[i], i);
		}
		return inIndexMap;
	}
}
