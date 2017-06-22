package cse.assignment.one;

/**
 * This class is a ArrayList that uses a linked list internally.
 * 
 * The linked list has the advantage of not needing to reallocate an array which increases running time.
 * It has the disadvantage of a slower get and set running time of O(n) compared to an array oriented implementation,
 * with a running time of O(1) for both operations.
 * 
 * @author Jeffrey Young , 211015146, cse13175
 *
 * @param <E>
 */

public class LArrayList<E> implements ArrayList<E>{
	
	/**
	 * The head node of the linked list
	 */
	private Node head;
	
	/**
	 * The number of elements in the list
	 */
	private int size;
	
	/**
	 * The constructor of LArrayList class which
	 * initializes the size and head node
	 */
	public LArrayList(){
		this.head = new Node(null , null , null);
		this.head.next = null;
		this.head.prev = null;
		
		this.size = 0;
	}

	/**
	 * Returns the size of the list Run Time : O(1)
	 * 
	 * @return the size of the list as an integer
	 */
	public int size(){
		int count = 0; 
		for (Node node = head ; node != null ; node = node.getNext()){
			count++;
		}
		count = count -1;
		return count;
	}
	

	/**
	 * Returns whether the list is empty. Run Time: O(1)
	 * 
	 * @return boolean indicating if the LArrayList is empty.
	 */
	public boolean isEmpty(){
		if(this.size() == 0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Adds an element to the list at a given index, Run Time : O(n)
	 * 
	 * @param I the index to which an element is inserted
	 * @param e the element to insert
	 * @throws IndexOutOfBoundsException if the Index is less than zero or the index is less than the current size
	 */
	public void add(int I, E e) throws IndexOutOfBoundsException{
		
		if(I < 0 || I > this.size){
			throw new IndexOutOfBoundsException();
		}
		Node node = getAtPosition(this.head, I-1 );
		
		Node newNode = new Node(e,null,null);
		
		Node temp = new Node(node);
		
		newNode.setPrev(node);
		
		node.setNext(newNode);
		
		if(temp.getNext() != null){
			newNode.setNext(temp.getNext());
			temp.getNext().setNext(newNode);
		}
		this.size++;
		
	}	
	
	/**
	 * Get the value of the selected index in the list, Run Time: O(n)
	 * 
	 * @param i the index of value you want to obtain
	 * @return the value of the given index
	 * @throws IndexOutOfBoundsException if the index is if the Index is less than zero or the index is less/equal than the current size
	 */
	@SuppressWarnings("unchecked")
	public E get(int i)throws IndexOutOfBoundsException{
		
		if(i < 0 || i >= this.size){
			throw new IndexOutOfBoundsException();
		}else{
			return (E) getAtPosition(this.head, i).getElement();
		}		
	}

	/**
	 * A method to get the current position of a node at a given index
	 * @param n the head of the list
	 * @param I the index of retreival
	 * @return the node at the given index
	 */
	private Node getAtPosition(Node n , int I) {
		
		for(int i = -1 ; i < I ; i++){
			n = n.next;
		}
		return n;
	}
	
	/**
	 * Removes the element at the given index Run Time : O(n)
	 * @param i the index
	 * @return returns the removed element
	 * @throws IndexOutOfBoundsException if the Index is less than zero or the index is less than the current size
	 */
	@SuppressWarnings("unchecked")
	public E remove(int i) throws IndexOutOfBoundsException{
		if(i< 0 || i >= this.size){
			throw new IndexOutOfBoundsException();
		}
		Node node = getAtPosition(this.head, i);
		
		Node temp = new Node(node);
		
		temp.prev.setNext(temp.getNext());
		
		if (!(i > this.size - 2)){
			temp.getNext().setPrev(temp.getPrev());
		}
		size--;
		
		return (E) node.getElement();
		
	}
		
		
	/**
	 * Sets the value of an element at a given index Run Time: O(n)
	 * 
	 * @param I the index
	 * @param e the element you want to set
	 * @return the previous value 
	 * @throws IndexOutOfBoundsException if the Index is less than zero or the index is less than the current size
	 */
	@SuppressWarnings("unchecked")
	public E set(int I, E e) throws IndexOutOfBoundsException{
		if (I < 0 || I >= this.size)
			throw new IndexOutOfBoundsException();

		Node node = getAtPosition(this.head, I);
		E result = (E) node.getElement();
		
		node.setElement(e);
		
		return result;
	}
	/**
	 * A subclassed used by LArrayList which defines a node for the linkedlist
	 * @author Jeffrey Young
	 *
	 */
	private class Node{
		
		private Object element;
		private Node next;
		private Node prev;
	
		
		
		public Node(Object e, Node n, Node m){
			this.element = e;
			this.next = n;
			this.prev = m;
		}
		
		public Node(Object e){
			
			this.element = e;
			this.next = null;
			this.prev = null;
		}
		
		public Node(Node node){
			
			this.element = node.element;
			this.next = node.next;
			this.prev = node.prev;
		}
		
		public Object getElement(){
			return element;
		}
		public Node getNext(){
			return next;
		}
		public Node getPrev(){
			return prev;
		}
		
		//Modifier methods
		public void setElement(Object newElem){
			this.element = newElem;
		}
		public void setNext(Node newNext){
			this.next = newNext;
		}
		public void setPrev(Node newPrev){
			this.prev = newPrev;
		}
		
	}

	
	
}

