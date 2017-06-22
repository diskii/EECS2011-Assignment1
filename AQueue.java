package cse.assignment.one;


/**
 * This class is a Queue using Array to store the data. 
 * The AQueue has no advantage over a Queue using linked list
 * 
 * @author Jeffrey Young , 211015146 , cse13175
 *
 */
public class AQueue implements Queue {
	
	/**
	 * The size increase every time the current array is max, the array will be doubled each time as the ArrayList 
	 * increases in size.
	 */
	private static final int SIZE_INCREASE = 2;
	/**
	 * The present size of the array during instantiation. 
	 */
	private static final int INITIAL_SIZE = 10;
	/**
	 * The front of the Queue
	 */
	private int f = 0; // front
	/**
	 * the rear of the Queue
	 */
	private int r = 0; // rear
	/**
	 * the Current size of the Queue
	 */
	private int curSize = 0; // current size
	/**
	 * the array used for the Queue which the type is determined at compile time
	 */
	private Object[] queueArray;

	/**
	 * The constructor initializes the size and the array of the object
	 */
	public AQueue() {
		this.f = 0;
		this.r = 0;
		this.curSize = 0;
		this.queueArray = new Object[INITIAL_SIZE];
	}

	/**
	 * Returns the current size of the Queue , Run Time : O(1)
	 * 
	 * @return number of element in the queue
	 */
	@Override
	public int size() {
		return this.curSize;
	}
	
	/**
	 * Returns whether the queue is empty
	 * 
	 * @return the boolean if the queue is empty or not
	 */
	@Override
	public boolean isEmpty() {
		if (this.curSize == 0) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Returns the element at the front of the Queue, Run Time: O(1)
	 * 
	 * @return the first element of the Queue
	 * @throws EmptyQueueException if the queue is empty
	 */
	@Override
	public Object front() throws EmptyQueueException {
		if (this.curSize == 0) {
			throw new EmptyQueueException("Queue is Empty");
		} else {
			return this.queueArray[f];
		}
	}
	
	/**
	 * A helper method which increases the size of the array to double it's size, Run Time: O(n)
	 * 
	 * @return the new array with double the capacity and all the elements in the previous array
	 */
	private Object[] doubleCapacity() {
		Object[] queueArray1 = new Object[this.queueArray.length * SIZE_INCREASE];
		for (int i = 0; i < this.curSize; i++) {
			queueArray1[i] = this.queueArray[f];
			this.f = ((f + 1) % this.queueArray.length);
		}
		this.f = 0;
		this.r = this.curSize;
		return queueArray1;
	}
	
	/**
	 * Adds an element at the end of the Queue , growing the Queue is neccessary. Run Time: O(1)
	 * 
	 * @param o the object of the element to add to the Queue
	 */
	@Override
	public void enqueue(Object o) {
		if (this.curSize == this.queueArray.length) {
			this.queueArray = doubleCapacity();
		}
		this.queueArray[this.r] = o;
		this.r = (r + 1) % this.queueArray.length;
		this.curSize++;
	}
	
	/**
	 * Removes the front element and returns it. Run Time: O(n)
	 * 
	 * @return the first Object removed
	 * @throws EmptyQueueException if the queue is empty
	 */
	@Override
	public Object dequeue() throws EmptyQueueException {
		if (this.isEmpty()) {
			throw new EmptyQueueException("Queue is Empty");
		} else {
			Object result = new Object();
			result = this.queueArray[f];
			this.queueArray[f] = null;
			this.f = (f + 1) % this.queueArray.length;
			this.curSize--;
			return result;

		}
	}
	


	
}