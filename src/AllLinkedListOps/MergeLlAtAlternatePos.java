package AllLinkedListOps;

public class MergeLlAtAlternatePos extends BaseLinkedList {

	public static void main(String[] args) {

		Node head = new Node(1);
		insert(head, 2);
//		insert(head, 3);
//		insert(head, 4);

		Node other = new Node(5);
		insert(other, 6);
		 insert(other, 7);
		 insert(other, 8);
		 insert(other, 9);
		 insert(other, 10);

		mergeLl2(head, other);

		display(head);

	}

	public static void mergeLl(Node head, Node otherHead) {

		Node mycurr = head, mynext = head.next;
		Node othercurr = otherHead, otherNext = null;

		while (mycurr != null) {

			otherNext = othercurr.next;

			mycurr.next = othercurr;
			othercurr.next = mynext;
			mycurr = mynext;

			if (mycurr == null) {

				break;
			}

			mynext = mycurr.next;
			othercurr = otherNext;

			if (othercurr == null) {
				break;
			}
		}

	}

	public static void mergeLl2(Node head, Node otherHead) {

		Node mycurr = head, mynext = null;
		Node othercurr = otherHead, otherNext = null;

		while (mycurr != null && othercurr != null) {

			otherNext = othercurr.next;
			mynext = mycurr.next;

			mycurr.next = othercurr;
			othercurr.next = mynext;
			mycurr = mynext;
			othercurr = otherNext;

		}

	}

}
