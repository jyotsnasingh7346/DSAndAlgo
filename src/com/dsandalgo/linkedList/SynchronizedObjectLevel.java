package com.dsandalgo.linkedList;

/*
 * This program is used to demonstrate OBJECT LEVEL LOCKING USING SYNCHRONIZED keyword.
 * Note that each and every object has a lock.you just can't see that lock.
 * This lock is handled by - JVM, hence its called as an implicit lock / intrinsic lock.
 * 
 * If a thread wants to enter a synchronized non static instance method, it needs the current objects lock.
 * 
 * synchronized keyword working : 
 * 
 * Suppose, a thread t1 calls a method MyClass.m() - m is a synchronized method, with its classes' object obj1.
 * Then, t1 needs obj1's object lock to enter into that synchronized method.
 * Lets say t1 gets obj1's lock. and it has entered the synchronized block.
 * Now, when t2, a new thread comes and calls MyClass.m(), it will also need current object - obj1's lock.
 * But obj1's lock is already in use.
 * So, t2 has to wait till the time obj1's lock is available.
 * when t1 completes its execution, obj1's lock will be available.
 * Now, t2 can acquire this lock and enter the synchronization method.
 * 
 * Consider another method MyClass.m2() - m2 is also synchronized.
 * if a new method t3 calls MyClass.m2() which is synchronized, it again needs MyClass's current object, obj1.
 * But obj1 is already being used by t1.
 * 
 * t3 will wait for t1 & t2 to finish execution & will remain in blocked state until 
 * it can acquire obj1's lock even though no one is inside m2().
 * Hence object level lock is thread safe lock.
 * 
 * Consider a scenario where you have 2 different object, being used by 2 different threads,
 * calling the same synchronized method.
 * In that case, each thread will be executed together as t1 is not interfering with t2. 
 
 * Suppose there are 4 threads, and 2 objects : 
 * t1, t2 threads are operating on d1 object.
 * t3, t4 threads are operating on d2 object.
 * 
 * All 4 threads try to call a synchronized method m1().
 * 
 * What will be the execution sequence? 
 * 
 * t1 & t3 will acquire the locks of d1 & d2 respectively, and go into m1().
 * t2 & t4 will wait for t1 & t3 to finish execution & then acquire d1 & d2 locks respectively.
 * 
 * If 2 threads are accessing a synchronized method together, will there not be data inconsistency?
 * No, as there are operating on different objects of all time.
 * This achieves the purpose of synchronization.
 * 
 * Note that nowhere in the code have we asked any of the threads to acquire any particular object locks.
 * JSM provides the object locks, we can only tell which thread can operate on which object, but  
 * We cannot tell which thread will acquire the lock first.

 */

class Display {
	// this class displays a greeting 10 times and then calls sleep on the thread.
	
	public synchronized void wish(String name) {
		for (int i=0; i<10; i++) {
			System.out.println("Good morning, " + name);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThread extends Thread {
	// This class calls the wish method created above.
	
	Display d;
	String name;
	
	MyThread(Display d, String name){
		this.d = d;
		this.name = name;
	}
	
	public void run() {
		d.wish(name);
	}
}

public class SynchronizedObjectLevel {

	public static void main(String[] args) throws Exception {
		
		Display d1 = new Display();
		MyThread t1 = new MyThread(d1, "Ram");
		MyThread t2 = new MyThread(d1, "Sita");
		
		t1.start();
		t2.start();
		
		while(t1.isAlive()) {
			System.out.println("Current state of t1 : " + t1.getState());
			System.out.println("Current state of t2 : " + t2.getState());
			Thread.sleep(2000);
		}

	}

}
