package com.laioffer.section21.exerciseV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PlaceToPutTheChairI {
	private static final char Equip = 'E';
	private static final char Obstacle = 'O';
	static class Pair{
		int i;
		int j;
		
		Pair(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	public List<Integer> putChair(char[][] gym) {
		int row = gym.length;
		int column = gym[0].length;
		int[][] cost = new int[row][column];
		for(int i = 0 ; i < row; i++) {
			for(int j = 0; j < column; j++) {
				if(gym[i][j] == Equip) {
					if(!addCost(cost, gym, i, j)) {
						return null;
					}
				}
			}
		}
		List<Integer> result = null;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				if(gym[i][j] != Equip && gym[i][j] != Obstacle) {
					if(result == null) {
						result = Arrays.asList(i, j);
					} else if(cost[i][j] < cost[result.get(0)][result.get(1)]) {
						result.set(0, i);
						result.set(1, j);
					}
				}
			}
		}
		return result;
	}
	
	private boolean addCost(int[][] cost, char[][] gym, int i, int j) {
		boolean[][] visited = new boolean[cost.length][cost[0].length];
		int pathCost = 1;
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(i, j));
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int k = 0; k < size; k++) {
				Pair curPair = queue.poll();
				List<Pair> neis = getNeis(curPair, gym);
				for(Pair nei : neis) {
					if(!visited[nei.i][nei.j]) {
						visited[nei.i][nei.j] = true;
						cost[nei.i][nei.j] += pathCost;
						queue.offer(nei);
					}
				}
			}
			pathCost++;
		}
		for(int m = 0; m < cost.length; m++) {
			for(int n = 0; n < cost[0].length; n++) {
				if(!visited[m][n] && gym[m][n] == Equip) {
					return false;
				}
			}
		}
		return true;
	}
	
	private List<Pair> getNeis(Pair cur, char[][] gym) {
		int x = cur.i;
		int y = cur.j;
		int row = gym.length;
		int column = gym[0].length;
		
		List<Pair> neis = new ArrayList<>();
		if(x + 1 < row && gym[x + 1][y] != Obstacle) {
			neis.add(new Pair(x + 1, y));
		}
		if(x - 1 >= 0 && gym[x - 1][y] != Obstacle) {
			neis.add(new Pair(x - 1, y));
		}
		if(y + 1 < column && gym[x][y + 1] != Obstacle) {
			neis.add(new Pair(x, y + 1));
		}
		if(y - 1 >= 0 && gym[x][y - 1] != Obstacle) {
			neis.add(new Pair(x, y - 1));
		}
		return neis;
	}
}
