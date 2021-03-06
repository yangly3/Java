package IT.Java;

import java.util.*;


public class Main {
	public static void main(String[] args) {
		// 
		final int start = 10;
		final int end = 20;
		List<Integer> list = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			list.add(i);
		}
		// 
		Collections.shuffle(list);
		// 
		int removed = list.remove((int) (Math.random() * list.size()));
		int found = findMissingNumber(start, end, list);
		System.out.println(list.toString());
		System.out.println("missing number: " + found);
		System.out.println(removed == found ? "Yes" : "No");
	}

	/**
	 * TODO: 
	 */
	static int findMissingNumber(int start, int end, List<Integer> list) {
		return 0;
	}
}
