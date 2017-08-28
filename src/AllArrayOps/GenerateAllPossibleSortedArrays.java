package AllArrayOps;

import java.util.ArrayList;

public class GenerateAllPossibleSortedArrays {

	public static void main(String[] args) {
		int[] one = { 10, 15, 25 };
		int[] two = { 1, 5, 20, 30 };

		printAllPossibleSortedArrays(one, 0, two, 0, true, new ArrayList<>());
	}

	public static void printAllPossibleSortedArrays(int[] one, int vidx, int[] two, int vidx2, boolean isFromOne,
			ArrayList<Integer> rv) {

		if (isFromOne && vidx >= one.length) {
			System.out.println(rv);
			return;
		}

		if (!isFromOne && vidx2 >= two.length) {
			System.out.println(rv);
			return;
		}

		int temp = -1;
		if (!rv.isEmpty()) {
			temp = rv.get(rv.size() - 1);
		}

		if (isFromOne) {

			int i = vidx;
			int val;

			while (i < one.length) {
				val = one[i];
				if (val > temp) {

					rv.add(val);
					printAllPossibleSortedArrays(one, vidx + i + 1, two, vidx2, !isFromOne, rv);
					rv.remove(rv.size() - 1);
				}
				i++;
			}

		} else {

			int i = vidx2;
			int val;

			while (i < two.length) {
				val = two[i];
				if (val > temp) {

					rv.add(val);
					printAllPossibleSortedArrays(one, vidx, two, vidx2 + i + 1, !isFromOne, rv);
					rv.remove(rv.size() - 1);
				}
				i++;
			}

		}
	}

}
