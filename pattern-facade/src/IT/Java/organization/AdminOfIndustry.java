package IT.Java.organization;

public class AdminOfIndustry {

	public Company register(String name) {
		String id = String.format("%09d", 0x7fffffff & name.hashCode());
		Company c = new Company();
		c.setId(id);
		c.setName(name);
		return c;
	}
}
