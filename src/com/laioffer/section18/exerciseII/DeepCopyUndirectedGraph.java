package com.laioffer.section18.exerciseII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.laioffer.customdatastructure.GraphNode;

public class DeepCopyUndirectedGraph {
	public List<GraphNode> copy(List<GraphNode> graph){
		if(graph == null) {
			return null;
		}
		
		Map<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>();
		for(GraphNode node : graph) {
			if(!map.containsKey(node)) {
				map.put(node, new GraphNode(node.key));
				DFSNode(node, map);
			}
		}
		return new ArrayList<GraphNode>(map.values());
	}
	
	private void DFSNode(GraphNode node, Map<GraphNode, GraphNode> map) {
		GraphNode copyNode = map.get(node);
		for(GraphNode nei : node.neighbors) {
			if(!map.containsKey(nei)) {
				map.put(nei, new GraphNode(nei.key));
				DFSNode(nei, map);
			}
			copyNode.neighbors.add(map.get(nei));
		}
	}
}
