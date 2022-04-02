package model;

public class MyStack<S> {

	private SNode<S> head;

	public MyStack() {
		head = null;
	}

	public SNode<S> getHead() {
		return head;
	}

	public void setFirst(SNode<S> head) {
		this.head = head;
	}

	public SNode<S> peek() {
		
		if(head != null) return head;
		
		else return null;
	}
	
	public S pop() {

		if(!head.equals(null)) {
			
			SNode<S> aux = head;
			head = head.getNext();
			
			return aux.getS();
		}

		return null;
	}
	
	public void push(S s) {
		
		if(head == null) {
			
			head = new SNode<S>(s);
			
		} else {

			SNode<S> aux = head;
			SNode<S> newNode = new SNode<S>(s);
			head = newNode;
			aux.setPrev(head);
			head.setNext(aux);
		}
	}

//	public void addAll(PriorityQueue<S> entrance) {
//		
////		while() {
////			
////			
////		}
//	}

	public int size() {

		if(head == null) {

			return 0;

		} else if(head != null && head.getNext() == null) {

			return 1;

		} else {

			int i = 2;

			return count(head.getNext(), i);
		}
	}

	private int count(SNode<S> current, int i) {

		if(current != null) {

			if(current.getNext() == null) {

				return i;

			} else {


				return count(current.getNext(), i+1);
			}
		}

		return 0;
	}
	
	@Override
	public String toString() {
		
		String line = "[";
		
		if(head != null) {

			line += head;
			SNode<S> current = head.getNext();
			boolean canContinue = true;

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