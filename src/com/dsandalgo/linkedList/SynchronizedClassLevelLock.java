package com.dsandalgo.linkedList;

/*
 * This class is used to demonstrate CLASS LEVEL LOCK using SYNCHRONIZED keyword.
 * The only difference in this program and its corresponding object level class, is :
 * 		* The wish() is now static
 * 		* There 2 objects d1 & d2.
 * 
 * When you do d1.wish(), (wish is static)
 * implicitly, it is Displayy.wish().... which means class level & not object level
 * because static belongs to a class.
 * 
 * Every class in java has an object called class (which is of the class 'java.lang.Class')
 * When you create a .java file and compile it, a .class file is also created.
 * this is that class.
 * This class object holds the meta data of that class, its package, its variables, interfaces, enums, etc.
 * 
 * Now, if any thread wants to enter s 'static synchronized area', it needs this 'class' objects lock.
 * Here, Displayy.class (created & managed by JVM) is the object that is the reference 
 * created when the Displayy.wish() is done.
 * 
 * In the below case, when we do 'Displayy.wish()' via t1 & t2,
 * Both of these threads need the 'Displayy.class' objects lock.
 * 
 * Therefore, A class level lock implicitly means object level lock, where
 * the object is 'class' object of that particular Class (here, Displayy).
 * 
 * There a class is never locked, only its context is locked, by the class object.
 * 
 * Note that this class object is created only once.
 * Meaning, every class in java will have only 1 'class' object.
 * 
 * You can do d1.getClass() & this class object will be returned.
 * 
 * You can call this 'class' reference in 3 ways : 
 * 		d1.getClass(200);
 * 		d2.getClass(200);
 * 		Displayy.class;
 * 
 * Imagine in your class you has 4 methods, & 8 threads 
 * m1 is static & synchronized (requires a class level lock since static)
 * m2 is synchronized (requires an object level lock)
 * m3 (requires no locks)
 * m4 is static (requires no locks, but objects cant access it)
 * 
 * t1 & t2 are operating on m1
 * t3 & t4 are operating on m2
 * t5 & t6 are operating on m3
 * t7 & t8 are operating on m4
 * 
 * Now,
 * 
 * t1 has class lock (Display.class)
 * t2 is blocked for class lock 
 * t3 has d1 object lock -> d1.m1()
 * t4 is in blocked state for d1 lock
 * 
 * Suppose, t10 comes here and tries to access method m2 with d2 object
 * t10 has d2 lock -> d2.m2()
 * 
 * t5 executes without any locks
 * t6 executes without any locks
 * t7 executes without any locks
 * t8 executes without any lock since only synchronized methods need a lock.
 * 
 * 
 * NOTE : 
 * 		Object level lock is for non static synchronized methods
 * 		Class level lock is for static synchronized methods
 * 		But both the threads are locking an object & never a class.
 * 
 */

class Displayy {
	// this class displays a greeting 10 times and then calls sleep on the thread.
	
	public static synchronized void wish(String name) {
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

class MyyThread extends Thread {
	// This class calls the wish method created above.
	
	Displayy d;
	String name;
	
	MyyThread(Displayy d, String name){
		this.d = d;
		this.name = name;
	}
	
	public void run() {
		Displayy.wish(name);
	}
}

public class SynchronizedClassLevelLock {

	// First, Good Morning, Rama will be printed 10 times
	// Then, Good Morning, Sita will be printed 10 times.
	
	
	public static void main(String[] args) throws Exception {

		Displayy d1 = new Displayy();
		Displayy d2 = new Displayy();

		MyyThread t1 = new MyyThread(d1, "Ram");
		MyyThread t2 = new MyyThread(d2, "Sita");

		t1.start();
		t2.start();

	}

}
