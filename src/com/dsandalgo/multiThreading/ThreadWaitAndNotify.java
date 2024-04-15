package com.dsandalgo.multiThreading;

/*
 * This class is used to demonstrate how to use synchronized methods with wait() & notify()
 */

class Calculator extends Thread {

	long sum;

	public void run() {
		synchronized (this) {
			for (int i = 0; i < 1000000; i++) {
				sum += i;
			}
			notify();	// this will notify all the waiting thread of this class
			System.out.println("notify() called");
		}
	}
}

public class ThreadWaitAndNotify extends Thread {

	public static void main(String[] args) {
		Calculator thread = new Calculator();
		thread.start();
		synchronized(thread) {
			try {						 
				System.out.println("wait() called");// when main thread calls thread.wait(),
				thread.wait();						// it will wait for thread to complete its execution
			} catch (InterruptedException e) {		// until notify() / notifyAll() is called in thread
				e.printStackTrace();
			}
		}
		System.out.println(thread.sum);
	}

}
