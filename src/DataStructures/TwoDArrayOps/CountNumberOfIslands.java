package TwoDArrayOps;

public class CountNumberOfIslands {

	public static void main(String[] args) {
		char[][] mat = { { 'O', 'O', 'O' }, { 'X', 'X', 'O' }, { 'X', 'X', 'O' }, { 'O', 'O', 'X' }, { 'O', 'O', 'X' },
				{ 'X', 'X', 'O' } };

		System.out.println(countIslands(mat));

	}

	public static int countIslands(char[][] arr) {
		int rv = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				// work area

				if (arr[i][j] == 'X') {

					if (i > 0 && arr[i - 1][j] == 'O' && j > 0 && arr[i][j - 1] == 'O') {
						rv++;
					} else if (i == 0 && arr[i][j - 1] == 'O') {
						rv++;
					} else if (j == 0 && arr[i - 1][j] == 'O') {
						rv++;
					}

				}

			}
		}
		return rv;
	}
}
