package com.laioffer.homework3;

class ListNode {
	public int value;
	public ListNode next;

	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}

public class ReverseLinkedList {
	public ListNode reverseLinkedList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode preNode = null;
		ListNode curNode = head;
		while(curNode != null) {
			ListNode newHead = curNode.next;
			curNode.next = preNode;
			preNode = curNode;
			curNode = newHead;	
		}
		return preNode;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList solution = new ReverseLinkedList();
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
