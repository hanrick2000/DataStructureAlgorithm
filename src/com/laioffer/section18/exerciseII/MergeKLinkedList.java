package com.laioffer.section18.exerciseII;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.laioffer.linkedlist.ListNode;

public class MergeKLinkedList {
	static class MyComparator implements Comparator<ListNode>{
		@Override
		public int compare(ListNode l1, ListNode l2) {
			if(l1.value == l2.value) {
				return 0;
			}
			
			return l1.value < l2.value ? -1 : 1;
		}

		
		
	}
	public ListNode merge(List<ListNode> listOfLists) {
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(11, new MyComparator());
		ListNode dummy = new ListNode(0);
		ListNode curNode = dummy;
		for(ListNode node : listOfLists) {
			if(node != null) {
				minHeap.offer(node);
			}
		}
		
		while(!minHeap.isEmpty()) {
			curNode.next = minHeap.poll();
			if(curNode.next.next != null) {
				minHeap.offer(curNode.next.next);
			}
			curNode = curNode.next;
		}
		return dummy.next;
	}
}
