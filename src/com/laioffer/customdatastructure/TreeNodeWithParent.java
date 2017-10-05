package com.laioffer.customdatastructure;

public class TreeNodeWithParent {
	public int key;
	public TreeNodeWithParent left;
	public TreeNodeWithParent right;
	public TreeNodeWithParent parent;
	
	public TreeNodeWithParent(int key, TreeNodeWithParent parent) {
		this.key = key;
		this.parent = parent;
	}
}
