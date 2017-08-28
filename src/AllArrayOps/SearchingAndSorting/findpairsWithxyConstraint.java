package AllArrayOps.SearchingAndSorting;

import java.util.Arrays;

public class findpairsWithxyConstraint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// UNDONE

	public static int findPairOfXandY(int[] x, int[] y) {

//		int[][] baseAns = { { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 0, 1 },
//				{ 1, 1, 0, 0, 0 } };
		int rv = 0;

		Arrays.sort(x);
		Arrays.sort(y);

		for (int i = 0; i < x.length; i++) {

			int xVal = x[i];
			for (int j = i + 1; j < y.length; j++) {
				int yVal = y[j];
				
				if(xVal == 0) {
					
				} else if(xVal == 1) {
					
				} else if(xVal == 2) {
					
				} else if(xVal == )
				
				
				
			}
		}

		return rv;

	}

}
