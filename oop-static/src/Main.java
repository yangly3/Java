
public class Main {

	public static void main(String[] args) {
		// TODO: 
		Person p1 = new Person("Alpha");
		System.out.println(Person.getCount()); // 1
		Person p2 = new Person("Beta");
		System.out.println(Person.getCount()); // 2
		Person p3 = new Person("Cannon");
		System.out.println(Person.getCount()); // 3
	}

}
