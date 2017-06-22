package cse.assignment.one;

public class Node {
	
	private Object element;
	private Node next;
	
	public Node(Object e, Node n){
		this.element = e;
		this.next = n;
	}
	
	public Node(){
		this(null,null);
	}
	public Object getElement(){
		return this.element;
	}
	public Node getNext(){
		return this.next;
	}
	public void setElement(Object newElem){
		this.element = newElem;
	}
	public void setNext(Node newNext){
		this.next = newNext;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
