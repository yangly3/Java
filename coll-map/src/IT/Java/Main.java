package IT.Java;

import java.util.*;


public class Main {
	public static void main(String[] args) {
		List<Student> list = List.of(new Student("Bob", 78), new Student("Alice", 85), new Student("Brush", 66),
				new Student("Newton", 99));
		var holder = new Students(list);
		System.out.println(holder.getScore("Bob") == 78 ? "Yes" : "No");
		System.out.println(holder.getScore("Alice") == 85 ? "Yes" : "No");
		System.out.println(holder.getScore("Tom") == -1 ? "Yes" : "No");
	}
}

class Students {
	List<Student> list;
	Map<String, Integer> cache;

	Students(List<Student> list) {
		this.list = list;
		cache = new HashMap<>();
	}

	int getScore(String name) {
		// 
		Integer score = this.cache.get(name);
		if (score == null) {
			System.out.println("No Score");
		}
		return score == null ? -1 : score.intValue();
	}

	Integer findInList(String name) {
		for (var ss : this.list) {
			if (ss.name.equals(name)) {
				return ss.score;
			}
		}
		return null;
	}
}

class Student {
	String name;
	int score;

	Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
}
