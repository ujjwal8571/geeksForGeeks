package AllLinkedListOps;

public class DeleteNodeFromLl extends BaseLinkedList {

	public static void main(String[] args) {
		Node head = new Node(10);
		Node n = head.next = new Node(20);
		head.next.next = new Node(30);
		// head.next.next.next = new Node(40);
		// Node n = head.next.next.next.next = new Node(50);
		// head.next.next.next.next.next = new Node(60);

		display(head);
		deleteNode(head, n);
		display(head);

	}

	public static void deleteNode(Node head, Node n2d) {

		if (head == n2d) {

			while (head != null && head.next != null && head.next.next != null) {

				head.data = head.next.data;
				head = head.next;
			}

			head.data = head.next.data;
			head.next = null;
		}

		while (head != null && head.next != n2d) {

			head = head.next;

		}

		if (head.next != null) {
			head.next = head.next.next;
		}
	}

}
