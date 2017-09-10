package AllBinaryTreeOps.Miscellaneous;

public class FindHeightByParentArray {

	public static void main(String[] args) {
		int parent[] = new int[] { 1, 5, 5, 2, 2, -1, 3 };

		System.out.println(findHeight(parent));
	}

	public static int findHeight(int[] parent) {

		int[] heights = new int[parent.length];

		for (int i = 0; i < parent.length; i++) {

			int h = findNodeHeight(parent, heights, i);
			heights[i] = h;
		}

		int maxHeight = 0;

		for (int val : heights) {
			if (val > maxHeight) {
				maxHeight = val;
			}
		}

		return maxHeight;

	}

	public static int findNodeHeight(int[] parent, int[] heights, int idx) {

		if (idx == -1) {
			return -1;
		}

		if (heights[idx] != 0) {
			return heights[idx];
		}

		return findNodeHeight(parent, heights, parent[idx]) + 1;

	}

}
