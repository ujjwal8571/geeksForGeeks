package AllBinaryTreeOps.Miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import AllBinaryTreeOps.BaseTree.Node;

public class TopViewOfTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(5);
		root.left.right.right.right = new Node(6);

		printVerticalTopView(root);

	}

	public static void printVerticalTopView(Node root) {

		HashMap<Integer, Integer> hm = new HashMap<>();

		fillhm(root, hm);
		ArrayList<Integer> keys = new ArrayList<>(hm.keySet());

		for (int key : keys) {
			System.out.println(hm.get(key));
		}

	}

	public static class pair {
		Node node;
		int vd;
	}

	// vd means vertical distance
	public static void fillhm(Node root, HashMap<Integer, Integer> hm) {

		LinkedList<pair> queue = new LinkedList<>();

		pair p = new pair();
		p.node = root;
		p.vd = 0;

		queue.addLast(p);

		while (!queue.isEmpty()) {

			pair removed = queue.removeFirst();
			Node rn = removed.node; // removed node

			if (hm.containsKey(removed.vd) == false) {
				hm.put(removed.vd, removed.node.data);
			}

			if (rn.left != null) {

				pair temp = new pair();
				temp.node = rn.left;
				temp.vd = removed.vd - 1;
				queue.addLast(temp);
			}

			if (rn.right != null) {

				pair temp = new pair();
				temp.node = rn.right;
				temp.vd = removed.vd + 1;
				queue.addLast(temp);
			}

		}
	}

}
