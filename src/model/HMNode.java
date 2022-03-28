package model;

public class HMNode <K, V> {

	private K key;
	private V value;
	private HMNode<K, V> next;
	private HMNode<K, V> prev;
	
//	public HMNode(K key, V value, HMNode<K, V> next, HMNode<K, V> prev) {
//		super();
//		this.key = key;
//		this.value = value;
//		this.next = next;
//		this.prev = prev;
//	}
	
	public HMNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public HMNode<K, V> getNext() {
		return next;
	}

	public HMNode<K, V> getPrev() {
		return prev;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public void setNext(HMNode<K, V> next) {
		this.next = next;
	}

	public void setPrev(HMNode<K, V> prev) {
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