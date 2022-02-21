package IT.Java;

import java.util.Arrays;


public class Main {
	public static void main(String[] args) {
		int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
		//
		System.out.println(Arrays.toString(ns));
		// TODO:
		// 
		System.out.println(Arrays.toString(ns));
		if (Arrays.toString(ns).equals("[96, 89, 73, 65, 50, 36, 28, 18, 12, 8]")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
