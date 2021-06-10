package DataStructures;

import java.util.Queue;

import TestPractice.BinaryTreeTest;

public class BreadthFirstSearch {
	static TreeNode root;

	public static void main(String ar[]) {
		//BinaryTreeTest bt = new BinaryTreeTest();

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(10);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(25);
		root.right.left = new TreeNode(30);
		root.right.right = new TreeNode(35);
		root.right.left.left = new TreeNode(20);

		System.out.println("The Breadth First search is ");
		callBFS(root);
	}

	// Breadth-First Search
	private static void callBFS(TreeNode root) {
		Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
		queue.add(root);
		int level = 0;
		while (!queue.isEmpty()) {
			level = queue.size();
			System.out.println("queue size " + level);
			TreeNode node = queue.poll();
			System.out.print("  " + node.key + "Level[" + "]  ");
			if (node.left != null) {
				queue.add(node.left);

			}
			if (node.right != null) {
				queue.add(node.right);
			}

		} // first while

		++level;

	}

}
