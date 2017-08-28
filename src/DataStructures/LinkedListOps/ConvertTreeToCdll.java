package DataStructures.LinkedListOps;

public class ConvertTreeToCdll {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(12);
		root.right = new Node(15);
		root.left.left = new Node(25);
		root.left.right = new Node(30);
		root.right.left = new Node(36);

		Node CdllLastNode = convertTreeToCdll(root);
		display(CdllLastNode);

	}

	private static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static Node convertTreeToCdll(Node node) {

		if (node == null) {
			return null;
		}

		Node leftDcll = convertTreeToCdll(node.left);

		Node rightDcll = convertTreeToCdll(node.right);

		node.left = node;
		node.right = node;

		Node partialMerge = mergeDcll(leftDcll, node);
		return mergeDcll(partialMerge, rightDcll);

	}

	public static void display(Node node) {

		Node head = node.right;
		System.out.print(head.data + ", ");
		Node temp = head.right;

		while (temp != head) {
			System.out.print(temp.data + ", ");
			temp = temp.right;
		}

		System.out.println();
	}

	public static Node mergeDcll(Node leftList, Node rightList) {

		if (leftList == null) {
			return rightList;
		}

		if (rightList == null) {
			return leftList;
		}

		Node leftHead = leftList.right;
		Node rightHead = rightList.right;
		leftList.right = rightHead;
		rightList.right = leftHead;

		return rightList;

	}

}
