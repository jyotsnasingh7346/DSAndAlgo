package com.dsandalgo.linkedList;

public class App {

	public static void main(String[] args) {

		LinkedList<String> names = new LinkedList<String>();
		names.insert("Ram");
		names.insert("Sita");
		names.insert("Lakshman");
		names.insert("Bharat");
		names.insert("Hanuman");
		
		// 1. traverse()
		System.out.println("Traversing after adding all names : ");
		names.traverse();
		System.out.println("Size : " + names.size());
		
		// 2. remove()
		names.remove("Bharat");
		System.out.println("Traversing after removing the name Bharat : ");
		System.out.println("Size : " + names.size());
		
		// 3. getMiddleNode()
		System.out.println("Middle node is : " + names.getMiddleNode());
		
		// 4. reverseLLInPlace()
		names.reverseLLInPlace();
		System.out.println("Reversed LL : ");
		names.traverse();
	}

}
