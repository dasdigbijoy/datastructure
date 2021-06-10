package DataStructures;

class HashNode {
	int data;
	HashNode next;
	
	public HashNode(int data) {
		this.data = data;
	}
}
public class HashSetDesign {

	//int size;
	static HashNode[] arrayNodes = new HashNode[10];
	
	//hashcode
	public int getkeys(int val) {
		return  val%arrayNodes.length;
	}
	
	public void add(int data) {
		//Into different buckets
	  int index = 	getkeys(data);
	  
	  //bucket is empty
	  if(arrayNodes[index] == null) {
		  HashNode node = new HashNode(data);
		  node.next = null;
		  arrayNodes[index] = node;
		  
	  } else {
		  HashNode node =  arrayNodes[index];
		  
		  while(node !=null && node.data!=data) {
			  node= node.next;
		  }
		  
		  if(node!=null)
			  return;
		  
		  HashNode newNode = new HashNode(data);
		 newNode.next = arrayNodes[index];
		 arrayNodes[index] = newNode;
	  }
	}
	
	public void display() {
		System.out.println("Start displaying");
		if(arrayNodes!=null) {
			for(int i=0; i<=arrayNodes.length -1; i++) {
				//System.out.println("This is for Bucket "+i);
				HashNode n = arrayNodes[i];
				if(n!=null) {
				while(n.next!=null) {
					System.out.print(" "+n.data);
					n=n.next;
				}
				System.out.print(" "+n.data);	
			}
				//System.out.println();
			}
		}
		System.out.println();
		
	}
	
	public void remove(int data) {
		System.out.println("Remove element "+data);
		int index = 	getkeys(data);
		if (this.arrayNodes[index] == null) {
			return;
		} else {
			HashNode p = this.arrayNodes[index];

			if (p.data == data) {
				this.arrayNodes[index] = p.next;
				return;
			}

			while (p.next != null && p.next.data != data) {
				p = p.next;
			}
							
			
			if (p.next == null)
				return;

			p.next = p.next.next;
		}
	}
	
	 /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	 int index = 	getkeys(key);
        if(this.arrayNodes[index] == null)
            return false;
        HashNode p = this.arrayNodes[index];
        while(p != null && p.data != key)
            p = p.next;
       
        return p != null;
    }
	  
	public static void main(String[] args) {
		HashSetDesign hash = new HashSetDesign();
		hash.add(10);
		hash.add(16);
		hash.add(20);
		
		hash.display();
		
		hash.remove(16);
		
		hash.display();
		
		System.out.println(" 16 containing on set is "+hash.contains(16));
		System.out.println("  10 containing on set is "+ hash.contains(10));
	}

}
