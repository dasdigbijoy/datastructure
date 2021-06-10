package DataStructures;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemoJava { 
    public static void main(String args[]) 
    { 
        // Creating an empty PriorityQueue 
        Queue<Integer> queue = new PriorityQueue<Integer>(); 
  
        // Use add() method to add elements into the Queue 
        queue.add(10); 
        queue.add(15); 
        queue.add(30); 
        queue.add(20); 
        queue.add(5); 
  
        // Displaying the PriorityQueue 
        System.out.println("PriorityQueue: " + queue); 
  
        queue.remove(20);
        // Creating an iterator 
        Iterator<Integer> value = queue.iterator(); 
       
  
        // Displaying the values after iterating through the queue 
        System.out.println("The iterator values are: "); 
        while (value.hasNext()) { 
            System.out.println(value.next()); 
        } 
    } 
} 
