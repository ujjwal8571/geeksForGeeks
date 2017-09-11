package AllBinarySearchTreeOps;

public class AugumentedTreeWithRankInOrder {

	public static void main(String[] args) {
		Node root = new Node(50, 1);
		insert(root, 25, 1);
		insert(root, 75, 1);
		insert(root, 12, 1);
		insert(root, 37, 1);
		insert(root, 62, 1);
		insert(root, 87, 1);
		insert(root, 30, 1);
		insert(root, 40, 1);

		traverse(root);

	}

	public static class Node {
		int data;
		int rank;
		Node left;
		Node right;

		public Node(int data, int rank) {
			this.data = data;
			this.rank = rank;
		}
	}

	public static void updateRank(Node node) {

		if (node == null) {
			return;
		}

		node.rank++;
		updateRank(node.left);
		updateRank(node.right);
	}

	public static void insert(Node node, int data, int myRank) {

		if (data < node.data) {
			node.rank++;

			if (node.left == null) {

				node.left = new Node(data, myRank);
				return;
			}
			insert(node.left, data, myRank);
			updateRank(node.right);
		} else {

			if (node.right == null) {
				node.right = new Node(data, node.rank + 1);
				return;
			}
			insert(node.right, data, node.rank + 1);
		}

	}

	public static void traverse(Node node) {
		if (node == null) {
			return;
		}

		traverse(node.left);
		System.out.println(node.data + " -- " + node.rank);
		traverse(node.right);
	}

}
