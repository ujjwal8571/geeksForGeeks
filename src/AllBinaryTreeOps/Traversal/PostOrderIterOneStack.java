package AllBinaryTreeOps.Traversal;

import java.util.Stack;

import AllBinaryTreeOps.BaseTree;

public class PostOrderIterOneStack extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(50);
		root.left = new Node(25);
		root.right = new Node(75);
		root.left.left = new Node(12);
		root.left.right = new Node(37);
		// root.left.right.left = new Node(30);
		root.left.right.right = new Node(40);
		root.right.left = new Node(62);
		root.right.right = new Node(87);

		postOrderIterOneStack(root);

	}

	public static void postOrderIterOneStack(Node root) {

		Stack<Node> stack = new Stack<>();
		Node curr = root;

		while (true) {

			if (curr == null) {

				Node node = stack.pop();
				// base case
				if (stack.isEmpty()) {
					System.out.println(node.data);
					break;
				}

				// leaf node
				if (node.right == null) {
					System.out.println(node.data);
					continue;
				}

				// work left for node.right
				if (node.right != stack.peek()) {
					System.out.println(node.data);
				} else {
					curr = stack.pop();
					stack.push(node);
				}

			} else {

				// first push node.right then the node
				if (curr.right != null) {
					stack.push(curr.right);
				}

				stack.push(curr);
				curr = curr.left;

			}

		}

	}

}
