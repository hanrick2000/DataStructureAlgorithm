package com.laioffer.section22.exerciseVI;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstNonReaptingCharacterInStream {
	static class Node {
		Node prev;
		Node next;
		Character ch;
		
		Node(Character ch){
			this.ch = ch;
		}
	}
	
	private Node head;
	private Node tail;
	
	private Map<Character, Node> single;
	private Set<Character> repeat;
	
	public FirstNonReaptingCharacterInStream() {
		tail = new Node(null);
		tail.next = tail.prev = tail;
		head = tail;
		single = new HashMap<>();
		repeat = new HashSet<>();
	}
	
	public void read(char ch) {
		if(repeat.contains(ch)) {
			return;
		}
		Node node = single.get(ch);
		if(node == null) {
			node = new Node(ch);
			append(node);
		} else {
			remove(node);
		}
	}
	
	private void append(Node node) {
		single.put(node.ch, node);
		tail.next = node;
		node.prev = tail;
		node.next = head;
		tail = tail.next;
	}
	
	private void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		if(node == tail) {
			tail = node.prev;
		}
		node.prev = node.next = null;
		repeat.add(node.ch);
		single.remove(node.ch);
	}
	
	public Character firstNonReapting() {
		if(head == tail) {
			return null;
		}
		return head.next.ch;
	}
}
