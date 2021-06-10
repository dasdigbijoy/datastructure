package DataStructures;

public class LinkedList {
	Node head;
	//insert data to LinkedList
	public void insert(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(head==null) {
			//assign the first Object 
			head = node;
		} else {
				//Get the first Node
			    Node n =  head;
			    
			    //traverse through node
			    while(n.next!=null) {
			    	n = n.next;
			    }
			   
			    //resetting from prev null and getting linked with last insert node.
			    n.next = node;
			    
		}
	}
	
	public void insertAtStart(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		node.next = head;
		head=node;
				
	}
	
	//need to consider the 0th location as well.
	public void insertAtAnyLocation(int data, int pos) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(pos==0) {
			insertAtStart(data);
		} else {
			Node n = head;
			for(int i=0; i<pos-1;i++) {
				n=n.next;
			}
			node.next = n.next;
			n.next = node;
		}
	
		
	}
	
	//delete at any location
	public void deleteAt(int pos) {
		//first element
		Node n = head;
		if(pos==0) {
			head = head.next;
		}else {
			for(int i=0; i<pos-1;i++) {
				n=n.next;
			}
			Node temp = n.next;
			n.next = temp.next;
		}
		
	}
	

	public Node tail() {
        Node tail = head;
     
        // Find last element of linked list known as tail
        while(tail.next != null){
            tail = tail.next;
        }      
        return tail;
     
    }
	
	
	/**
     * Reverse linked list using 3 pointers approach in O(n) time
     * It basically creates a new list by reversing direction, and
     * subsequently insert the element at the start of the list.
     */
   public void reverseIteratively() {
       Node current = head;
       Node previous = null;
       Node forward = null;
    
       // traversing linked list until there is no more element
       while(current.next != null){
        
           // Saving reference of next node, since we are changing current node
           forward = current.next;
        
           // Inserting node at start of new list
           current.next = previous;
           previous = current;
        
           // Advancing to next node
           current = forward;
       }
    
       head = current;
       head.next = previous;
   }
   
   /*
    * Reverse a singly linked list using recursion. In recursion Stack is
    * used to store data.   
    * 1. Traverse linked list till we find the tail, 
    * that would be new head for reversed linked list.
    */
   private Node reverseRecursively(Node node){
      Node newHead;
      System.out.println("2");
      //base case - tail of original linked list
      if((node.next == null)){
    	  System.out.println("3");
          return node;
      }
      System.out.println("4");
     //First time reccursive. then after node traversal, continues with step 5....
      newHead = reverseRecursively(node.next);
      System.out.println("5");
      //reverse the link e.g. C->D->null will be null       
      node.next.next = node;
      System.out.println("6");
      node.next = null;    
      System.out.println("7");
     //again call recursive.
      return newHead;
         }
 
   public void reverseRecursively(){
	   System.out.println("1");
       head = reverseRecursively(head);
       System.out.println("8");
   }  
	
   //Checks whether the value x is present in linked list 
   public boolean search(int x) 
   { 
       Node current = head;    //Initialize current 
       while (current != null) 
       { 
           if (current.data == x) 
               return true;    //data found 
           current = current.next; 
       } 
       return false;    //data not found 
   } 
   
   // Checks whether the value x is present 
   // in linked list 
   public boolean recursiveSearch(int x) 
   { 
       // Base case 
       if (head == null) 
           return false; 
 
       // If key is present in current node, 
       // return true 
       if (head.data == x) {
    	   return true;  
       } else {
    	   head = head.next;
       }
           
 
       // Recur for remaining list 
       return recursiveSearch(x); 
   } 
   
	//Print the List
	public void show() {
		System.out.println("Here's my Linked List");
		Node node = head;
		while(node.next!=null) {
			System.out.print(" " + node.data +"->");
			node = node.next;
		}
		System.out.println(" " + node.data);
	}

	protected void reverseLinkedList() {
		Node pointer=head;
		Node previous = null,current = null;
		
		while(pointer!=null) {
			current = pointer;
			pointer = pointer.next;
			
			//Reverse
			current.next = previous;
			previous = current;
			head = current; 
		}
		
	}
	
}
