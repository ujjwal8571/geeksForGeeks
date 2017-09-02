package AllBinaryTreeOps.Miscellaneous;


public class PopulateInorderSuccessor {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		Node temp = root;
		while (temp.left != null) {
			temp = temp.left;

		}

		populateInOrderSucc(root, new NextNode());

		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}

	}

	public static class Node {
		int data;
		Node left;
		Node right;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public static class NextNode {
		Node nxtNode;
	}

	// root is true
	public static void populateInOrderSucc(Node node, NextNode nn) {

		if (node == null) {
			return;
		}

		populateInOrderSucc(node.right, nn);

		node.next = nn.nxtNode;
		nn.nxtNode = node;
		populateInOrderSucc(node.left, nn);

	}

}
