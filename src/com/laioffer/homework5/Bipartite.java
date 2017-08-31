package com.laioffer.homework5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.laioffer.customdatastructure.GraphNode;

public class Bipartite {
	public boolean isBipartite(List<GraphNode> graph) {
		// write your solution here
		HashMap<GraphNode, Integer> visited= new HashMap<GraphNode, Integer>();
		for(GraphNode node: graph) {
			if(!BST(node, visited)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean BST(GraphNode node, HashMap<GraphNode, Integer> visited) {
		if(visited.containsKey(node)) {
			return true;
		}
		Queue<GraphNode> queue = new LinkedList<GraphNode>(); 
		queue.offer(node);
		visited.put(node, 0);
		while(!queue.isEmpty()) {
			GraphNode cur = queue.poll();
			int curGroup = visited.get(cur);
			int neiGroup = curGroup == 0 ? 1: 0;
			for(GraphNode nei : cur.neighbors) {
				if(!visited.containsKey(nei)) {
					visited.put(nei, neiGroup);
					queue.offer(nei);
				} else if(visited.get(nei) != neiGroup){
					return false;
				}
			}
		}
		return true;
	}
}
