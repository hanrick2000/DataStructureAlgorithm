package com.laioffer.section22.exerciseVI;

public class LRUCache<K, V> {
	static class Node<K, V> {
		Node<K, V> next;
		Node<K, V> prev;
		K key;
		V value;
		
		Node(K key, V value){
			this.key = key;
			this.value = value;
		}
		
		void update(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
