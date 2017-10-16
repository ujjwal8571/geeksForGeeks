package AllLinkedListOps;

public class ReverseAlternateKNodes extends BaseLinkedList {

	public static void main(String[] args) {

		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);

		display(head);
		head = reverseAlternateKNodes(head, 2);
		display(head);
	}

	public static Node reverseAlternateKNodes(Node head, int k) {

		Node temp = head;
		int size = 0;

		while (temp != null) {
			temp = temp.next;
			size++;
		}

		if (size % k != 0) {
			return head;
		}

		return reverseAlternateKNodesHelper(head, k);
	}

	public static Node reverseAlternateKNodesHelper(Node node, int k) {

		if (node == null) {
			return null;
		}

		// Node temp = node;
		// int i = 0;
		// while (i < k) {
		// temp = temp.next;
		// i++;
		// }
		//
		// Node recResult = reverseAlternateKNodes(temp, k);

		Node prev = null, curr = node, next = null;
		int i = 0;
		while (i < k) {

			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;

			i++;
		}

		node.next = reverseAlternateKNodesHelper(next, k);

		return prev;

	}

}
