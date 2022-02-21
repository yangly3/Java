package IT.Java;

import java.lang.reflect.Field;

public class Main {

	public static void main(String[] args) throws Exception {
		Person p1 = new Person("Bob", "Vancouver", 20);
		Person p2 = new Person("Me", "Victioria", 20);
		Person p3 = new Person("Alice", "London", 1995);
		for (Person p : new Person[] { p1, p2, p3 }) {
			try {
				check(p);
				System.out.println("Person " + p + " checked ok.");
			} catch (IllegalArgumentException e) {
				System.out.println("Person " + p + " checked failed: " + e);
			}
		}
	}

	static void check(Person person) throws IllegalArgumentException, ReflectiveOperationException {
		for (Field field : person.getClass().getFields()) {
			Range range = field.getAnnotation(Range.class);
			if (range != null) {
				Object value = field.get(person);
				// TODO:
			}
		}
	}
}
