package AllLinkedListOps;

public class DeleteNodeWithGreaterOnright extends BaseLinkedList {

	public static void main(String[] args) {

		// Node head = new Node(12);
		// insert(head, 15);
		// insert(head, 10);
		// insert(head, 11);
		// insert(head, 5);
		// insert(head, 6);
		// insert(head, 2);
		// insert(head, 3);

		int[] arr = { 60, 50, 40, 30, 20, 10 };
		Node head = new Node(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			insert(head, arr[i]);
		}
		display(head);

		head = deleteNodeOnRight(head);

		display(head);

	}

	public static Node deleteNodeOnRight(Node head) {

		while (head.next != null && head.data < head.next.data) {
			head = head.next;
		}

		Node prev = head;
		Node curr = head.next;

		while (curr != null && curr.next != null) {

			Node next = curr.next;
			if (curr.data < next.data) {
				prev.next = next;
			}

			prev = curr;
			curr = next;
		}

		return head;
	}

}
