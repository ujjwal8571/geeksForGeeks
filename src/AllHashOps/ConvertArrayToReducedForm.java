package AllHashOps;

import java.util.Arrays;
import java.util.HashMap;

import AllArrayOps.ArrayBasic;

public class ConvertArrayToReducedForm extends ArrayBasic {

	public static void main(String[] args) {

		int[] arr = { 5, 10, 40, 30, 20 };

		int[] ans = convertArrToReducedForm(arr);

		display(ans);
	}

	public static int[] convertArrToReducedForm(int[] arr) {

		int[] temp = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}

		Arrays.sort(temp);
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < temp.length; i++) {
			hm.put(temp[i], i);
		}

		int[] rv = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			rv[i] = hm.get(arr[i]);
		}

		return rv;
	}

}
