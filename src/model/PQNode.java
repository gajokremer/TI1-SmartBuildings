package model;

public class PQNode<P> {

	private P p;
	private PQNode<P> left;
	private PQNode<P> right;
	private PQNode<P> parent;
	
	public PQNode(P p) {
		this.p = p;
		left = null;
		right = null;
		parent = null;
	}
	
	public P getP() {
		return p;
	}

	public PQNode<P> getLeft() {
		return left;
	}

	public PQNode<P> getRight() {
		return right;
	}

	public PQNode<P> getParent() {
		return parent;
	}

	public void setP(P p) {
		this.p = p;
	}

	public void setLeft(PQNode<P> left) {
		this.left = left;
	}

	public void setRight(PQNode<P> right) {
		this.right = right;
	}

	public void setParent(PQNode<P> parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return p.toString();
	}
	
	public String nodeFormat() {
		
		String line = "";
		
		if(parent != null) {
			
			line += parent.nodeFormat() + " => ";
		}
		
		line += "[" + left + " <- "+ p.toString() + " -> " + right + "]";
		
		return line;
		
//		return parent.toString()+ " -> [" + left + " <- " + p.toString() + " -> " + right + "]";
	}
}
