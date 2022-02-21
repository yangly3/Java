package IT.Java;


public class Main {

	public static void main(String[] args) {
		Student s1 = Student.create(1, "Alpha");
		Student s2 = Student.create(2, "Beta");
		Student s3 = Student.create(1, "Charlie");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s1 == s3); // true
	}
}
