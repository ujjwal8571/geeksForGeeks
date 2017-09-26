package AllQueueOps;

import java.util.LinkedList;
import java.util.Scanner;

public class RottenOranges {

	public static void main(String[] args) {
		// int arr[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		//
		// System.out.println(findTimeForAllOrangesToRot(arr));

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		while (t > 0) {

			int r = scn.nextInt();
			int c = scn.nextInt();
			int[][] mat = new int[r][c];

			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[0].length; j++) {

					mat[i][j] = scn.nextInt();
				}
			}

			System.out.println(findTimeForAllOrangesToRot(mat));

			t--;
		}
	}

	public static class matIdx {
		int x;
		int y;

		public matIdx(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int findTimeForAllOrangesToRot(int[][] mat) {
		int ans = 0;

		LinkedList<matIdx> queue = new LinkedList<>();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {

				if (mat[i][j] == 2) {

					queue.addLast(new matIdx(i, j));
				}
			}
		}

		queue.add(new matIdx(-1, -1));

		while (!queue.isEmpty()) {

			boolean isTimeFrameIncrementedForThisIteration = false;

			while (!isDelimiter(queue.peek())) {

				matIdx currBlock = queue.getFirst();

				if (isValidBlock(currBlock.x + 1, currBlock.y, mat) && mat[currBlock.x + 1][currBlock.y] == 1) {

					if (isTimeFrameIncrementedForThisIteration == false) {
						ans++;
						isTimeFrameIncrementedForThisIteration = true;
					}
					mat[currBlock.x + 1][currBlock.y] = 2;

					queue.addLast(new matIdx(currBlock.x + 1, currBlock.y));

				}

				if (isValidBlock(currBlock.x - 1, currBlock.y, mat) && mat[currBlock.x - 1][currBlock.y] == 1) {
					if (isTimeFrameIncrementedForThisIteration == false) {
						ans++;
						isTimeFrameIncrementedForThisIteration = true;
					}
					mat[currBlock.x - 1][currBlock.y] = 2;

					queue.addLast(new matIdx(currBlock.x - 1, currBlock.y));

				}

				if (isValidBlock(currBlock.x, currBlock.y + 1, mat) && mat[currBlock.x][currBlock.y + 1] == 1) {
					if (isTimeFrameIncrementedForThisIteration == false) {
						ans++;
						isTimeFrameIncrementedForThisIteration = true;
					}

					mat[currBlock.x][currBlock.y + 1] = 2;
					queue.addLast(new matIdx(currBlock.x, currBlock.y + 1));

				}

				if (isValidBlock(currBlock.x, currBlock.y - 1, mat) && mat[currBlock.x][currBlock.y - 1] == 1) {
					if (isTimeFrameIncrementedForThisIteration == false) {
						ans++;
						isTimeFrameIncrementedForThisIteration = true;
					}
					mat[currBlock.x][currBlock.y - 1] = 2;
					queue.addLast(new matIdx(currBlock.x, currBlock.y - 1));

				}
				// remove the processed element
				queue.removeFirst();
			}

			// remove the delimiter
			queue.removeFirst();

			if (!queue.isEmpty()) {
				// add new delimiter if the queue is not empty
				queue.addLast(new matIdx(-1, -1));
			}

		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {

				if (mat[i][j] == 1) {

					return -1;
				}
			}
		}

		return ans;

	}

	private static boolean isValidBlock(int x, int y, int[][] mat) {
		return x >= 0 && y >= 0 && x < mat.length && y < mat[0].length;
	}

	private static boolean isDelimiter(matIdx peek) {
		return peek.x == -1 && peek.y == -1;
	}

}
