package DataStructures;

import java.util.*;

class MyStack
{
	private Node top;

	public MyStack() {
		this.top = null;
	}

	// Utility function to add an element x in the MyStack
	public void push(int x) // insert at the beginning
	{
		// Allocate the new node in the heap
		Node node = new Node();

		// check if MyStack (heap) is full. Then inserting an element would
		// lead to MyStack overflow
		if (node == null)
		{
			System.out.print("\nHeap Overflow");
			return;
		}

		System.out.println("Inserting " + x);

		// set the data in allocated node
		node.data = x;

		// Set the .next pointer of the new node to point to the current
		// top node of the list
		node.next = top;

		// update top pointer
		top = node;
	}

	// Utility function to check if the MyStack is empty or not
	public boolean isEmpty()
	{
		return top == null;
	}

	// Utility function to return top element in a MyStack
	public int peek()
	{
		// check for empty MyStack
		if (!isEmpty()) {
			return top.data;
		}
		else {
			System.out.println("MyStack is empty");
			return -1;
		}
	}

	// Utility function to pop top element from the MyStack
	public void pop() // remove at the beginning
	{
		// check for MyStack underflow
		if (top == null)
		{
			System.out.print("\nMyStack Underflow");
			return;
		}

		System.out.println("Removing " + peek());

		// update the top pointer to point to the next node
		top = (top).next;
	}
}

public class StackBuildWithLinkedList {

	public static void main(String[] args)
	{
		MyStack MyStack = new MyStack();

		MyStack.push(1);
		MyStack.push(2);
		MyStack.push(3);

		System.out.println("Top element is " + MyStack.peek());

		MyStack.pop();
		MyStack.pop();
		MyStack.pop();

		if (MyStack.isEmpty()) {
			System.out.print("MyStack is empty");
		} else {
			System.out.print("MyStack is not empty");
		}
	}
}
