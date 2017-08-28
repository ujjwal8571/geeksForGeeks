package DataStructures.LinkedListOps;

public class LinkedListClient {

	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		// list.addLast(70);
		// list.addLast(80);
		// list.addLast(90);
		//
		// list.display();
		// System.out.println(list.size());
		//
		// list.kthReverse(3);
		//
		// list.display();

		list.display();
		list.rotate(12);
		list.display();

		// list.addLast(7);
		// list.addLast(5);
		// list.addLast(9);
		// list.addLast(4);
		// list.addLast(6);
		//
		// LinkedList other = new LinkedList();
		// other.addLast(4);
		// other.addLast(8);
		//
		// list.display();
		// other.display();
		//
		// LinkedList ans = list.findSumOfLinkedLists(other);
		//
		// ans.display();

	}

}
