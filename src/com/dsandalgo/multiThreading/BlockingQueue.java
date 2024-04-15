package com.dsandalgo.multiThreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/*
 *  Suppose there are 2 threads A & B operation on a shared resource R. 
	A needs to inform B of some important changes in R. 
	How would you solve this scenario?
 */
/*
 * This is a classic example of a Producer - Consumer model.
	We can solve this by implementing a Queue in place, and using wait and notify on A & B. 
	We can achieve a synchronous communication in this way. 
	A waits to put() his msg into Q if the Q is full. 
	B waits to take() his msg from the Q is the Q is empty.
	When A puts his msg, he notify()s B.
	when B gets a notifi()cation, he takes() the msg from the Q.
 */
public class BlockingQueue<T> {
	private Queue<T> Q = new LinkedList<>();
	private final int capacity;
	
	public BlockingQueue(int capacity) {
		System.out.println("Q created");
		this.capacity = capacity;
	}
	
	public synchronized void put(T element) throws InterruptedException {
		System.out.println("inside put()");
		while(Q.size() == capacity) {
			wait();
		}
		Q.add(element);
		notifyAll();
	}
	
	public synchronized T take() throws InterruptedException {
		System.out.println("inside take()");
		while(Q.isEmpty()) {
			wait();
		}
		T element = Q.remove();
		notifyAll();
		return element;
	}
	
	public static void main(String[] args) {
		System.out.println("inside main()");
		BlockingQueue<Integer> Q = new BlockingQueue<>(2);
		
		Runnable producer = new Runnable() {
			Random random = new Random();
			
			@Override
			public void run() {
				try {
					while(true){
						int element = random.nextInt(1000);
						Q.put(element);
						System.out.println("Produced : " + element);
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable consumer = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						Integer element = Q.take();
						System.out.println("Consumed : " + element);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread producerT = new Thread(producer);
		Thread consumerT = new Thread(consumer);
		
		producerT.start();
		consumerT.start();
		
		
	}
}
