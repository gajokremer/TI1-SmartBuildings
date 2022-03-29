package model;

public class MyArrayList<T> {
	
	private ALNode<T> first;
	
	public MyArrayList() {
		
	}
	
	public boolean add(T t) {
		
		if(first.equals(null)) {
		 
			first = new ALNode<T>(t);
			
			return true;
			
		} else {
			
			return addValue(t, first);
		}
		
//		if(first.getT().equals(null) {
//			
//			first.setT(t);
//			
//		} else {
//			
//			addValue(t, first);
//		}
	}

	private boolean addValue(T t, ALNode<T> current) {
		
		if(current.getNext().equals(null)) {
			
			ALNode<T> node = new ALNode<T>(t);
			current.setNext(node);
			current.getNext().setPrev(current);
			
			return true;
			
		} else {
			
			return addValue(t, current);
		}
		
//		if(current != null) {
//			
//			if(current.getT() != null) {
//				
//				current.setT(t);
//				
//			} else {
//				
//				addValue(t, current.getNext());
//			}
//		}
	}

	public void removeAll() {
		
		if(!first.equals(null)) {

			if(first.getNext().equals(null)) {

				first = null;

			} else {

				removeNode(first.getNext(), first);
			}
		}
	}
	
	private void removeNode(ALNode<T> current, ALNode<T> aux) {
		
		if(!current.getNext().equals(null)) {
			
			aux = null;
			removeNode(current.getNext(), current);
		}
	}
}