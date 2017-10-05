package com.laioffer.section16.exercise1;

import com.laioffer.customdatastructure.TreeNodeWithParent;

public class LowestCommonAncestorII {
	public TreeNodeWithParent lowestCommonAncestor(TreeNodeWithParent one, TreeNodeWithParent two) {
		// Write your solution here.
		int lengthOne = getLength(one);
		int lengthTwo = getLength(two);
		
		if(lengthOne <= lengthTwo) {
			return mergeNode(one, two, lengthTwo - lengthOne);
		} else {
			return mergeNode(two, one, lengthOne - lengthTwo);
		}
	}
	private TreeNodeWithParent mergeNode(TreeNodeWithParent shorter, TreeNodeWithParent longer, int diff) {
		while(diff > 0) {
			longer = longer.parent;
			diff--;
		}
		
		while(longer != shorter) {
			longer = longer.parent;
			shorter = shorter.parent;
		}
		
		return longer;
	}
	
	private int getLength(TreeNodeWithParent node) {
		int length = 0;
		while(node != null) {
			length++;
			node = node.parent;
		}
		return length;
	}

}
