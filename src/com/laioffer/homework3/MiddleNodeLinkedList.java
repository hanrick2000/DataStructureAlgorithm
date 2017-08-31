package com.laioffer.homework3;

public class MiddleNodeLinkedList {
	public ListNode middleNode(ListNode head) {
		// write your solution here
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slowNode = head;
		ListNode fastNode = head;
		while(fastNode.next != null && fastNode.next.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}
		return slowNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiddleNodeLinkedList solution = new MiddleNodeLinkedList();
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		p1.next = p2;
		p2.next = p3;
		p3.next = null;
		ListNode middleNode = solution.middleNode(p1);
		System.out.print(middleNode.value);
	}
}
