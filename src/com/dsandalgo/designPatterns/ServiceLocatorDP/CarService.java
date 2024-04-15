package com.dsandalgo.designPatterns.ServiceLocatorDP;

public class CarService implements Service {

	@Override
	public String getName() {
		return "Car";
	}

	@Override
	public void execute() {
		System.out.println("Running Car");
	}

}
