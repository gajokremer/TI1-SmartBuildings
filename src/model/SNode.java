package model;

public class SNode<S> {

	private S s;
	private SNode<S> next;
	private SNode<S> prev;
	
	public SNode(S s) {
		this.s = s;
		next = null;
		prev = null;
	}
	
	public S getS() {
		return s;
	}

	public SNode<S> getNext() {
		return next;
	}

	public SNode<S> getPrev() {
		return prev;
	}

	public void setS(S s) {
		this.s = s;
	}

	public void setNext(SNode<S> next) {
		this.next = next;
	}

	public void setPrev(SNode<S> prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return s.toString();
	}
}
