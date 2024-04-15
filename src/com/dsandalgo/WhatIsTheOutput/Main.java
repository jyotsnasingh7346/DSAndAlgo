package com.dsandalgo.WhatIsTheOutput;

public class Main implements Runnable {

	public Main(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		
		new Thread(new Main("Wallace")).start();
		new Thread(new Main("Gromit")).start();
		
	}
	
	private String name;

	@Override
	public void run() {
		message(1);
		message(2);
		
	}

	private synchronized void message(int n) {
		System.out.println(name + "-" + n + "");
		
	}


}
