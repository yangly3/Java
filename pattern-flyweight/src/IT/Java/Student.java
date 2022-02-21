package IT.Java;

import java.util.HashMap;
import java.util.Map;

public class Student {

	private static final Map<String, Student> cache = new HashMap<>();

	public static Student create(int id, String name) {
		String key = id + "\n" + name;
		Student std = cache.get(key);
		if (std == null) {
			System.out.println(String.format("create new Student(%s, %s)", id, name));
			std = new Student(id, name);
			cache.put(key, std);
		} else {
			System.out.println(String.format("return cached Student(%s, %s)", std.id, std.name));
		}
		return std;
	}

	private final int id;
	private final String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
