package cse.assignment.one;
/**
 * This class is an array list class using an array which can be expanded at run time.
 *
 * The advantage of an array list using an oriented array is the running time of the methods "get" and "set" operations
 * have a runtime of O(1). The disadvantage of having to reallocate a new array when the current array becomes full.
 * 
 * @author Jeffrey Young , 211015146 , cse13175
 *
 * @param <E> The type of the array set at run time
 */

public class AArrayList<E> implements ArrayList<E> {
		
	/**
	 * The size increase every time the current array is max, the array will be doubled each time as the ArrayList 
	 * increases in size.
	 */
	private static final int SIZE_INCREASE = 2;
	/**
	 * The Initial size of the array, the array will double in size when array is required.
	 */
	private static final int INITIAL_SIZE = 10;

	/**
	 * n is the current number of objects in the array list.
	 */
	private int n = 0;
	
	/**
	 * the max size of the list
	 */
	private int size;
	
	/**
	 * The array used to construct the array list 
	 */
	private Object[] array;
	
	
	/**
	 * The constructor initialized with a user being able to set how big the ArrayList is
	 * 
	 */
	public AArrayList() {
		this.size = 0;
		this.array = new Object[INITIAL_SIZE];

	}

	/**
	 * An assessor method for obtaining the size of the array list, Run Time: O(1)
	 * 
	 * @return the size of the arrayList
	 */
	public int size() {
		return this.n;

	}

	/**
	 * Used to check if List is Empty 
	 * 
	 * @return boolean indicating if the list is empty
	 */
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * A helper method which to help increase the current array to double the size.
	 * @param j provide the current length of the array to double it's size.
	 * @return returns back the doubled array with all the elements from the previous array.
	 */
	@SuppressWarnings("unchecked")
	private E[] doubleCapacity(int j) {
		E[] array1 = (E[]) new Object[j * SIZE_INCREASE];
		this.size = j * SIZE_INCREASE;
		for(int i = 0 ; i< this.array.length ; i++ ){
			array1[i] = (E) this.array[i];
		}
		return array1;
	}

	/**
	 * Adds an element to the list at the specific index
	 * Running time O(n). Ammortized running time: O(1)
	 * 
	 * @param I the index in which to add the element. Any element currently in the position will be shifted (I + 1)
	 * @param e the value to be inserted
	 * @throws IndexOutOfBoundsException the index will be out of bounds if index is less than the size and index is less than 0.
	 */
	public void add(int I, E e) throws IndexOutOfBoundsException {
		if (I > this.n || I <0) {
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
		} else {
			if (this.n == this.size) {
				this.array = doubleCapacity(array.length);
				for (int i = n; i > I; i--) {
					this.array[i + 1] = this.array[i];
				}
				this.array[I] = e;
				this.n++;
			} else {
				for (int i = n; i > I; i--) {
					this.array[i + 1] = this.array[i];
				}
				this.array[I] = e;
				this.n++;
			}
		}
	}

	/**
	 * Retrieves an element from the list at a specified index
	 * Running time: O(1)
	 * @param i the index of the element to retrieve
	 * @return returns the element specified for the specified index
	 * @throws IndexOutOfBoundsException the index will be out of bounds if index is less than the size  and index is less than 0.
	 */

	@SuppressWarnings("unchecked")
	public E get(int i) throws IndexOutOfBoundsException {
		// i = this.n;
		if (i > this.n || i < 0) {
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
		} else {
			return (E) this.array[i];
		}
	}

	
	/**
	 * Removes an element at the specified index.
	 * Running time: O(1)
	 * @param i the index of the element to remove
	 * @return returns the element specified for removal
	 * @throws IndexOutOfBoundsException the index will be out of bounds if index is less than the size and index is less than 0.
	 */

	@SuppressWarnings("unchecked")
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i > this.n || i < 0) {
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
		} else {
		for (int j = i; j < this.size - 1; j++) {

			this.array[j] = this.array[j + 1];
		}
		this.n--;
		return (E) this.array;
		}
	}
	
	/**
	 * Sets the indexed element in the with the specified value
	 * Running Time : O(1)
	 * @param I the index value of the element to be set
	 * @param e the value of the element to be set
	 * @return the replaced element for any needed purpose
	 * @throws IndexOutOfBoundsException the index will be out of bounds if index is less than the size and index is less than 0.
	 */
		@SuppressWarnings("unchecked")
		public E set(int I, E e) throws IndexOutOfBoundsException {
		if (I > this.n || I < 0) {
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
		} else {
		this.array[I] = e;
		return (E) this.array;
		}
	}
	

}


