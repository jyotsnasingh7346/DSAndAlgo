package com.dsandalgo.doublyLinkedList;

public class App {

	public static void main(String[] args) {

		DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
		
		dll.insert("Shambhu");
		dll.insert("Shankar");
		dll.insert("Namah");
		dll.insert("Shivaay");
		
		dll.traverseFromHeadToTail();
		System.out.println("-----------------------------------");
		dll.traverseFromTailToHead();
		System.out.println("-----------------------------------");
		
		dll.remove("shiv");
		dll.traverseFromHeadToTail();

	}

}
