------------------------------------------------------------------------------------------------------------------------
----------------------------------------STEPS TO CREATE YOUR OWN STACK INFRA & ITS METHODS------------------
------------------------------------------------------------------------------------------------------------

> A stack is a data structure that can be implemented in 2 ways :
 
	* in the form of an Array
	* in the form of a LinkedList

> A stack follows LIFO principle, 'Last In First Out'

------------------------------------------------------------------------------------------------------------------------

1. Node<T>.java
This class is the skeleton of creating the stack Node.

> Node is a class for Generic type.
> It has 2 member variables.
	* T data					// represents the data in that node.
	* Node<T> nextNode			// represents the reference to the nextNode.
> It has a parameterized constructor with only T data passed as a parameter.
> It has getters & setters for both the member variables.
> It has an overridden toString() method.
------------------------------------------------------------------------------------------------------------------------

2. StackMethods.java

> This is an interface that contains abstract methods for a Stack.
> These are functions you can perform on your Stack, like,
	* push(T data)
	* pop()
	* size()
	* resize(int capacity)
	* isEmpty()
------------------------------------------------------------------------------------------------------------------------

3. Stack.java

> Stack is a class for Generic type.
> Here, we implement the functions of a stack & write logic by using Node class' variables & methods.
> We have 2 member variables here :
	* private T[] stack;			// an implementation of a stack
	* private int count;			// a counter for node in the LL
------------------------------------------------------------------------------------------------------------------------

4. App.java

> Class with main() for consuming the LinkedList.

------------------------------------------------------------------------------------------------------------------------