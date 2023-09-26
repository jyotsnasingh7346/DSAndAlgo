------------------------------------------------------------------------------------------------------------------------
-------------------------------STEPS TO CREATE YOUR OWN LINKED LIST INFRA & ITS METHODS---------------------
------------------------------------------------------------------------------------------------------------

1. Node<T>.java
This class is the skeleton of creating the LinkedList Node.

> Node is a class that extends Comparable<T> interface for Generic type.
> It has 2 member variables.
	* T data					// represents the data in that node.
	* Node<T> nextNode			// represents the reference to the nextNode.
> It has a parameterized constructor with only T data passed as a parameter.
> It has getters & setters for both the member variables.
> It has an overridden toString() method.
------------------------------------------------------------------------------------------------------------------------

2. List.java

> This is an interface that contains abstract methods for a List.
> These are functions you can perform on your LinkedList, like,
	* insert(T data)
	* remove(T data)
	* traverse()
	* size()
	* getMiddleNode()
------------------------------------------------------------------------------------------------------------------------

3. LinkedList.java

> LinkedList is a class that extends Comparable<T> interface for Generic type & implements the List interface.
> Here, we implement the functions of List interface & write logic by using Node class' variables & methods.
> We have 2 member variables here :
	* private Node<T> head;			// also called the rootNode, we have to have the access of rootNode.
	* private int noOfNode;			// a counter for node in the LL
------------------------------------------------------------------------------------------------------------------------

4. App.java

> Class with main() for consuming the LinkedList.

------------------------------------------------------------------------------------------------------------------------

5. Person.java

> We create a Person class to use the Framework of LinkedList that we have created.
> Since our Node.java class & LinkedList class, both are generic(<T>), This frame can be used for any data & any no. of parameters.
> We can create a LinkedList containing a list of people.
> We can also compare the objects inside this list.

------------------------------------------------------------------------------------------------------------------------