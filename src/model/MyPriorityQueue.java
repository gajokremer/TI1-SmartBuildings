package model;

public class MyPriorityQueue<P extends Person> {

	private PQNode<P> head;
	
	public MyPriorityQueue() {
		head = null;
	}

	public PQNode<P> getHead() {
		return head;
	}

	public void setHead(PQNode<P> head) {
		this.head = head;
	}

	public PQNode<P> peek() {
		
		return head;
	}
	
	/**
	 * Inserts value into PriorityQueue.
	 * @param p
	 */
	public void offer(P p) {
		
		PQNode<P> newNode = new PQNode<>(p);

		if(head == null) {
			
			head = newNode;
			
		} else {
			
			offer(head, newNode);
		}
		
//		else if(p.getLocation() < head.getP().getLocation()) {
//			
//			offer(head.getLeft(), newNode);
//			
//		} else {
//			
//			newNode = offer(head.getRight(), newNode);
//		}
	}
	
	private PQNode<P> offer(PQNode<P> current, PQNode<P> newNode) {
		
//		System.out.println("\n" + newNode.getP().getName() + " in node form: " + newNode.nodeForm());
//		
//		System.out.println(current.getP().getName() + " location: " + current.getP().getLocation());
//		System.out.println(newNode.getP().getName() + " location: " + newNode.getP().getLocation());
		
		if(current != null) {

			if(newNode.getP().getLocation() < current.getP().getLocation()) {

				if(current.getLeft() == null) {

					current.setLeft(newNode);
					newNode.setParent(current);
					System.out.println(newNode.getP().getName() + " in node form: " + newNode.nodeForm());
					return newNode;
					
				}  else {

					return offer(current.getLeft(), newNode);
				}
			} 

			if(newNode.getP().getLocation() > current.getP().getLocation()) {

					if(current.getRight() == null) {

					current.setRight(newNode);
					newNode.setParent(current);
					System.out.println(newNode.getP().getName() + " in node form: " + newNode.nodeForm());
					return newNode;

				} else {

					return offer(current.getRight(), newNode);
				}
			}
		}
		
		return newNode;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns and removes the head of the PriorityStack.
	 * @return
	 */
	public P poll() {
		
		
		
		return null;
	}
	
//	@Override
//	public String toString() {
//		return ;
//	}
}
