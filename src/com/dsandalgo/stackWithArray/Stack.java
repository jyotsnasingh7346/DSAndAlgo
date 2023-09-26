package com.dsandalgo.stackWithArray;

public class Stack<T> implements StackMethods<T> {

	/*
	 * Pre-requisites of a stack : > An array, to be used as a stack & > A counter
	 * variable to keep count of the number of elements in the stack.
	 */

	private T[] stack;
	private int count;

	/*
	 * We know that Object class is the parent class of all the classes in java, we
	 * can cast the object into our generic array.
	 */

	public Stack() {
		stack = (T[]) new Object[1];
	}

	@Override
	public void push(T data) {
		/*
		 * RTC = O(1) To add the 'data' at the top of the stack
		 * 
		 * ARRAYS ARE NOT DYNAMIC DATA STRUCTURES LIKE LINKED LISTS. So, necessary, we
		 * need to resize it. > If there are too many items, we double the size of the
		 * array. > If there are too less items, we shrink the size of the array.
		 */

		if (stack.length == count) {
			// This means the stack is full, double the size of the stack array.
			resize(2 * count);
		}
		
		// simply insert the data
		stack[count++] = data;

	}

	@Override
	public T pop() {

		// 1.Check if stack is empty
		if (isEmpty())
			return null;

		// 2. Else, Remove the top (last inserted) item & return it
		T item = stack[--count];

		// 3. To avoid memory leaks - obsolete the reference.
		stack[count] = null;

		// 4. Resize the array -> shrink
		// Lets only resize the array to its half, when the stack is only 25% full after
		// the pop() opertaion.
		if (count > 0 && count == stack.length / 4) {
			resize(stack.length / 2);
		}

		return item;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void resize(int capacity) {

		/*
		 * RTC = O(N) This is the bottleneck of the application. We need to create a new
		 * array, and transfer all the data from the old array, to the new array.
		 */

		// 1. Create the new array
		T[] stackCopy = (T[]) new Object[capacity];

		// 2. Transfer the items one by one
		for (int i = 0; i < count; ++i) {
			stackCopy[i] = stack[i];
		}

		// 3. Update the references
		stack = stackCopy;

	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

}
