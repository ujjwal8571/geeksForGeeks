package AllBinaryTreeOps.Traversal;

import java.util.Stack;

import AllBinaryTreeOps.BaseTree;

public class PreorderIterative extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(50);
		root.left = new Node(25);
		root.right = new Node(75);
		root.left.left = new Node(12);
		root.left.right = new Node(37);
		root.right.left = new Node(62);
		root.right.right = new Node(87);
		
		preorderIterative(root);

	}

	public static void preorderIterative(Node root) {

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.println(node.data);

			
			if (node.right != null) {
				stack.push(node.right);

			}

			if (node.left != null) {
				stack.push(node.left);

			}

		}
	}

}
