package com.dsandalgo.designPatterns.ServiceLocatorDP;

public class ServiceLocator {

	// The ServiceLocator doesn't directly go to the ContextRegistry,
	// first it goes to the cache, and checks if cache holds an object previously used.
	// if yes, the ServiceLocator fetches that, if no, then it goes to the ContextRegistry
	
	private static Cache cache;
	
	static {
		cache = new Cache();
	}
	
	public static Service getService(String serviceName) {
		Service service = cache.getService(serviceName);
		
		if (service == null) {
			JndiContext context = new JndiContext();
			service = context.lookup(serviceName);
			cache.addService(service);
		}
		
		return service;
	}

}
