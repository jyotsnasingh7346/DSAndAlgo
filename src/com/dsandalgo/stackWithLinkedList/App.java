package com.dsandalgo.stackWithLinkedList;

import java.util.Iterator;

public class App {

	public static void main(String[] args) {
		
		/*
		 * Since we can only manipulate the rootNode and not any other node, 
		 * that means we can't compare nodes in Stack with LL.
		 * Hence, no use of extending the Comparable<T> class.
		 */
		
		// Lets create a Stack with strings and play with it.
		
		// 1. push()
		Stack<String> names = new Stack<>();
		names.push("Krishna");
		names.push("Arjun");
		names.push("Bheem");
		
		// 2. size()
		System.out.println("Size : " + names.size());
		
		// 3. isEmpty()
		System.out.println("Is names empty? : " + names.isEmpty());
		
		// 4. pop()
		names.pop();
		while (!names.isEmpty()) {
			System.out.println(names.pop());
		}
		
	}

}
