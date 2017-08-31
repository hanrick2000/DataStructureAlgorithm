package com.laioffer.homework4;

import java.util.ArrayList;
import java.util.List;

import com.laioffer.customdatastructure.TreeNode;

public class GetKeysGivenRange {
	public List<Integer> getRange(TreeNode root, int min, int max){
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) {
			return result;
		}
		getRangeHelper(root, min, max, result);
		
		return result;
	}
	
	private void getRangeHelper(TreeNode root,int min,int max,List<Integer> result) {
		if(root == null) {
			return;
		}
		
		if(root.key > min) {
			getRangeHelper(root.left, min, max, result);
		}
		
		if(root.key >= min && root.key <= max) {
			result.add(root.key);
		}
		
		if(root.key < max) {
			getRangeHelper(root.right, min, max, result);
		}
	}
}
