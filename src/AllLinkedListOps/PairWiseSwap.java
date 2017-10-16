package AllLinkedListOps;

public class PairWiseSwap extends BaseLinkedList {

	public static void main(String[] args) {

		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);

		display(head);

		head = pairWiseSwap(head);
		display(head);

	}

	public static Node pairWiseSwap(Node head) {

		Node rv = head.next;

		Node temp = head;

		while (temp != null && temp.next != null) {
			
			Node first = temp;
			Node second = temp.next;
			
			Node t = second.next;
			second.next = first;
			first.next = t;
			

			temp = t;
		}

		return rv;
	}

}
