package AllBinaryTreeOps.Traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import AllBinaryTreeOps.BaseTree;

public class DiagonalTraversal extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(50);
		root.left = new Node(25);
		root.right = new Node(75);
		root.left.left = new Node(12);
		root.left.right = new Node(37);
		root.right.left = new Node(62);
		root.right.right = new Node(87);

		diagonalTraversal(root);

	}

	public static void diagonalTraversal(Node root) {

		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

		fillHashMap(root, 0, hm);

		ArrayList<Integer> keys = new ArrayList<>(hm.keySet());
		Collections.sort(keys);

		for (int i = keys.size() - 1; i >= 0; i--) {
			int key = keys.get(i);
			ArrayList<Integer> list = hm.get(key);
			System.out.println(list);
		}

	}

	public static void fillHashMap(Node node, int diagLevel, HashMap<Integer, ArrayList<Integer>> hm) {

		if (node == null) {
			return;
		}

		if (hm.containsKey(diagLevel)) {
			ArrayList<Integer> list = hm.get(diagLevel);
			list.add(node.data);
			hm.put(diagLevel, list);
		} else {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(node.data);
			hm.put(diagLevel, list);

		}

		fillHashMap(node.left, diagLevel - 1, hm);
		fillHashMap(node.right, diagLevel, hm);
	}

}
