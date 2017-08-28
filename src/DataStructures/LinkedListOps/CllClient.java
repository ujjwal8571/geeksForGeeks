package DataStructures.LinkedListOps;

public class CllClient {

	public static void main(String[] args) {

		CircularLinkedList list = new CircularLinkedList();
		
		list.addLast(10);
		list.display();
		list.addLast(20);
		list.display();
		list.addLast(30);
		list.display();
		list.addLast(40);
		list.display();
		list.addLast(50);
		list.display();
		list.addLast(60);
		
		list.display();
		
//		
//		System.out.println();
//		CircularLinkedList other = list.divideListInTwoHalves();
//		
//		list.display();
//		other.display();
	
		list.sortedAdd(65);
		list.display();
	}

}
