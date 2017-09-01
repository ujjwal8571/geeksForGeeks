package AllBinaryTreeOps.Traversal;

import java.util.Stack;

import AllBinaryTreeOps.BaseTree;

public class InorderIterative extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(50);
		root.left = new Node(25);
		root.right = new Node(75);
		root.left.left = new Node(12);
		root.left.right = new Node(37);
		root.right.left = new Node(62);
		root.right.right = new Node(87);

		inorderIterative(root);

	}

	public static void inorderIterative(Node root) {

		Stack<Node> stack = new Stack<>();

		Node temp = root;
		while (temp != null) {
			stack.push(temp);
			temp = temp.left;
		}

		while (!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.println(node.data);

			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.add(node);
					node = node.left;
				}
			}

		}

	}

}
