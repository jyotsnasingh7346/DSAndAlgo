package com.dsandalgo.WhatIsTheOutput;

import java.util.HashMap;
import java.util.Map;

class Color {
	private String name;

	public Color(String name) {
		super();
		this.name = name;
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	
}
public class Test {

	public static void main(String[] args) {
		
		Map<Color, String> map = new HashMap<>();
		
		map.put(new Color("Red"), "Red");
		map.put(new Color("Blue"), "Blue");
		map.put(new Color("Green"), "Green");
		
		System.out.println(map.size());
		System.out.println(map.get(map.get(new Color("Red"))));

	}

}
