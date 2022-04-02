package model;

public class MyArrayList<T> {
	
	private ALNode<T> first;
	
	public MyArrayList() {
		first = null;
	}
	
	public void add(T t) {
		
		if(first == null) {
		 
			first = new ALNode<T>(t);
			
//			return true;
			
		} else {
			
			first = addValue(t, first);
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

	private ALNode<T> addValue(T t, ALNode<T> current) {
		
		if(current.getNext() == null) {
			
			ALNode<T> node = new ALNode<T>(t);
//			System.out.println("1 Current next: " + current.getNext());
			current.setNext(node);
//			System.out.println("2 Current next: " + current.getNext());
			current.getNext().setPrev(current);
			
			return current;
			
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
		
//		if(!first.equals(null)) {
		if(first != null) {

			if(first.getNext() == null) {

				first = null;

			} else {

				removeNode(first.getNext(), first);
			}
			
		} else {
			
			
		}
	}
	
	private void removeNode(ALNode<T> current, ALNode<T> aux) {
		
		if(current.getNext() != null) {
			
			aux = null;
			removeNode(current.getNext(), current);
		}
	}

	public int size() {
		
		if(first.equals(null)) {
			
			return 0;
			
		} else if(first != null && first.getNext() == null) {
		
			return 1;
			
		} else {
			
			int i = 2;
			
			return count(first.getNext(), i);
		}
	}

	private int count(ALNode<T> current, int i) {
		
		if(current != null) {
			
			if(current.getNext() == null) {
				
				return i;
				
			} else {
				
//				i = i+1;
				
				return count(current.getNext(), i+1);
			}
		}
		
		return 0;
	}

	public T get(int pos) {
		
		if(!first.equals(null)) {
			
			if(pos == 0) {
				
				return first.getT();
				
			} else {
				
				return getElement(first.getNext(), pos, 1);
			}
		}
		
		return null;
	}

	private T getElement(ALNode<T> current, int pos, int i) {

		if(!current.equals(null)) {
			
			if(pos == i) {
				
				return current.getT();
				
			} else {
				
				return getElement(current.getNext(), pos, i+1);
			}
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		
		String line = "[";
		
//		System.out.println("First: " + first);
		
		if(first != null) {
			
//			System.out.println("while");

			line += first;
			ALNode<T> current = first.getNext();
			boolean canContinue = true;

//			System.out.println("First: " + first);
//			System.out.println("Second: " + first.getNext());
			
			while(canContinue) {
				
				if(current != null) {

					line += ", " + current;
					current = current.getNext();
					
				} else {
					
					canContinue = false;
				}
			}
		}
		
		line += "]";
		
		return line;
	}
}