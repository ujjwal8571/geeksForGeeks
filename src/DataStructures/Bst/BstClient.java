package DataStructures.Bst;

public class BstClient {

	public static void main(String[] args) {

		int[] sa = { 12, 25, 37, 50, 62, 75, 87 };
		int[] sa2 = { 13, 34, 45, 65, 77, 79, 85, 90 };
		Bst tree = new Bst(sa);

		tree.display();
		System.out.println();
		Bst other = new Bst(sa2);
		other.display();

		// tree.printInorderPredSucc(65);

		// System.out.println(tree.lowestCommonAncestor(12, 62));
		// System.out.println(tree.inOrderSuccessor(37));
		// System.out.println(tree.kthsmallest(2));

		// tree.mergeTwoBsts(other);
		//
		// tree.display();
		// tree.spoilBst();
		// tree.display();
		// tree.correctBst();
		// tree.display();
//		System.out.println(tree.findCeilValue(72));
		
		tree.mergeTwoBst(other);
		tree.display();

	}

}
