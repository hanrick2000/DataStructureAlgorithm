package com.laioffer.section3.linkedlist;


public class ReverseLinkedListRecursive {
	public ListNode reverseLinkedList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverseLinkedList(head.next);
		head.next.next = head;
		head.next = null;
		
		return newHead;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedListRecursive solution = new ReverseLinkedListRecursive();
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		p1.next = p2;
		p2.next = p3;
		p3.next = null;
		solution.reverseLinkedList(p1);
		System.out.print(p3.next.value);
	}

}
