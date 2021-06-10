package DataStructures;

class Cqueue {
	//enqueue
	int rear = 0, tail = 0;
	//dequeue
	int head = 0, front = 0 , maxSize=0;
	
	int[] queue;
	
	public Cqueue(int maxSize) {
		queue = new int[maxSize];
		this.maxSize = maxSize;
		rear =-1;
		front = -1;
		
	}

	public void enqueue(int element) {
		
		if(rear == maxSize) {
			System.out.println("Q is full");
		}
		if(front==-1)
			front =0;
		rear = (rear + 1) % maxSize;
		queue[rear] = element;
		System.out.println("Inserted " + element);
	}
	
	// Removing an element
	  int deQueue() {
	    int element;
	    if (isEmpty()) {
	      System.out.println("Queue is empty");
	      return (-1);
	    } else {
	      element = queue[front];
	      if (front == rear) {
	        front = -1;
	        rear = -1;
	      } /* Q has only one element, so we reset the queue after deleting it. */
	      else {
	        front = (front + 1) % maxSize;
	      }
	      return (element);
	    }
	  }
	  
	// Check if the queue is empty
	  boolean isEmpty() {
	    if (front == -1)
	      return true;
	    else
	      return false;
	  }
	  
	  // Check if the queue is full
	  boolean isFull() {
	    if (front == 0 && rear == maxSize - 1) {
	      return true;
	    }
	  
	    /* I guess it is not a correct check 
	   * if (front == rear + 1) {
	      return true;
	    }*/
	  
	    return false;
	  } 
		
}
public class MyCircularQueue {
	
	static int maxSize = 4;

	
	public static void main(String ar[]) {
		Cqueue cq = new Cqueue(maxSize);
		cq.enqueue(10);
		cq.enqueue(16);
		cq.enqueue(12);
		
		// keep adding and test 
	}


}
