package com.dsandalgo.designPatterns.ServiceLocatorDP;

public class Cache {
	
	private static Cache cache;
	

	public Service getService(String serviceName) {
		return cache.getService(serviceName);
	}

	public void addService(Service service) {
		cache.addService(service);
	}

}
