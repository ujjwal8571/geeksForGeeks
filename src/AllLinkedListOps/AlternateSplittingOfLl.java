package AllLinkedListOps;

public class AlternateSplittingOfLl extends BaseLinkedList {

	public static void main(String[] args) {

		Node head = new Node(1);
		insert(head, 10);
		insert(head, 1);
		insert(head, 110);
		insert(head, 1);
		insert(head, 1110);
		insert(head, 1);

		Node other = splitLlInTwo(head);

		display(head);
		display(other);
	}

	public static Node splitLlInTwo(Node head) {

		Node other = head.next;
		Node rv = other;

		while (head != null && other != null) {
			head.next = other.next;

			// if (other.next != null) {
			other.next = head.next.next;
			// }

			head = head.next;
			other = other.next;
		}

		return rv;
	}

}
