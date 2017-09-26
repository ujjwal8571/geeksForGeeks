package AllStackOps;

import java.util.Stack;

import AllBinaryTreeOps.BaseTree;

public class PrintAncestorWithoutRecursion extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(50);
		root.left = new Node(25);
		root.right = new Node(75);
		root.left.left = new Node(12);
		root.left.right = new Node(37);
		// root.left.right.left = new Node(30);
		// root.left.right.right = new Node(40);
		root.right.left = new Node(62);
		root.right.right = new Node(87);

		printAncestor(root);

	}

	public static void printAncestor(Node root) {

		Stack<Node> st = new Stack<>();

		Node currNode = root;

		while (true) {

			if (currNode == null) {

				if (st.isEmpty()) {
					return;
				}

				Node node = st.pop();
				if (node.right == null) {

					System.out.println(node.data);

				} else {

					if (node.right != st.peek()) {

						System.out.println(node.data);

					} else {
						currNode = st.pop();
						st.push(node);
					}

				}

			} else {

				if (currNode.right != null) {
					st.push(currNode.right);
				}

				st.push(currNode);
				currNode = currNode.left;
			}
		}
	}

}
