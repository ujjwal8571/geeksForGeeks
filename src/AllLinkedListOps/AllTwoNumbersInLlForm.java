package AllLinkedListOps;

public class AllTwoNumbersInLlForm extends BaseLinkedList {

	public static void main(String[] args) {

		Node head1 = new Node(5);
		insert(head1, 6);
		insert(head1, 3);

		Node head2 = new Node(8);
		insert(head2, 4);
		insert(head2, 2);

		Node ans = addNumbers(head1, head2);
		display(ans);

	}

	public static class result {
		Node node;
		int carry;
	}

	// only for same length
	public static Node addNumbers(Node one, Node two) {

		result res = new result();

		addNumbersHelper(one, two, res);

		if (res.carry != 0) {
			Node n = new Node(res.carry);
			n.next = res.node;
			res.node = n;
		}
		return res.node;

	}

	public static void addNumbersHelper(Node one, Node two, result res) {

		if (one == null && two == null) {
			return;
		}


		addNumbersHelper(one.next, two.next, res);

		int sum = 0;
		if (one != null) {
			sum += one.data;
		}

		if (two != null) {
			sum += two.data;
		}
		sum += res.carry;
		Node n = new Node(sum % 10);
		n.next = res.node;
		res.node = n;
		res.carry = sum / 10;

	}
}
