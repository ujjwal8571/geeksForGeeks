package AllBinaryTreeOps.Miscellaneous;

import java.util.LinkedList;

import AllBinaryTreeOps.BaseTree;
import AllBinaryTreeOps.BaseTree.Node;

public class FindHeightIterative extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(26);
		root.left = new Node(10);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		root.right.right = new Node(7);
		
		System.out.println(findHeightIter(root));

	}

	public static int findHeightIter(Node root) {

		int rv = -1;
		LinkedList<Node> queueParent = new LinkedList<>();
		LinkedList<Node> queueChild = new LinkedList<>();

		queueParent.addLast(root);

		while (!queueParent.isEmpty()) {
			Node removed = queueParent.removeFirst();

			if (removed.left != null) {
				queueChild.addLast(removed.left);
			}

			if (removed.right != null) {
				queueChild.addLast(removed.right);
			}

			if (queueParent.isEmpty()) {
				queueParent = queueChild;
				queueChild = new LinkedList<>();
				rv++;
			}

		}

		return rv;
	}

}
