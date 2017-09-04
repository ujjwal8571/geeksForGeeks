package AllBinaryTreeOps.Miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;

import AllBinaryTreeOps.BaseTree;

public class BottomViewOfTree extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		
		printVerticalView(root);

	}

	public static void printVerticalView(Node root) {

		HashMap<Integer, Integer> hm = new HashMap<>();

		fillhm(root, 0, hm);
		ArrayList<Integer> keys = new ArrayList<>(hm.keySet());

		for (int key : keys) {
			System.out.println(hm.get(key));
		}

	}

	// vd means vertical distance
	public static void fillhm(Node node, int vd, HashMap<Integer, Integer> hm) {

		if (node == null) {
			return;
		}

		hm.put(vd, node.data);
		fillhm(node.left, vd - 1, hm);
		fillhm(node.right, vd + 1, hm);
	}

}
