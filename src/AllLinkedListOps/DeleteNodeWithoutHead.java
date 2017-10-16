package AllLinkedListOps;

public class DeleteNodeWithoutHead extends BaseLinkedList {

	public static void main(String[] args) {

		Node root = new Node(10);
		insert(root, 20);
		insert(root, 30);
		insert(root, 40);
		Node n1 = insert(root, 50);
		Node n2 = insert(root, 60);

		display(root);

		removeNodeWithoutHead(n2);
		display(root);
	}

	public static void removeNodeWithoutHead(Node node) {

		if (node.next == null) {
			node = null;
			return;
		}

		node.data = node.next.data;
		node.next = node.next.next;

	}
}
