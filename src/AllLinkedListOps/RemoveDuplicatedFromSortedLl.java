package AllLinkedListOps;


public class RemoveDuplicatedFromSortedLl extends BaseLinkedList {

	public static void main(String[] args) {

		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(30);
		head.next.next.next = new Node(50);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);
		head.next.next.next.next.next.next = new Node(60);

		removeDuplicates(head);
		display(head);

	}

	public static void removeDuplicates(Node head) {

		Node temp = head.next;
		Node unique = head;

		while (temp != null && unique != null) {

			if (temp.data == unique.data) {

				temp = temp.next;
			} else {

				unique.next = temp;
				unique = temp;
			}

		}

		unique.next = temp;
	}

}
