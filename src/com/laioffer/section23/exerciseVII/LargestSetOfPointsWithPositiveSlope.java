package com.laioffer.section23.exerciseVII;

import java.util.Arrays;
import java.util.Comparator;

public class LargestSetOfPointsWithPositiveSlope {
	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class MyComparactor implements Comparator<Point> {

		@Override
		public int compare(Point p1, Point p2) {
			// TODO Auto-generated method stub
			if(p1.y < p2.y) {
				return -1;
			} else if(p1.y > p2.y) {
				return 1;
			} else if(p1.x < p2.x) {
				return -1;
			} else if(p1.x > p2.x) {
				return 1;
			}
			return 0;
		}
	}
	public int largest(Point[] points) {
		if(points.length == 0) {
			return 0;
		}
		int result = 0;
		Arrays.sort(points, new MyComparactor());
		int[] longest = new int[points.length];
		for(int i = 0; i < longest.length; i++) {
			for(int j = 0; j < i; j++) {
				if(points[j].x < points[i].x && points[j].y < points[i].y) {
					longest[i] = Math.max(longest[i], longest[j]);
				}
			}
			longest[i]++;
			result = Math.max(result, longest[i]);
		}
		return result;
	}
}
