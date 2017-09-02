package com.laioffer.section3.linkedlist;

public class ReorderLinkedList {
	public ListNode reorder(ListNode head) {
	    // Write your solution here.
		if(head == null || head.next == null) {
			return head;
		}
		//1.find the middle node of the whole list
		ListNode middleNode = middleNode(head);
		ListNode one = head;
		ListNode two = middleNode.next;
		middleNode.next = null;
		//2.reverse the half side of linkedlist
		two = reverseLinkedList(two);
		//3.Merge the two Linked List
		head = merge(one, two);
	    return head;
	}
	
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
	
	public ListNode merge(ListNode one, ListNode two) {
	    // write your solution here
	 	ListNode dummy = new ListNode(0);
	 	ListNode cur = dummy;
	 	while(one != null && two != null) {
	 		cur.next = one;
	 		one = one.next;
	 		cur.next.next = two;
	 		two = two.next;
	 		cur = cur.next.next;
	 	}
	 	
	 	if(one != null) {
	 		cur.next = one;
	 	}
	    return dummy.next;
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
		ReorderLinkedList solution = new ReorderLinkedList();
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(5);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = null;
		ListNode head = solution.reorder(p1);
		printList(head);
	}
}
