package com.dsandalgo.dataStructures;

import java.util.LinkedList;

public class LinkedListQuestions {

	public void reverseLinkedList(LinkedList<Integer> ll) {
		
		LinkedList<Integer> ll1 = new LinkedList<>();
		ll.descendingIterator().forEachRemaining(ll1::add);
		System.out.print(ll1);
		
	}
	
	public static void main(String[] args) {
		
		LinkedListQuestions obj = new LinkedListQuestions();
			
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		System.out.println("Before Reverse : " + ll);
		System.out.print("After Reverse : ");
		obj.reverseLinkedList(ll);
		
	}

}
