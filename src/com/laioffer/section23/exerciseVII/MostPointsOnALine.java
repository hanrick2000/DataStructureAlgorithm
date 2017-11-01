package com.laioffer.section23.exerciseVII;

import java.util.HashMap;
import java.util.Map;

public class MostPointsOnALine {
	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int most(Point[] points) {
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			Point seed = points[i];
			int samePoint = 1;
			int sameX = 0;
			int sameLine = 0;
			Map<Double, Integer> slopeMap = new HashMap<>();
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				}
				Point temp = points[j];
				if(temp.x == seed.x && temp.y == seed.y) {
					samePoint++;
				} else if(temp.x == seed.x) {
					sameX++;
				} else {
					double slope = ((temp.y - seed.y) + 0.0) / (temp.x - seed.x);
					if(!slopeMap.containsKey(slope)) {
						slopeMap.put(slope, 1);
					} else {
						slopeMap.put(slope, slopeMap.get(slope) + 1);
					}
					sameLine = Math.max(sameLine, slopeMap.get(slope));
				}
			}
			sameLine = Math.max(sameLine, sameX) + samePoint;
			result = Math.max(result, sameLine);
		}
		return result;
	}
}
