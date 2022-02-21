
public class Main {

	public static void main(String[] args) {
		Person p = new Person("Emma", 12);
		Student s = new Student("Denny", 20, 99);
		// 
		PrimaryStudent ps = new PrimaryStudent("Hello", 9, 100, 5);
		
		System.out.println(p.getName());
		System.out.println(s.getScore() );
		System.out.println(ps.getGrade());
	}

}
