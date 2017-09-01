package AllBinaryTreeOps.Traversal;

import java.util.Stack;

import AllBinaryTreeOps.BaseTree;

public class PostOrderIter extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(50);
		root.left = new Node(25);
		root.right = new Node(75);
		root.left.left = new Node(12);
		root.left.right = new Node(37);
		root.right.left = new Node(62);
		root.right.right = new Node(87);

		postOrderIter(root);

	}

	public static void postOrderIter(Node root) {

		Stack<Node> tempStack = new Stack<>();
		Stack<Node> stack = new Stack<>();

		tempStack.push(root);

		while (!tempStack.isEmpty()) {
			Node node = tempStack.pop();
			stack.push(node);

			if (node.left != null) {
				tempStack.push(node.left);
			}

			if (node.right != null) {
				tempStack.push(node.right);
			}

		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop().data);
		}

	}

}
