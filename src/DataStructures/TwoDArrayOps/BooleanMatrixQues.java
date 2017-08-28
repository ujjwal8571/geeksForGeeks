package TwoDArrayOps;

public class BooleanMatrixQues {

	public static void main(String[] args) {
		int[][] arr = { { 1, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, };
		display(arr);
		updateMatrix(arr, 0, 0);
		display(arr);
	}

	public static void display(int[][] arr) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + ", ");
			}
			System.out.println();
		}
	}

	public static void updateMatrix(int[][] arr, int row, int col) {
		
		boolean rowflag=false,colflag=false;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				if (arr[i][j] == 1) {
					
					if(i==0) {
						rowflag = true;
					} 
					if(j==0) {
						colflag = true;
					}
					
					arr[0][j] = 1;
					arr[i][0] = 1;
				}

			}

		}


		for (int i = 1; i < arr.length; i++) {

			if (arr[i][0] == 1) {

				for (int j = 1; j < arr[0].length; j++) {
					arr[i][j] = 1;
				}

			}

		}

		for (int i = 1; i < arr[0].length; i++) {

			if (arr[0][i] == 1) {

				for (int j = 1; j < arr.length; j++) {
					arr[j][i] = 1;
				}

			}

		}
		
		
		// first row
		
		if(rowflag) {
			for(int j=0;j<arr.length;j++) {
				arr[0][j] = 1;
			}
		}
		
		
		// first column

		if(colflag) {
			for(int j=0;j<arr.length;j++) {
				arr[j][0] = 1;
			}
		}
	}

}
