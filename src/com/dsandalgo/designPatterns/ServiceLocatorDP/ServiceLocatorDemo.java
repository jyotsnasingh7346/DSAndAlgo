package com.dsandalgo.designPatterns.ServiceLocatorDP;

public class ServiceLocatorDemo {

	public static void main(String[] args) {
		
		Service service1 = ServiceLocator.getService("Car");
		service1.execute();
		Service service2 = ServiceLocator.getService("Bike");
		service2.execute();
		Service service3 = ServiceLocator.getService("Car");
		service3.execute();
		Service service4 = ServiceLocator.getService("Bike");
		service4.execute();

		
	}

}
