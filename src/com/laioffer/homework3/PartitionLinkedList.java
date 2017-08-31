package com.laioffer.homework3;

public class PartitionLinkedList {
	public ListNode partition(ListNode head, int target) {
		// write your solution here
		if(head == null || head.next == null) {
			return head;
		}
		ListNode dummySmall = new ListNode(0);
		ListNode dummyLarge = new ListNode(0);
		ListNode curSmall = dummySmall;
		ListNode curLarge = dummyLarge;
		while(head != null) {
			if(head.value < target) {
				curSmall.next = head;
				curSmall = curSmall.next;
			}else {
				curLarge.next = head;
				curLarge = curLarge.next;
			}
			head = head.next;
		}
		
		curSmall.next = dummyLarge.next;
		curLarge.next = null;
		return dummySmall.next;
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
		PartitionLinkedList solution = new PartitionLinkedList();
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(5);
		ListNode p3 = new ListNode(3);
		p1.next = p2;
		p2.next = p3;
		ListNode head = solution.partition(p1, 4);
		printList(head);
	}
}
