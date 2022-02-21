
public class Person {

	static int count =0;

	String name;

	public Person(String name) {
		this.name = name;
	}
	
	public static int getCount() {		
		count+=1;
		return count;
	}

}
