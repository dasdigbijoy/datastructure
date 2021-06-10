package DataStructures;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LinkedListClient {

	//10:add->18:add->12:add
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		
		System.out.println("Insert and form Linked Lists");
		list.insert(10); 
		list.insert(18); 
		list.insert(15); 
		list.insert(12); 
		list.insertAtStart(16);
		list.insert(22); 
		
		list.insertAtAnyLocation(55,2);
		list.insertAtAnyLocation(60,0);
		
		list.show();
		
		int pos = 7;
		System.out.println("Delete an element at index "+pos);
		list.deleteAt(pos);
		
		list.show();
		
	    System.out.println("Reverse Linked List");
		list.reverseRecursively();
		list.show();
		
		/*System.out.println("Reverse Linked List No recursion");
		list.reverseLinkedList();
		list.show();*/
		
		System.out.println("Search a a given Node");
		System.out.println(list.search(15));
		System.out.println("Recursive a given Node");
		System.out.println(list.recursiveSearch(18));
		
		
				
	}

}
