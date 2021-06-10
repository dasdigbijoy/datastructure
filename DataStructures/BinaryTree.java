package DataStructures;

import java.math.RoundingMode;
import java.util.Queue;
import java.util.Stack;



public class BinaryTree {

	static TreeNode root;
	static int sum;
	static int predecessor=0, successor = 0;
	
	BinaryTree(int item) {
		root = new TreeNode(item);
	}
	
	BinaryTree() {
		root = null;
	}
	
	public static void main(String ar[]) {
		BinaryTree bt = new BinaryTree();
		
		/*bt.root = new TreeNode(1);
		
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		
		bt.root.left.left = new TreeNode(4);
		bt.root.left.right = new TreeNode(5);
		*/
		 /*  Tree formation
			        1 
			    /       \ 
			   2          3 
			 /   \       /  \ 
			4    5  null  null 
			/   \ 
			null null 
		  */
		root = new TreeNode(5);
		System.out.println("Binary Search Tree Example");
        System.out.println("Building tree with root value " + root.key);
		
        bt.insert(root,2);
        bt.insert(root, 4);
        bt.insert(root, 8);
        bt.insert(root, 6);
        bt.insert(root, 7);
        bt.insert(root, 3);
        bt.insert(root, 9);
        
        /*  Tree formation after inserting all nodes
		       
		       	   5 
			    /      \ 
			   2          8 
			 /   \       /  \ 
		  null    4     6     9 
	             /        \
                3          7
         */
        
        //IN-ORDER TRAVERSAL
        System.out.println("Recursive - Traversing tree in order");
        bt.traverseInOrderRecursive(root); 
        System.out.println();
        System.out.println("NON - Recursive - Traversing tree in order");
        bt.inorderIteration(root);
        
         
        //PRE-ORDER TRAVERSAL
        System.out.println();
        System.out.println("Recursive - Traversing tree Pre-Order");
        bt.traversePreOrderRecursive(root);
        System.out.println();
        System.out.println("NON - Recursive - Traversing tree PRE-order");
        bt.preorderIteration(root);
        
       //POST-ORDER TRAVERSAL
        System.out.println();
        System.out.println("Recursive - Traversing tree Post-Order");
        bt.traversePostOrderRecursive(root);
        System.out.println();
        System.out.println("NON - Recursive - Traversing tree Post-Order");
        bt.postOrderIteration(root);
        
        //Avg Levels on a Binary Tree.
        System.out.println();
        System.out.println("Avg of Levels on a Binary Tree");
        bt.averageOfLevels(root);
        
        
        //IN-ORDER predecessor
        
        
        //IN-ORDER successor 
        
        //BST 
        
        //** Exercise - Get the Sum of all left leaves in a Binary tree
       //** Exercise - Find Deepest Node in a Binary Tree
        //** Exercise -  Get the tree each level print of a Binary tree, level 0, level 1...
        
        
        
        //Get Size of Tree
        System.out.println();
        System.out.println("Tree Size "+bt.getSize());
        
        //Sum of All Leaf Nodes
        sum=0;
        leafSum(root);
        System.out.println("The sum of all Leaf Nodes "+ sum );
        
        
        //Search Tree
        int data = 8;
        boolean isFound = search(root, data);
        System.out.println();
        System.out.println("The  node  present is "+isFound);
        
        //Original Tree might change 
        if(isFound) {
        	System.out.println("This is the node to be deleted");
        	System.out.println("Before deletion in-order traversal ");
        	bt.traverseInOrderRecursive(root);
        	System.out.println();
        	
        	//DELETE A NODE WHICH IS FOUND BY SEARCH TREE.
        	TreeNode rootNodeRes = delete(root, data);
        	System.out.println("After deletion in-order traversal ");
        	bt.traverseInOrderRecursive(rootNodeRes);
        	System.out.println();
        	      	
        } else {
        	System.out.println("the Node not found on the tree is the node to be deleted");
        }
        
        System.out.println("Create a new Binary Tree");
        TreeNode btree= createBinaryTree();
        System.out.println("IN-ORDER Traversal");
        bt.traverseInOrderRecursive(btree);
        System.out.println();
        
        inOrderPredSucc(btree, 10);
        System.out.println("Inorder Successor of 10 is : " + successor
                + " and predecessor is : " + predecessor);
       
        inOrderPredSucc(btree, 30);
        System.out.println("Inorder Successor of 30 is : " + successor
                + " and predecessor is : " + predecessor);
        
	}
	
	private static void inOrderPredSucc(TreeNode btree, int val) {
		if (btree != null) {
			
			// match found
			if (btree.key == val) {
				//predecesor
				if (btree.left != null) {
					TreeNode n = btree.left;
					while (n.right != null) {
						n = n.right;
					}
					predecessor = n.key;
				}
				//succesor
				if (btree.right != null) {
					TreeNode n = btree.right;
					while (n.left != null) {
						n = n.left;
					}
					successor = n.key;
				}
			} else if (btree.key >val) {
				// we make the root as successor because we might have a
                // situation when value matches with the root, it wont have
                // right subtree to find the successor, in that case we need
                // parent to be the successor
				successor = btree.key;
				inOrderPredSucc(btree.left, val);
			} else if (btree.key<val) {
				// we make the root as predecessor because we might have a
                // situation when value matches with the root, it wont have
                // left subtree to find the predecessor, in that case we need
                // parent to be the predecessor.
				predecessor = btree.key;
				inOrderPredSucc(btree.right, val);
			}

		}

	}

	private static TreeNode minElement(TreeNode node) {
		if(node.left==null) {
			return node;
		} else {
			return minElement(node.left);	
		}
		
		
	}
	private static TreeNode delete(TreeNode root, int value) {
		//go to the Node to be deleted.
		if(root==null) {
			return null;
		}
		
		if(root.key > value) {
			root.left = delete(root.left, value);
		} 
		
		else if(root.key<value) {
			root.right = delete(root.right, value);
		} 
		else {
			//Nodes has both Left and Right children
			if(root.left!=null && root.right!=null) {
				TreeNode tempRoot = root;
				TreeNode minfindRoot = minElement(tempRoot.right);
				
				//Replacing current node with min node from Right subtree.
				root.key = minfindRoot.key;
				
				// Deleting minimum node from right now
				root.right = delete(root.right, minfindRoot.key);
				
			} //only Left child
			  else if (root.left!=null) {
				root = root.left;
			
			//only right chiled	
			}else if (root.right!=null) {
				root = root.right;
		} else {
			// if nodeToBeDeleted do not have child (Leaf node)
			root = null;
		}
	}
		return root;
	}

	private static boolean search(TreeNode current, int value) {
		if(current==null)
			return false;
		if(value==current.key)
			return true;
		
		return value<current.key?search(current.left, value):search(current.right, value);
		
	}

	public int getSize() {
		return getSize(root);
	}
	public int getSize(TreeNode root) {
		return root==null?0:getSize(root.left)+1+ getSize(root.right);
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
	
	//In - Order Traversal :: Left-subtree -> Root Node-> Right-subtree
	public void traverseInOrderRecursive(TreeNode node) {
	        if (node != null) {
	        	traverseInOrderRecursive(node.left);
	            System.out.print(" " + node.key);
	            traverseInOrderRecursive(node.right);
	        }
	     }
	
	//PRE - Order Traversal :: Root Node->Left-subtree->Right-subtree
	public void traversePreOrderRecursive(TreeNode node) {
		if(node!=null) {
			 System.out.print(" " + node.key);
			 traversePreOrderRecursive(node.left);
			 traversePreOrderRecursive(node.right);
		}
		
	}
	
	  //POST - Order Traversal :: Left-subtree->Right-subtree-Root Node
		public void traversePostOrderRecursive(TreeNode node) {
			if (node != null) {
				traversePostOrderRecursive(node.left);
				traversePostOrderRecursive(node.right);
		        System.out.print(" " + node.key);
		    }	
		}
			

	//uses Stack to perform this Binary Tree In-Order opertion
	public void inorderIteration(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (true) {
			// Go to the left extreme insert all the elements to stack
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			// check if Stack is empty, if yes, exit from everywhere
			if (s.isEmpty()) {
				return;
			}
			// pop the element from the stack , print it and add the nodes at
			// the right to the Stack
			root =s.pop();
			System.out.print(root.key + " ");
			root = root.right;
		}
	}
	
	//PRE - Order Traversal :: Root Node->Left-subtree->Right-subtree
	public void preorderIteration(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode> ();
		
		while(true) {
			while(root!=null) {
				System.out.print(root.key + " ");
				s.push(root);
				root = root.left;
			}
			
			if(s.isEmpty()) {
				break;
			}
			
			root = s.pop();
			root = root.right;
		}
		
	}
	
	public void postOrderIteration(TreeNode root) {
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();

		// push the root node into first stack.
		s1.push(root);
		while (s1.isEmpty() == false) { // take out the root and insert into second stack.
			TreeNode temp = s1.pop();
			s2.push(temp);
			// now we have the root, push the left and right child of root into
			// the first stack.
			if (temp.left != null) {
				s1.push(temp.left);
			}
			if (temp.right != null) {
				s1.push(temp.right);
			}
		}
		// once the all node are traversed, take out the nodes from second stack and
		// print it.
		System.out.println("PostOrder Traversal: ");
		while (s2.isEmpty() == false) {
			System.out.print(s2.pop().key + " ");
		}

	}
	
	/* Function to print the average value of the  
	nodes on each level */
	public void averageOfLevels(TreeNode root)  
	{ 
		Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
		float sum=0;
		int  nodeCount = 0;
		
		queue.add(root);
		 
		while(!queue.isEmpty()) {
			Queue<TreeNode> temp = new java.util.LinkedList<TreeNode>();
			sum=0;
			nodeCount=0;
			while(!queue.isEmpty()) {
				TreeNode n = queue.peek();
				queue.remove();
				sum+=n.key;
				if(n.left!=null) {
					temp.add(n.left);
					
				}
				if(n.right!=null) {
					temp.add(n.right);
					
				}
				nodeCount++;
			}
			
			queue = temp;
			System.out.print("   "+sum/nodeCount + " ");
			
		}
	}  
	
	static void leafSum(TreeNode node){ 
        if (node == null) 
            return; 
       
        // add root data to sum if  
        // root is a leaf node 
        if (node.left == null && node.right == null) {
            sum += node.key; 
        }
       
        // propagate recursively in left 
        // and right subtree 
        leafSum(node.left); 
        leafSum(node.right); 
    } 
	
	static TreeNode createBinaryTree() {
		TreeNode btree = new TreeNode(20);
		btree.left = new TreeNode(10);
        btree.right = new TreeNode(30);
        btree.left.left = new TreeNode(5);
        btree.left.left.right = new TreeNode(7);
        btree.left.right = new TreeNode(15);
        btree.right.left = new TreeNode(25);
        btree.right.right = new TreeNode(35);
        btree.left.right.left = new TreeNode(13);
        btree.left.right.right = new TreeNode(18);
		
		return btree;
		
	}
}
