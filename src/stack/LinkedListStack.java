package stack;

public class LinkedListStack<E> implements Stack<E> {
	private class Node<T> {
		T data;
		Node<T> next;
		// implement the nodes here
		/**
		 * toString method that matches test cases for easy testing.
		 */
		@Override
		public String toString() {
			return ((next == null) ? "" : next.toString()+"-") + data.toString() ;
		}
	}

	Node<E> top;

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public E top() throws Underflow {
		return null;
	}

	//@Override
	public void push(E element) {

	}

	@Override
	public Object pop() throws Underflow {
		return null;
	}

	/**
	 * toString method that matches test cases for easy testing.
	 * @return
	 */
	@Override
	public String toString() {
		if (top == null)
			return "<empty>";
		return "<stack: "+top.toString()+">";
	}
}
