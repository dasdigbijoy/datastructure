package DataStructures;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class HashMapBasicJava {
	public static void main(String[] args) 
    { 
		// Consider the hashmap contains 
        // student name and their marks 
        Map<String, Integer> hm =  
                    new HashMap<String, Integer>(); 
  
        // Adding mappings to HashMap 
        hm.put("GeeksforGeeks", 54); 
        hm.put("A computer portal", 80); 
        hm.put("For geeks", 82); 
  
        // Printing the HashMap 
        System.out.println("Created hashmap is" + hm); 
        int val = hm.get("For geeks");
        System.out.println("The val is "+val);
        System.out.println("HashMap Iterations: "); 
        
        // Getting an iterator 
        //entrySet - returns a set view of map
        Iterator hmIterator = hm.entrySet().iterator(); 
  
        // Iterate through the hashmap 
        while (hmIterator.hasNext()) { 
            /**
             * The Map.entrySet method returns a collection-view of the map, whose elements are of this class. 
             * The only way to obtain a reference to a map entry is from the iterator of this collection-view. 
             * These Map.Entry objects are valid only for the duration of the iteration;
             */
        	Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
            int marks = ((int)mapElement.getValue() + 10); 
            System.out.println(mapElement.getKey() + " : " + marks); 
        } 
        
        System.out.println(" Using for each loop ");
        
        // Using for-each loop 
        for (Map.Entry mapElement : hm.entrySet()) { 
            String key = (String)mapElement.getKey(); 
  
            // Add some bonus marks 
            // to all the students and print it 
            int value = ((int)mapElement.getValue() + 10); 
  
            System.out.println(key + " : " + value); 
        } 
        
        System.out.println("HashMap Lambda function after adding bonus marks:"); 
        
        // Using Hashmap.forEach() 
        hm.forEach((k, v) -> System.out.println(k + " : " + (v + 10) ) ); 
        
       System.out.println(" GENERATE HASH-TABLE ");
        generateHashTable();
    }

	private static void generateHashTable() {
		
		//1. Create Hashtable
        Map<Integer, String> hashtable = new Hashtable<>();
         
        //2. Add mappings to hashtable 
        hashtable.put(1,  "A");
        hashtable.put(2,  "B" );
        hashtable.put(3,  "C");
         
        System.out.println(hashtable);
         
        //3. Get a mapping by key
        String value = hashtable.get(1);        //A
        System.out.println(value);
         
        //4. Remove a mapping
        hashtable.remove(3);            //3 is deleted
         
        //5. Iterate over mappings
        Iterator<Integer> itr = hashtable.keySet().iterator();
         
        while(itr.hasNext()) 
        {
            Integer key = itr.next();
            String mappedValue = hashtable.get(key);
             
            System.out.println("Key: " + key + ", Value: " + mappedValue);
        }
		
	} 
}


