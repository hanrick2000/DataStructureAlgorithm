package com.laioffer.homework2;

public class SearchInSortedMatrix {
	public int[] binarySearch(int[][] matrix, int target) {
		// Write your solution here.
		if (matrix == null || matrix.length == 0) {
			return new int[] { -1, -1 };
		}

		int row = matrix.length;
		int column = matrix[0].length;
		int start = 0;
		int end = row * column - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (matrix[mid / column][mid % column] == target) {
				return new int[] { mid / column, mid % column };
			} else if (matrix[mid / column][mid % column] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (matrix[start / column][start % column] == target) {
			return new int[] { start / column, start % column };
		} else if (matrix[end / column][end % column] == target) {
			return new int[] { end / column, end % column };
		}
		return new int[] { -1, -1 };

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInSortedMatrix solution = new SearchInSortedMatrix();
		int[][] array = {{1,2,3,4},{5,5,6,7},{7,7,9,10}};
		int[] result = solution.binarySearch(array, 8);
		for (int i : result) {
			System.out.print(i);
		}

	}
}
