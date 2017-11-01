package com.laioffer.section23.exerciseVII;

public class GenerateRandomMaze {
	enum Dir {
		NORTH(-1, 0),SOUTH(1, 0), EAST(0, -1), WEST(0, 1);
		int deltaX;
		int deltaY;
		
		Dir(int deltaX, int deltaY){
			this.deltaX = deltaX;
			this.deltaY = deltaY;
		}
		
		public int moveX(int x, int times) {
			return x + times * deltaX;
		}
		public int moveY(int y, int times) {
			return y + times * deltaY;
		}
		
	}
	public int[][] maze(int n){
		int[][] result = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == 0 && j == 0) {
					result[i][j] = 0;
				} else {
					result[i][j] = 1;
				}
			}
		}
		generateMaze(result, 0, 0);
		return result;
	}
	private boolean isValidWall(int[][] maze, int x, int y) {
		return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1;
	}
	private void generateMaze(int[][] maze, int x, int y) {
		Dir[] dirs = Dir.values();
		random(dirs);
		for(Dir dir : dirs) {
			int nextX = dir.moveX(x, 2);
			int nextY = dir.moveY(y, 2);
			if(isValidWall(maze, nextX, nextY)) {
				maze[dir.moveX(x,  1)][dir.moveY(y, 1)] = 0;
				maze[nextX][nextY] = 0;
				generateMaze(maze, nextX, nextY);
			}
		}
	}
	
	private void random(Dir[] dirs) {
		for(int i = 0; i < dirs.length; i++) {
			int index = (int)(Math.random() *(dirs.length - i));
			Dir temp = dirs[i];
			dirs[i] = dirs[i + index];
			dirs[i + index] = temp;
		}
	}
}
