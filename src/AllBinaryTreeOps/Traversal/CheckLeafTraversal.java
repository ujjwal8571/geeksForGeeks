package AllBinaryTreeOps.Traversal;

import java.util.Stack;

import AllBinaryTreeOps.BaseTree;

public class CheckLeafTraversal extends BaseTree {

	public static void main(String[] args) {

		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.right.left = new Node(6);
		root1.right.right = new Node(7);

		Node root2 = new Node(0);
		root2.left = new Node(1);
		root2.right = new Node(5);
		root2.left.right = new Node(4);
		root2.right.left = new Node(6);
		root2.right.right = new Node(8);

		if (checkLeafTraversal(root1, root2))
			System.out.println("Same");
		else
			System.out.println("Not Same");

	}

	public static boolean checkLeafTraversal(Node root1, Node root2) {

		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();

		Node temp = root1;
		while (temp != null) {
			stack1.push(temp);
			temp = temp.left;
		}

		temp = root2;
		while (temp != null) {
			stack2.push(temp);
			temp = temp.left;
		}

		while (!stack2.isEmpty() && !stack2.isEmpty()) {

			Node leaf1 = getLeaf(stack1);
			Node leaf2 = getLeaf(stack2);

			if ((leaf1 == null && leaf2 != null) || (leaf1 != null && leaf2 == null)) {
				return false;
			}

			if (leaf1.data != leaf2.data) {
				return false;
			}
		}

		while (!stack2.isEmpty() && !stack2.isEmpty()) {
			return false;
		}

		return true;
	}

	public static Node getLeaf(Stack<Node> stack) {
		Node rv = null;

		while (!stack.isEmpty()) {
			Node node = stack.pop();

			if (node.left == null && node.right == null) {
				rv = node;
				break;
			}

			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.add(node);
					node = node.left;
				}
			}

		}

		return rv;

	}

}
