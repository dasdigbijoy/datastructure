package DataStructures;

public class TreeNode {
public int key;
public TreeNode left, right;

public TreeNode(int item) {
	this.key = item;
	left=right=null;
}

public TreeNode getLeft() {
    return left;
}

public void setLeft(TreeNode left) {
    this.left = left;
}

public TreeNode getRight() {
    return right;
}

public void setRight(TreeNode right) {
    this.right = right;
}

public int getData() {
    return key;
}

public void setData(int data) {
    this.key = data;
}

@Override
public String toString() {
	return "TreeNode [key=" + key + ", left=" + left + ", right=" + right + "]";
}
}
