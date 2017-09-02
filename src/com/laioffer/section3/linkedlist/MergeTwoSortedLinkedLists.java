package com.laioffer.section3.linkedlist;

public class MergeTwoSortedLinkedLists {
	 public ListNode merge(ListNode one, ListNode two) {
		    // write your solution here
		 	ListNode dummy = new ListNode(0);
		 	ListNode cur = dummy;
		 	while(one != null && two != null) {
		 		if(one.value < two.value) {
		 			cur.next = one;
		 			one = one.next;
		 		} else {
		 			cur.next = two;
		 			two = two.next;
		 		}
		 		cur = cur.next;
		 	}
		 	
		 	if(one != null) {
		 		cur.next = one;
		 	} else {
		 		cur.next = two;
		 	}
		    return dummy.next;
	 }
	 
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
		 	MergeTwoSortedLinkedLists solution = new MergeTwoSortedLinkedLists();
			ListNode p1 = new ListNode(1);
			ListNode p2 = new ListNode(3);
			ListNode p3 = new ListNode(5);
			ListNode m1 = new ListNode(2);
			ListNode m2 = new ListNode(4);
			ListNode m3 = new ListNode(6);
			p1.next = p2;
			p2.next = p3;
			m1.next = m2;
			m2.next = m3;
			ListNode head = solution.merge(p1, m1);
			System.out.print(head.next.next.value);
		}
}
