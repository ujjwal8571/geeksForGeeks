package AllBinarySearchTreeOps;

import AllBinaryTreeOps.BaseTree;

public class LargestBstInTree extends BaseTree {

	public static void main(String[] args) {
		// Node root = new Node(50);
		// root.left = new Node(10);
		// root.right = new Node(60);
		// root.left.left = new Node(5);
		// root.left.right = new Node(20);
		// root.right.left = new Node(55);
		// root.right.left.left = new Node(45);
		// root.right.right = new Node(70);
		// root.right.right.left = new Node(65);
		// root.right.right.right = new Node(80);

		Node root = new Node(1);
		root.right = new Node(2);
		root.right.right = new Node(3);
		root.right.right.right = new Node(4);
		root.right.right.right.right = new Node(5);
		root.right.right.right.right.right = new Node(6);
		root.right.right.right.right.right.right = new Node(7);
		root.right.right.right.right.right.right.left = new Node(8);

		System.out.println(findLargestBstSize(root).maxBstSize);

	}

	public static class BstPair {

		int maxBstSize;
		int myMax = Integer.MIN_VALUE;
		int myMin = Integer.MAX_VALUE;
		boolean isBst = true;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			String rv = "[ " + maxBstSize + " , " + myMax + " , " + myMin + " , " + isBst + " ]";
			return rv;
		}
	}

	public static BstPair findLargestBstSize(Node node) {

		if (node == null) {
			return new BstPair();
		}

		if (isLeaf(node)) {
			BstPair pair = new BstPair();
			pair.maxBstSize = 1;
			pair.myMax = node.data;
			pair.myMin = node.data;
			pair.isBst = true;
			return pair;
		}

		BstPair la = findLargestBstSize(node.left);
		BstPair ra = findLargestBstSize(node.right);

		BstPair mypair = new BstPair();

		System.out.println(node.data + " la -> " + la + " || ra -> " + ra);
		mypair.myMin = Math.min(node.data, Math.min(la.myMin, ra.myMin));
		mypair.myMax = Math.max(node.data, Math.max(la.myMax, ra.myMax));

		mypair.maxBstSize = Math.max(la.maxBstSize, ra.maxBstSize);

		if (!la.isBst || !ra.isBst) {
			mypair.isBst = false;
			return mypair;
		}

		if (node.data > la.myMax && node.data < ra.myMin) {
			mypair.maxBstSize = la.maxBstSize + ra.maxBstSize + 1;
		} else {
			mypair.isBst = false;
		}

		return mypair;
	}

}
