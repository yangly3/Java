package IT.Java;

/**
 * Sum of integers.
 */
public class SumOfInteger {

	public static void main(String[] args) {
		int n = 500;
		// TODO: sum = 1 + 2 + ... + n
		int sum =0;
		for (int i=1;i <n;i++) {
			sum += i;
		}
		System.out.println(sum);
	}

}
