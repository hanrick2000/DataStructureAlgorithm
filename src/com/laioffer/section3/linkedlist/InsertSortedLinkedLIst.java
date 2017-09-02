package com.laioffer.section3.linkedlist;

public class InsertSortedLinkedLIst {
	public ListNode insert(ListNode head, int value) {
	    // write your solution here
		ListNode newNode = new ListNode(value);
		if(head == null) {
			return newNode;
		}
		
		if(head.value >= value) {
			newNode.next = head;
			return newNode;
		}
		
		ListNode cur = head;
		while(cur.next != null && cur.next.value < value) {
			cur = cur.next;
		}
		
		newNode.next = cur.next;
		cur.next = newNode;
		
	    return head;
	  }
	
	static void printList(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertSortedLinkedLIst solution = new InsertSortedLinkedLIst();
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(4);
		p1.next = p2;
		p2.next = p3;
		ListNode head = solution.insert(p1, 5);
		printList(head);
	}
}
