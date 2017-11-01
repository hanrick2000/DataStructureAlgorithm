package com.laioffer.section21.exerciseV;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxWaterTrappedII {
	static class Pair implements Comparable<Pair> {
		int x;
		int y;
		int height;
		
		Pair(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}
		
		@Override
		public int compareTo(Pair another) {
			if(this.height == another.height) {
				return 0;
			}
			
			return this.height < another.height ? -1 : 1;
		}
	}
	public int maxTrapped(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		if(rows < 3 || columns < 3) {
			return 0;
		}
		PriorityQueue<Pair> minHeap = new PriorityQueue<>();
		boolean[][] visited = new boolean[rows][columns];
		processBorder(matrix, visited, minHeap, rows, columns);
		int result = 0;
		while(!minHeap.isEmpty()) {
			Pair cur = minHeap.poll();
			List<Pair> neighbours = allNeighbors(cur, matrix);
			for(Pair nei : neighbours) {
				if(visited[nei.x][nei.y]) {
					continue;
				}
				visited[nei.x][nei.y] = true;
				result += Math.max(cur.height - nei.height, 0);
				nei.height = Math.max(cur.height, nei.height);
				minHeap.offer(nei);
			}
		}
		return result;
	}
	
	private List<Pair> allNeighbors(Pair cur, int[][] matrix) {
		List<Pair> neis = new ArrayList<>();
		if(cur.x + 1 < matrix.length) {
			neis.add(new Pair(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
		}
		if(cur.x - 1 >= 0) {
			neis.add(new Pair(cur.x - 1, cur.y, matrix[cur.x - 1][cur.y]));
		}
		if(cur.y + 1 < matrix[0].length) {
			neis.add(new Pair(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
		}
		if(cur.y - 1 >= 0) {
			neis.add(new Pair(cur.x, cur.y - 1, matrix[cur.x][cur.y - 1]));
		}
		return neis;
	}
	
	private void processBorder(int[][] matrix, boolean[][] visited, PriorityQueue<Pair> minHeap, int rows, int columns) {
		for(int j = 0; j < columns; j++) {
			minHeap.offer(new Pair(0, j, matrix[0][j]));
			minHeap.offer(new Pair(rows - 1, j, matrix[rows - 1][j]));
			visited[0][j] = true;
			visited[rows - 1][j] = true;
		}
		for(int i = 1; i < rows - 1; i++) {
			minHeap.offer(new Pair(i, 0, matrix[i][0]));
			minHeap.offer(new Pair(i, columns - 1, matrix[i][columns - 1]));
			visited[i][0] = true;
			visited[i][columns - 1] = true;
		}
	}
}
