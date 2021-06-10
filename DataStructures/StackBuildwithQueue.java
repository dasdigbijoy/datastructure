package DataStructures;

import java.util.Queue; 

class StackBuildwithQueue { 
  
	private Queue<Integer> q1 = new java.util.LinkedList<>();
	private Queue<Integer> q2 = new java.util.LinkedList<>();
	private int top;
	
	public void pushSmart(int x) {
	    q2.add(x);
	    top = x;
	    while (!q1.isEmpty()) {                
	        q2.add(q1.remove());
	    }
	    Queue<Integer> temp = q1;
	    q1 = q2;
	    q2 = temp;
	}
	
	public void popSimple() {
	    q1.remove();
	    if (!q1.isEmpty()) {
	    	top = q1.peek();
	    }
	}
	
	public void push(int x) {
	    q1.add(x);
	    top = x;
	}
	
	// Removes the element on top of the stack.
	public void pop() {
	    while (q1.size() > 1) {
	        top = q1.remove();
	        q2.add(top);
	    }
	    q1.remove();
	    Queue<Integer> temp = q1;
	    q1 = q2;
	    q2 = temp;
	}
  
    // driver code 
    public static void main(String[] args) 
    { 
    	StackBuildwithQueue s = new StackBuildwithQueue(); 
        s.push(1); 
        s.push(2); 
        s.push(3); 
        
        System.out.println("the stack contains q1"+s.q1 );
        System.out.println("the stack contains q2"+s.q2 );
        s.pop();
        
        System.out.println("the stack contains q1"+s.q1 );
        System.out.println("the stack contains q2"+s.q2 );
        
        StackBuildwithQueue s1 = new StackBuildwithQueue(); 
        s1.pushSmart(4); 
        s1.pushSmart(6); 
        s1.pushSmart(5); 
        
        System.out.println("NEW stack contains q1"+s1.q1 );
        System.out.println("NEW stack contains q2"+s1.q2 );
        s1.popSimple();
        
        System.out.println("New stack contains q1"+s1.q1 );
        System.out.println("the stack contains q2"+s1.q2 );
        
        
    } 
}