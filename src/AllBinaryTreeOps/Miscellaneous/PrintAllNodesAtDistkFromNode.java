package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class PrintAllNodesAtDistkFromNode extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		printAllNodesDownAtDistK(root, 20, 2);

	}

	// nd is node data
	// dfn is distance from node
	// this sub function works when we are sitting at the node from which dist is
	// calculated
	public static void printAllNodesDownAtDistK(Node node, int nd, int dfn) {

		if (node == null) {
			return;
		}

		if (dfn == 0) {
			System.out.println(node.data);
			return;
		}

		printAllNodesDownAtDistK(node.left, nd, dfn - 1);
		printAllNodesDownAtDistK(node.right, nd, dfn - 1);

	}
	
//	public static void printAllNodesAtDistk(Node node,int)

}
