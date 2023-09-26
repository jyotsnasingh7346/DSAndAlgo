package com.dsandalgo.stackProblems;

public class App {

	public static void main(String[] args) {
		
		System.out.println("------------------DesignQwithStack Interpreter------------------");
		DesignQwithStack obj = new DesignQwithStack();
		obj.enqueue(10);
		obj.enqueue(20);
		obj.enqueue(30);
		obj.enqueue(40);
		obj.enqueue(50);
		System.out.println(obj.dequeue());
		
		obj.enqueue(100);
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		
		System.out.println("------------------DesignQwithStackUsingRecursion Interpreter------------------");
		DesignQwithStackUsingRecursion que = new DesignQwithStackUsingRecursion();
		que.enqueue(10);
		que.enqueue(20);
		que.enqueue(30);
		que.enqueue(40);
		que.enqueue(50);
		System.out.println(que.dequeue());
		
		que.enqueue(100);
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		
		System.out.println("------------------MaxInStack Interpreter------------------");
		MaxInStack max = new MaxInStack();
		max.push(59);
		max.push(15);
		max.push(52);
		max.push(53);
		max.push(5);
		System.out.println("Max in Stack : " + max.getMaxItem());
		
		
		System.out.println("------------------Dijkstras Interpreter------------------");
		DijkstrasInterpreter algo = new DijkstrasInterpreter();
		algo.interpretExpression("( ( 4 * 2 ) - ( 0 + 0 ) )");
		algo.result();

	}

}
