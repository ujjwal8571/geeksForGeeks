package DataStructures.BinaryTreeOps;

public class BinaryTreeClient {

	public static void main(String[] args) {
		// int[] pre = { 50, 25, 75, 87, 12, 62, 37 };
		// int[] post = { 75, 87, 25, 62, 37, 12, 50 };
		 int[] in = { 12, 25, 37, 50, 62, 75, 87 };
		 int[] level = { 50, 25, 75, 12, 37, 62, 87 };
		//
//		int[] pre = { 1, 2, 4, 5, 3, 6, 8, 7, 9 };
//		int[] post = { 4, 5, 2, 8, 6, 9, 7, 3, 1 };
//		BinaryTree tree = new BinaryTree(pre, post);
//		tree.display();
//
//		tree.printTreeVertical();

		 BinaryTree tree = new BinaryTree(level, in);
		 tree.display();
		//
		// // tree.BfsDisplay();
		// // tree.inOrderWithoutRecursion();
		//// tree.morrisTraversal();
		////
		//// System.out.println(tree.maxWidth());
		//// System.out.println(tree.maxWidth2());
		//
		// tree.printAncestors(12);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		// int[] pre1 = { 20, 10, 4, 30, 6, 3, 3 };
		// int[] post1 = { 30, 4, 6, 10, 3, 3, 26 };
		//
		// int[] pre2 = { 10, 4, 30, 6 };
		// int[] post2 = { 30, 4, 6, 10 };
		//
		// BinaryTree tree = new BinaryTree(pre1, post1);

		// BinaryTree other = new BinaryTree(pre2, post2);
		//
		// tree.display();
		//
		// System.out.println();
		// other.display();
		//
		// System.out.println(tree.isBtPresent(other));

		// System.out.println(tree.lowestCommonAncestor(12, 37));
		// tree.display();
		// tree.convertBtToBst();
		// System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
		// tree.display();

	}

}
