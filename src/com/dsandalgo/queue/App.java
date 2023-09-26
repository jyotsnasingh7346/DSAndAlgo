package com.dsandalgo.queue;

public class App {

	public static void main(String[] args) {

		Queue<Integer> myQ = new Queue<Integer>();
		myQ.enqueue(10);
		myQ.enqueue(20);
		myQ.enqueue(30);
		myQ.enqueue(40);
		System.out.println(myQ.size());
		
		System.out.println(myQ.dequeue());
		System.out.println(myQ.dequeue());
		System.out.println(myQ.dequeue());
		
	}

}
