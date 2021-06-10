package DataStructures;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class LinkedListJavaMethods  {

	public static void main(String[] args) {

		ObjectCreationChange();

		// Java LinkedList
		LinkedList<String> singlyLinkedList = new LinkedList<>();
		singlyLinkedList.add("Joy");
		singlyLinkedList.add("Mishtu");
		singlyLinkedList.add("Abhi");

		System.out.println("Un-Sorted list is" + singlyLinkedList);
		Collections.sort(singlyLinkedList);

		System.out.println("Sorted list is" + singlyLinkedList);

		// Not working Fix this
/*		Collections.sort(singlyLinkedList, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
			return s1.length() - s2.length();
			} } );*/


		


		System.out.println("Comparator Sorted list is" + singlyLinkedList);

	}

	private static void ObjectCreationChange() {

		System.out.println("Object Creation ");
		// Creating object of the
		// class linked list
		LinkedList<String> ll = new LinkedList<String>();

		// Adding elements to the linked list
		ll.add("A");
		ll.add("B");
		ll.addLast("C");
		ll.addFirst("D");
		ll.add(2, "E");

		System.out.println(ll);


		// Not working Fix this
/*		Collections.sort(ll, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		System.out.println(ll);*/

	}

}
