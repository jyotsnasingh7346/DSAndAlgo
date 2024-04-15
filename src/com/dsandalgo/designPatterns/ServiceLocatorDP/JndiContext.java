package com.dsandalgo.designPatterns.ServiceLocatorDP;

public class JndiContext {
	
	// This will act as our ContextRegistry which returns us the service based on the client input
	// instead of us creating an object, java will do it for us.
	
		public Service lookup(String jndiName) {
			
			Service service = null;
			
			if (jndiName.equalsIgnoreCase("Car")) {
				service = new CarService();
			} else if (jndiName.equalsIgnoreCase("Bike")) {
				service = new BikeService();
			}
			
			System.out.println("Found in the ContextRegistry : " + jndiName);
			return service;
		}
	
	
}
