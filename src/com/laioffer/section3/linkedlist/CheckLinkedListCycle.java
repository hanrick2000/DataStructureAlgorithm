package com.laioffer.section3.linkedlist;

public class CheckLinkedListCycle {
	public boolean hasCycle(ListNode head) {
		// write your solution here
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slowNode = head;
		ListNode fastNode = head;
		while(fastNode.next != null && fastNode.next.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
			if(slowNode == fastNode) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckLinkedListCycle solution = new CheckLinkedListCycle();
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		p1.next = p2;
		p2.next = p3;
		p3.next = p1;
		boolean hascycle = solution.hasCycle(p1);
		System.out.print(hascycle);
	}
}
