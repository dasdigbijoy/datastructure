package DataStructures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetBasicsJava {
	public static void main(String[] args) 
    {
		Set<String> set=new HashSet();  
        set.add("One");    
        set.add("Two");    
        set.add("Three");   
        set.add("Four");  
        set.add("Five");  
       
        //ignore the duplicate values.
        set.add("Three");
        
        Iterator<String> i=set.iterator();  
        while(i.hasNext())  
        {  
        System.out.println(i.next());  
        }  
    }
}
