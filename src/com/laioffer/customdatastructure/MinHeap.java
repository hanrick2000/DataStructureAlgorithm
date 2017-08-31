package com.laioffer.customdatastructure;

import java.util.NoSuchElementException;

public class MinHeap {
	private int[] array;
	private int size;

	public MinHeap(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("wrong input");
		}
		this.array = array;
		this.size = array.length;
		heapify();
	}

	public MinHeap(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("wrong input");

		}
		this.array = new int[capacity];
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == array.length;
	}

	public void heapify() {
	}

	private void percolateDown(int index) {
		while (index <= size / 2 - 1) {
			int candidate = index;
			int leftChild = index * 2 + 1;
			if (array[leftChild] < array[index]) {
				candidate = leftChild;
			}
			int rightChild = index * 2 + 2;
			if (rightChild < array.length && array[rightChild] < array[candidate]) {
				candidate = rightChild;
			}
			if (candidate != index) {
				swap(index, candidate);
				index = candidate;
			} else {
				break;
			}
		}

		while (index <= (size - 2) / 2) {
			int lindex = index * 2 + 1;
			int rindex = index * 2 + 2;
			int candidate = lindex;
			if (rindex <= size - 1 && array[lindex] >= array[rindex]) {
				candidate = rindex;
			}
			if (array[index] > array[candidate]) {
				swap(index, candidate);
			} else {
				break;
			}
			index = candidate;
		}

	}


	private void percolateUp(int index) {
		/*
		 * if (index == 0) { return; } int pindex = parentIndex(index); if (array[index]
		 * < array[pindex]) { swap(index, pindex); percolateUp(pindex); } else { return;
		 * }
		 * 
		 */

		while (index > 0) {
			int pindex = (index - 1) / 2;
			if (array[pindex] > array[index]) {
				swap(pindex, index);
			} else {
				break;
			}
			index = pindex;
		}

	}

	private void swap(int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public int peek() {
		if (size == 0) {
			throw new NoSuchElementException("heap is empty");
		}
		return array[0];

	}

	public int poll() {
		int res = array[0];
		array[0] = array[size - 1];
		size--;
		percolateDown(0);
		return res;

	}

	public void offer(int val) {
		array[size] = val;
		size++;
		percolateUp(size - 1);
	}

	public int update(int index, int val) {
		if (index < 0 || index > size - 1) {
			throw new IllegalArgumentException("wrong input");
		}
		int res = array[index];
		array[index] = val;
		if (res > val) {
			percolateUp(index);
		} else {
			percolateDown(index);
		}
		return res;

	}

}
