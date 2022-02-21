package IT.Java;

import java.util.Arrays;
import java.util.Comparator;


public class Main {

	public static void main(String[] args) {
		String[] array = new String[] { "apple", "Orange", "banana", "Lemon" };
		// 
		Arrays.sort(array, new Comparator<>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(String.join(", ", array));
	}
}
