package AllLinkedListOps;

public class MoveLastToFront extends BaseLinkedList {

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);

		display(head);

		head = moveLastToFirstOfLl(head);
		display(head);
	}

	public static Node moveLastToFirstOfLl(Node head) {

		Node temp = head;

		while (temp.next.next != null) {
			temp = temp.next;
		}

		// temp has second last Node

		Node last = temp.next;
		temp.next = null;

		last.next = head;
		return last;

	}

}
