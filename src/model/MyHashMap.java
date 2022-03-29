package model;

public class MyHashMap<K, V> {
	
	private HMNode<K, V> first;
	
	public MyHashMap() {
		
		first = null;
	}

	public HMNode<K, V> getFirst() {
		return first;
	}

	public void setFirst(HMNode<K, V> first) {
		this.first = first;
	}
	
	public void put(K key, V value) {

		HMNode<K, V> newNode = new HMNode<K, V>(key, value);
		
//		System.out.println("\nNew Node: " + newNode);
		
		if(first.equals(null)) {
			
//			System.out.println("first = null");
			
			first = newNode;
			
		} else {
			
//			System.out.println("else");
			
			assignPosition(newNode, first);
		}
	}
	
	private void assignPosition(HMNode<K, V> newNode, HMNode<K, V> current) {
		
//		System.out.println("Assign position");

		if(current.getNext().equals(null)) {
			
//			System.out.println("next = null");
			
			current.setNext(newNode);
			current.getNext().setPrev(current);;

//			System.out.println(newNode + " -> " + newNode.nextAndPrev());
//			System.out.println(current + " -> " + current.nextAndPrev());
			
		} else {
			
			assignPosition(newNode, current.getNext());
		}
	}
	
	public V get(K key) {
		
		if(first.getKey().equals(key)) {
			
			return first.getValue();
			
		} else {
			
			return findValueByKey(key, first);
		}
	}
	
	private V findValueByKey(K key, HMNode<K, V> current) {

		if(current.getKey().equals( key)) {
			
			return current.getValue();
			
		} else {
			
			return findValueByKey(key, current.getNext());
		}
	}
	
	public boolean containsKey(K key) {

		if(first.getKey().equals(key)) {

			return true;

		} else {

			return findIfKeyExists(key, first.getNext());
		}
	}

	private boolean findIfKeyExists(K key, HMNode<K, V> current) {

		if(!current.equals(null)) {

			if(current.getKey().equals(key)) {

				return true;

			} else {

				return findIfKeyExists(key, current.getNext());
			}
		}

		return false;
	}
	
	public boolean containsValue(V value) {
		
//		System.out.println("First: " + first.getValue());
//		System.out.println("Value: " + value);
		
		if(first.getValue().equals( value)) {
			
			return true;
			
		} else {
			
			return findIfValueExists(value, first.getNext());
		}
	}
	
	private boolean findIfValueExists(V value, HMNode<K, V> current) {

		if(!current.equals(null)) {

			if(current.getValue().equals( value)) {

				return true;

			} else {

				return findIfValueExists(value, current.getNext());
			}
		}

		return false;
	}

	public void replace(K key, V value) {
		
		if(first.getKey().equals(key)) {
			
			first.setValue(value);
			
		} else {
			
			findKeyOfValue(key, value, first.getNext());
		}
    }

	private void findKeyOfValue(K key, V value, HMNode<K, V> current) {
		
		if(current.getKey().equals(key)) {
			
			current.setValue(value);
			
		} else {
			
			findKeyOfValue(key, value, current.getNext());
		}
	}

	public int size() {
		
		int count = 0;
		count = count(first, 0);
		
		return count;
	}
	
	private int count(HMNode<K, V> current, int count) {

		if(!current.equals(null)) {
			
			return count(current.getNext(), count+1);
		} 
		
		return count;
	}
	
	@Override
	public String toString() {
		
		String line = "{";
		
		HMNode<K, V> current = first;
		
		while(!current.equals(null)) {
			
			line += current.toString();
			
			if(!current.getNext().equals(null)) {
				
				 line += ", ";
			}
			
			current = current.getNext();
		}
		
		line += "}";
		
		return line;
	}
}