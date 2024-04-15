package com.dsandalgo.interviewPrep;

import java.util.TreeSet;

class Drink implements Comparable {

	public String name;
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	public Object m() {
		// after which line does the Float object o becomes eligible
		// for garbage collection?
		// after line 7 
		/*
		 * In summary, although o is assigned null on line 6, 
		 * the object itself isn't garbage collected until line 7 
		 * because it's still accessible through the object array. 
		 * Once the array element is also assigned null, 
		 * the object becomes unreachable and can be 
		 * reclaimed by the garbage collector.
		 */
		
//		Object o = new Float(3.14f); // line 3
//		Object[] oa = new Object[1];
//		oa[0] = o; // line 5
//		o = null; // line 6
//		oa[0] = null; // line 7
//		
//		return o; // line 8
//	}
}

public class TeaOrCoffee {
	
	public static void main(String[] args) {
		Drink one = new Drink();
		Drink two = new Drink();
		
		one.name = "Coffee";
		two.name = "Tea";
		
		TreeSet<Drink> set = new TreeSet<>();
		set.add(one);
		set.add(two);
		
		for (Drink o : set) {
			System.out.println(o + " ");
		}
	}
}