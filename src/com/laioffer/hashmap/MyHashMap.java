package com.laioffer.hashmap;

import java.util.Arrays;

public class MyHashMap<K, V> {
	public static class Node<K,V> {
		final K key;
		V value;
		Node<K,V> next;
		Node(K key, V value){
			this.key = key;
			this.value = value;
		}
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public void setValue(V value) {
			this.value = value;
		}
	}
	
	public static final int DEFAULT_CAPACITY = 16;
	public static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	private Node<K,V>[] array;
	private int size;
	private float loadFactor;
	
	public MyHashMap() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	public MyHashMap(int capacity, float loadFactor) {
		// TODO Auto-generated constructor stub
		if(capacity <= 0) {
			throw new IllegalArgumentException("cap can not be smaller than 0");
		}
		this.array = (Node<K, V>[])(new Node[capacity]);
		this.size = 0;
		this.loadFactor = loadFactor;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		Arrays.fill(this.array, null);
		size = 0;
	}
	
	private int hash(K key) {
		if(key == null) {
			return 0;
		}
		//make all negative numbers to be positive
		return key.hashCode() & 0X7FFFFFFF;
	}
	
	private int getIndex(K key) {
		return hash(key) % array.length;
	}
	
	private boolean equalsValue(V v1, V v2) {
		//v1 == v2 to test v1 and v2 both null
		return v1 == v2 || v1 != null && v1.equals(v2);
	}
	private boolean equalsKey(K k1, K k2) {
		//v1 == v2 to test v1 and v2 both null
		return k1 == k2 || k1 != null && k1.equals(k2);
	}
	
	public boolean containsValue(V value) {
		if(size == 0) {
			return false;
		}
		
		for(Node<K, V> node : array) {
			while(node != null) {
				if(equalsValue(node.value, value)) {
					return true;
				}
				node = node.next;
			}
		}
		return false;
	}
	
	public boolean containsKey(K key) {
		if(size == 0) {
			return false;
		}
		int index = getIndex(key);
		Node<K, V> node = array[index];
		while(node != null) {
			if(equalsKey(node.key, key)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}
	
	public V get(K key) {
		int index = getIndex(key);
		Node<K, V> node = array[index];
		while(node != null) {
			if(equalsKey(node.key, key)) {
				return node.value;
			}
			node = node.next;
		}
		return null;
	}
	
	public V put(K key, V value) {
		int index = getIndex(key);
		Node<K, V> head = array[index];
		Node<K, V> curNode = head;
		while(curNode != null) {
			if(equalsKey(curNode.key, key)) {
				V result = curNode.value;
				curNode.value = value;
				return result;
			}
			curNode = curNode.next;
		}
		Node<K, V> newNode = new Node<K, V>(key, value);
		newNode.next = head;
		array[index] = newNode; // give the new Head;
		size++;
		if(needRehashing()) {
			rehashing();
		}
		return null;
	}
	
	private boolean needRehashing() {
		// TODO Auto-generated method stub
		float ratio = (size + 0.0f) / array.length;
		return ratio >= loadFactor;
	}

	private void rehashing() {
		// TODO Auto-generated method stub
		Node<K,V>[] newArray = (Node<K, V>[])(new Node[array.length * 2]); 
		for(Node<K, V> node : array) {
				//put method into the new Array
				int index = getIndex(node.key);
				Node<K, V> head = newArray[index];
				node.next = head;
				newArray[index] = node; // give the new Head;
				size++;
		}
	}
	
	public V remove(K key) {
		int index = getIndex(key);
		Node<K, V> head = array[index];
		
		if(equalsKey(head.key, key)) {
			array[index] = head.next;
			size--;
			return head.value;
		}
		Node<K, V> curNode = head;
		while(curNode.next != null && !equalsKey(curNode.key, key)) {
			curNode = curNode.next;
		}
		
		if(curNode.next != null) {
			V result = curNode.value;
			curNode.next = curNode.next.next;
			size--;
			return result;
		}
		return null;
	}


	
	
	
}
