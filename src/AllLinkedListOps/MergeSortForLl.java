package AllLinkedListOps;

public class MergeSortForLl extends BaseLinkedList {

	public static void main(String[] args) {

		Node head = new Node(10);
		insert(head, 30);
		insert(head, 21);
		insert(head, 12);
		insert(head, 48);
		insert(head, 3);
		insert(head, 25);

		head = mergeSort(head);
		display(head);
	}

	public static Node getMidNode(Node head) {

		Node slow = head, fast = head.next;

		while (fast != null) {

			fast = fast.next;

			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}

		}
		return slow;
	}

	public static Node mergeSort(Node node) {

		if (node == null) {
			return null;
		}

		if (node.next == null) {
			return node;
		}

		Node mid = getMidNode(node);
		Node midNext = mid.next;

		mid.next = null;
		Node firstList = mergeSort(node);
		Node secondList = mergeSort(midNext);

		return mergeLists(firstList, secondList);

	}

	public static Node mergeLists(Node first, Node second) {

		if (first == null) {
			return second;
		}

		if (second == null) {
			return first;
		}

		Node n = null;
		if (first.data < second.data) {

			n = first;
			n.next = mergeLists(first.next, second);

		} else {

			n = second;
			n.next = mergeLists(first, second.next);

		}

		return n;

	}

	public static Node mergeSortDec(Node node) {

		if (node == null) {
			return null;
		}

		if (node.next == null) {
			return node;
		}

		Node mid = getMidNode(node);
		Node midNext = mid.next;

		mid.next = null;
		Node firstList = mergeSortDec(node);
		Node secondList = mergeSortDec(midNext);

		return mergeListsDec(firstList, secondList);

	}

	public static Node mergeListsDec(Node first, Node second) {

		if (first == null) {
			return second;
		}

		if (second == null) {
			return first;
		}

		Node n = null;
		if (first.data > second.data) {

			n = first;
			n.next = mergeListsDec(first.next, second);

		} else {

			n = second;
			n.next = mergeListsDec(first, second.next);

		}

		return n;

	}
}
