package model;

public class MyStack<S> {

	private SNode<S> first;

	public MyStack() {
		first = null;
	}

	public SNode<S> getFirst() {
		return first;
	}

	public void setFirst(SNode<S> first) {
		this.first = first;
	}
}