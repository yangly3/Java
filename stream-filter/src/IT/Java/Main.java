package IT.Java;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Person> persons = List.of(new Person("�?明", 88), new Person("�?黑", 62), new Person("�?白", 45),
				new Person("�?黄", 78), new Person("�?红", 99), new Person("�?林", 58));
		// 
		persons.stream();
	}
}

class Person {
	String name;
	int score;

	Person(String name, int score) {
		this.name = name;
		this.score = score;
	}
}