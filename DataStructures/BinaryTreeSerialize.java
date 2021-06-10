package DataStructures;

public class BinaryTreeSerialize {
	static TreeNode root;
	
	public static void main(String ar[]) {
		BinaryTreeSerialize bt = new BinaryTreeSerialize();
		root = new TreeNode(12);
		
		System.out.println("Binary Tree Example");
        System.out.println("Building tree with root value " + root.key);
		
        bt.insert(root,2);
        bt.insert(root, 4);
        bt.insert(root, 8);
        bt.insert(root, 6);
        bt.insert(root, 7);
        bt.insert(root, 3);
        bt.insert(root, 9);
        
        System.out.println("PRE-ORDER Traversal ");
        bt.traversePreOrderRecursive(root);
        System.out.println();
        
       //Pre-Order Traveral
       System.out.println("PRE-ORDER Traversal Serialize");
       String values = preOrderTraversalSerialize(root);
       System.out.println(values);
        
       System.out.println("de-serializing");
       deserializeBinaryTree(values);
     
       //bt.traversePreOrderRecursive(start);
        
	}
	 
	private static void deserializeBinaryTree(String values) {
		//Deserialize Binary Tree
	    
	        String[] temp = values.split(",");
	        //return deserialize(temp, new int[] {0});
	         deserializeUsingStaticCounter(temp);
	    
	}

	private static void deserializeUsingStaticCounter(String[] data) {
		int index = 0; 
		if (index > data.length || data[index].equals("null")) {
	            index++;
	            return ;
	        }
	 
	       
	        for(int i=0; i<data.length;i++) {
	        	TreeNode node = new TreeNode(Integer.parseInt(data[i]));
	        	System.out.print(" "+node.key);
	        }
	        
	}

	private static String preOrderTraversalSerialize(TreeNode node) {
		StringBuilder sb  = new StringBuilder();
		if(node!=null) {
			
			sb.append(node.key);
			sb.append(",");
			 sb.append(preOrderTraversalSerialize(node.left));
			 sb.append(preOrderTraversalSerialize(node.right));
		}
		
		return sb.toString();
		
	}
	
	public void traversePreOrderRecursive(TreeNode node) {
		if(node!=null) {
			 System.out.print(" " + node.key);
			 traversePreOrderRecursive(node.left);
			 traversePreOrderRecursive(node.right);
		}
		
	}
		
	

	private static String serialization(TreeNode root2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(TreeNode node, int value) {
		System.out.println("The Tree insert starts for input "+value);
		if (value < node.key) {
			if (node.left != null) {
				insert(node.left, value);
			} else {
				System.out.println(" Inserted " + value + " to left of " + node.key);
				node.left = new TreeNode(value);
			}
		} else if (value > node.key) {
			if (node.right != null) {
				insert(node.right, value);
			} else {
				System.out.println("  Inserted " + value + " to right of " + node.key);
				node.right = new TreeNode(value);
			}
		}
	}
	
	//Serialize 
	
}
