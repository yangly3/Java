
public class Main {

	public static void main(String[] args) {
		Person ming = new Person();
		ming.setName("Xiao Ming");
		System.out.println(ming.getName());
		Person hong = new Person();
		// FIXME:
		hong.setName("Xiao", "Hong");
		System.out.println(hong.getName());
	}

}
