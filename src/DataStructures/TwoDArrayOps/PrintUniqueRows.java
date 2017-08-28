package TwoDArrayOps;

import java.util.HashMap;

public class PrintUniqueRows {
	public static void main(String[] args) {

		int[][] arr = { { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 1, 0, 0 } };

		// printUniqueRows(arr);
		BinaryTreeMethod(arr);
	}

	public static void printUniqueRows(int[][] arr) {
		HashMap<String, Boolean> hm = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			String str = "";

			for (int j = 0; j < arr[0].length; j++) {
				str += arr[i][j];
			}

			if (hm.containsKey(str)) {

			} else {
				System.out.println(str);
				hm.put(str, true);
			}
		}
	}

	public static void BinaryTreeMethod(int[][] arr) {

		Bst tree = new Bst();

		for (int i = 0; i < arr.length; i++) {
			int num = 0;

			for (int j = 0; j < arr[0].length; j++) {
				int temp = (int) (arr[i][j] * Math.pow(2, j));
				num += temp;

			}
			tree.add(num, i);
		}

		tree.printRowsPreorder(arr);

	}

	public static void printRow(int[][] arr, int row) {
		for (int i = 0; i < arr[0].length; i++) {
			System.out.print(arr[row][i] + ", ");
		}
		System.out.println();
	}

	public static class Bst {

		private class Node {
			int data;
			Node left;
			Node right;
			int rowNumber;

			public Node(int data, int rownumber) {
				this.data = data;
				this.rowNumber = rownumber;

			}
		}

		private Node root;
		private int size;

		public Bst() {
			this.root = null;
			this.size = 0;
		}

		public void add(int data, int rowNumber) {
			if (this.size == 0) {
				this.root = new Node(data, rowNumber);
				this.size++;
			} else {
				this.add(this.root, data, rowNumber);
			}
		}

		private void add(Node node, int data, int rn) {

			if (data < node.data) {
				if (node.left != null) {
					add(node.left, data, rn);
				} else {
					Node nNode = new Node(data, rn);
					node.left = nNode;
				}
			} else if (data > node.data) {
				if (node.right != null) {
					add(node.right, data, rn);
				} else {
					Node nNode = new Node(data, rn);
					node.right = nNode;
				}
			} else {
				return;
			}
		}

		public void printRowsPreorder(int[][] arr) {
			printRowsPreorderHelper(root, arr);
		}

		private void printRowsPreorderHelper(Node node, int[][] arr) {
			if (node == null) {
				return;
			}
			printRow(arr, node.rowNumber);
			printRowsPreorderHelper(node.left, arr);
			printRowsPreorderHelper(node.right, arr);

		}

		public void display() {
			display(root);
		}

		private void display(Node node) {
			if (node == null) {
				return;
			}
			System.out.println(node.data);
			display(node.left);
			display(node.right);

		}

	}

}
