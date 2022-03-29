package model;

public class ALNode<T> {

	private T t;
	private ALNode<T> next;
	private ALNode<T> prev;
	
	public ALNode(T t) {
		this.t = t;
		next = null;
		prev = null;
	}

	public T getT() {
		return t;
	}

	public ALNode<T> getNext() {
		return next;
	}

	public ALNode<T> getPrev() {
		return prev;
	}

	public void setT(T t) {
		this.t = t;
	}

	public void setNext(ALNode<T> next) {
		this.next = next;
	}

	public void setPrev(ALNode<T> prev) {
		this.prev = prev;
	}
	
	@Override
	public String toString() {
		return t.toString();
	}
}