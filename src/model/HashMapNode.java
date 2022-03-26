package model;

public class HashMapNode <K, V> {

	private K key;
	private V value;
	private HashMapNode<K, V> next;
	private HashMapNode<K, V> prev;
	
	public HashMapNode(K key, V value, HashMapNode<K, V> next, HashMapNode<K, V> prev) {
		super();
		this.key = key;
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
	
	public HashMapNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public HashMapNode<K, V> getNext() {
		return next;
	}

	public HashMapNode<K, V> getPrev() {
		return prev;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public void setNext(HashMapNode<K, V> next) {
		this.next = next;
	}

	public void setPrev(HashMapNode<K, V> prev) {
		this.prev = prev;
	}
	
	@Override
	public String toString() {
		
		return key + "=" + value;
	}
	
	public String nextAndPrev() {

		return "Next=" + next + ", Prev=" + prev;
	}
}