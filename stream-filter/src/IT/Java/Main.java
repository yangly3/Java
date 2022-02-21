package IT.Java;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Person> persons = List.of(new Person("å°?æ˜Ž", 88), new Person("å°?é»‘", 62), new Person("å°?ç™½", 45),
				new Person("å°?é»„", 78), new Person("å°?çº¢", 99), new Person("å°?æž—", 58));
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