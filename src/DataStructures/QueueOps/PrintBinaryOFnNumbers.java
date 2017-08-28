package DataStructures.QueueOps;

import java.util.LinkedList;
import java.util.Scanner;

public class PrintBinaryOFnNumbers {

	public static void main(String[] args) {
		printNbinary(127);
	}

	public static void printNbinary(int n) {

		LinkedList<String> queue = new LinkedList<>();

		queue.addLast("1");

		for (int i = 0; i < n; i++) {
			String str = queue.removeFirst();
			System.out.println(str);
			String temp = str + "0";
			queue.addLast(temp);
			temp = str + "1";
			queue.addLast(temp);
		}
	}

}
