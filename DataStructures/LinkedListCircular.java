package DataStructures;

public class LinkedListCircular {
	Node head = null;
	Node tail = null;
	
	public void addNode(int data) {
		Node inputNode = new Node();
		inputNode.data = data;
		inputNode.next = null;
		/*There are no elements already added. In this case, we'll make the new node
		 * we add as both the head and tail of the list since there is only one node
		 */
		if(head == null) {
			head = inputNode;
			
		} 
		/*
		* There are one or more elements already added to the list. In this case, the existing tail 
		* should point to the new node and the newly added node will become the tail
		*/ 
		else {
			tail.next = inputNode;
		}
		 tail = inputNode;
		 tail.next= head;
	}
	
	public void show() {
		System.out.println("Here's my Linked List");
		Node node = head;
		while(head != tail) {
			System.out.println(" Data : " + node.data);
			node = node.next;
			tail=node;
		}
		System.out.println(" Data : " + node.data);
	}
	
	public static void main(String ar[]) {
		System.out.println("Print Circular Linked List");
		LinkedListCircular cl = new LinkedListCircular();
		cl.addNode(12);
		cl.addNode(18);
		cl.addNode(30);
		
		cl.show();
		
	/*	System.out.println("Reverse ");
		cl.reverseLinkedList();
		cl.show();
	*/	
		
	}
	



}
