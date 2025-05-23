package stack;

import java.util.LinkedList;

public interface Stack<E> {

	LinkedList<Object> Stack = new LinkedList<>();

	/**
	 * method to see if the Stack has any Objects
	 * @return empty -> false
	 */
	public default boolean isEmpty(){
        if (Stack.getFirst()==null){
			return true;
		}else{return false;}
	}

	/**
	 * the first Element stays
	 * @return first element
	 * @throws Underflow
	 */
	public default Object top() throws Underflow{
		return Stack.getFirst();
	}

	public default void push(E element){
		Stack.addFirst(element);
	}

	public default Object pop() throws Underflow {
		return Stack.removeFirst();
	}
}
// weird