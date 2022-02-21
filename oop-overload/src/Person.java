
public class Person {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setName(String name,String Alias) {
		this.name = name+"-"+Alias;	
	}

}
