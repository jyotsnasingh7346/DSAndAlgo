package com.dsandalgo.designPatterns.ServiceLocatorDP;

public class BikeService implements Service {

	@Override
	public String getName() {
		return "Bike";
	}

	@Override
	public void execute() {
		System.out.println("Running Bike");
	}

}
