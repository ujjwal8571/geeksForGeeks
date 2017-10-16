package AllLinkedListOps;

public class TripletFromThreeList extends BaseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean printTripletSumFromThreeList(Node one, Node two, Node three, int target) {

		MergeSortForLl.mergeSort(one);
		MergeSortForLl.mergeSortDec(two);

		while (three != null) {

			while (one != null && two != null) {

				int sum = one.data + two.data + three.data;
				if (sum == target) {
					System.out.println(one.data + ", " + two.data + ", " + three.data);
					return true;
				} else if (sum < target) {

					one = one.next;
				} else {
					two = two.next;

				}

			}

			three = three.next;
		}

		System.out.println("Not found bro");
		return false;
	}

}
