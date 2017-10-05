package com.laioffer.section18.exerciseII;

import java.util.*;

import com.laioffer.customdatastructure.RandomListNode;

public class DeepCopyLinkedListWithRandomPointer {
	public RandomListNode copy(RandomListNode head) {
		if(head == null) {
			return head;
		}
		Map<RandomListNode, RandomListNode> lookUp = new HashMap<>();
		RandomListNode newHead = new RandomListNode(head.value);
		lookUp.put(head, newHead);
		RandomListNode cur = newHead;
		while(head != null) {
			if(head.next != null) {
				if(!lookUp.containsKey(head.next)) {
					lookUp.put(head.next, new RandomListNode(head.next.value));
				}
				cur.next = lookUp.get(head.next);
			}
			
			if(head.random != null) {
				if(!lookUp.containsKey(head.random)) {
					lookUp.put(head.random, new RandomListNode(head.random.value));
				}
				cur.random = lookUp.get(head.random);
			}
			
			cur = cur.next;
			head = head.next;
		}
		return newHead;
	}
}
