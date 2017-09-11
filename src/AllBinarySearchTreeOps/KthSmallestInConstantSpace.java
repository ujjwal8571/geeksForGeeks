package AllBinarySearchTreeOps;

import AllBinaryTreeOps.BaseTree;

public class KthSmallestInConstantSpace extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(50);
		root.left = new Node(25);
		root.right  = new Node(75);
		root.left.left  = new Node(12);
		root.left.right = new Node(37);
		root.right.left = new Node(62);
		root.right.right = new Node(87);
		
		System.out.println(findkthSmallest(root, 5));
		
	}

	// using morris traversal
	public static int findkthSmallest(Node root, int k) {
		int rv = 0;

		Node node = root;
		int ctr = 0;

		while (node != null) {

			if (node.left == null) {

				ctr++; // inorder node visited

				if (ctr == k) {
					rv = node.data;
					break;
				}

				node = node.right;

			} else {

				Node lrm = node.left; // lrm - left right most

				while (lrm.right != null && lrm.right != node) {
					lrm = lrm.right;
				}

				if (lrm.right == null) {
					lrm.right = node;
					node = node.left;
				} else {
					ctr++; // inorder node visited

					if (ctr == k) {
						rv = node.data;
						break;
					}

					lrm.right = null;
					node = node.right;

				}

			}
		}

		return rv;
	}

}
