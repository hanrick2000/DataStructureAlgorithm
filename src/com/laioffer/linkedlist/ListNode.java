package com.laioffer.linkedlist;

public class ListNode {
	public int value;
	public ListNode next;
	public ListNode(int value) {
		this.value = value;
		next = null;
	}
	
	int length(ListNode head) {
		int length = 0;
		while(head != null) {
			length++;
			head = head.next;
		}
		return length;
	}
	
	ListNode get(ListNode head, int index) {
		
		while(index > 0 && head != null) {
			head = head.next;
			index--;
		}
		
		return head;
	}
	
	ListNode appendHead(ListNode head, int value) {
		ListNode newHead = new ListNode(value);
		newHead.next = head;
		return newHead;
	}
	
	ListNode appendTail(ListNode head, int value) {
		//1.head == null
		if(head == null) {
			return new ListNode(value);
		}
		//2.head != null
		ListNode curNode = head;
		while(curNode.next != null) {
			curNode = curNode.next;
		}
		
		curNode.next = new ListNode(value);
		return head;
	}
	
	ListNode remove(ListNode head, int value) {
		if(head == null) {
			return null;
		} else if(head.value == value) {
			return head.next;
		}
		ListNode curNode = head;
		while(curNode.next != null && curNode.next.value != value) {
			curNode = curNode.next;
		}
		
		if(curNode.next != null) {
			curNode.next = curNode.next.next;
		}
		
		return head;
	}
	
	
}
