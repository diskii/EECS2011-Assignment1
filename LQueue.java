package cse.assignment.one;
/**
 * This class implements the Queue interface using a linked list to manage the data. It has advantages compared to a queue which
 * utilizes an array. These includes no reallocation time due to the expanding the array and dequeue running time of O(1) compared
 * to the dequeue running time of O(n) in array oriented Queue.
 * 
 * @author Jeffrey Young , 211015146 , cse13175
 *
 */

public class LQueue implements Queue{
	/**
	 * the head of the linked list
	 */
	private Node head;
	/**
	 * the tail of the linked list
	 */
	private Node tail;
	/**
	 * The constructor is used to initialize the size,head and tail of the linked list
	 */
	public LQueue(){
	}
	/**
	 * Returns the size of the Queue, The Run Time is : O(n)
	 * 
	 * @return the size of the queue as an integer
	 */
	@Override
	public int size() {
		int count = 0;
        for (Node node = head; node != null; node = node.getNext()) {
            count++;
        }
        return count;
	}

	/**
	 * Returns whether the Queue is empty or not , The Run Time is : O(1)
	 * 
	 * @return the boolean of the queue if its empty or not
	 */
	 
	@Override
	public boolean isEmpty() {
		if(this.head == null){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Returns the value of the front element of the queue without removing it : Running time O(1)
	 * 
	 * @return Object of the front element of the queue
	 */
	@Override
	public Object front() throws EmptyQueueException {
		if(isEmpty()){
			throw new EmptyQueueException("Queue is Empty");
		}
			return this.head.getElement();
		
	}
	/**
	 * Equeues a value to back of the queue . Run Time: O(1)
	 * 
	 * @param the object to be enqueued
	 */
	@Override
	public void enqueue(Object o) {
			Node node1 = new Node(o,null);
			if(isEmpty()){
				this.head = node1;
			}else{
				this.tail.setNext(node1);
			}
			this.tail = node1;
	}
	/**
	 * Removes an Object from the front of the queue. Run Time : O(1)
	 * 
	 * @return the value of the object removed
	 */
	@Override
	public Object dequeue() throws EmptyQueueException {
		
		if(isEmpty()){
			throw new EmptyQueueException("Queue is Empty");
		}
		
		Object value = this.head.getElement();
		if(this.tail == this.head){
			this.tail = null;
		}
		this.head = head.getNext();
		return value;
	  
		
	}
	
	/**
	 * The subclass for Node inside LQueue 
	 * @author Jeffrey Young, cse 13175 , 211015146
	 *
	 */
	private class Node {
	    
	    //the Object for the Node
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
	}


}
