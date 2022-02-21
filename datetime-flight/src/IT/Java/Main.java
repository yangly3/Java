package IT.Java;

import java.time.*;

/**
 * 
 * 
 * @author 
 */
public class Main {
	public static void main(String[] args) {
		LocalDateTime departureAtBeijing = LocalDateTime.of(2019, 9, 15, 13, 0, 0);
		int hours = 13;
		int minutes = 20;
		LocalDateTime arrivalAtNewYork = calculateArrivalAtNY(departureAtBeijing, hours, minutes);
		System.out.println(departureAtBeijing + " -> " + arrivalAtNewYork);
		// test:
		if (!LocalDateTime.of(2019, 10, 15, 14, 20, 0)
				.equals(calculateArrivalAtNY(LocalDateTime.of(2019, 10, 15, 13, 0, 0), 13, 20))) {
			System.err.println("测试失败!");
		} else if (!LocalDateTime.of(2019, 11, 15, 13, 20, 0)
				.equals(calculateArrivalAtNY(LocalDateTime.of(2019, 11, 15, 13, 0, 0), 13, 20))) {
			System.err.println("测试失败!");
		}
	}

	static LocalDateTime calculateArrivalAtNY(LocalDateTime bj, int h, int m) {
		return bj;
	}
}
