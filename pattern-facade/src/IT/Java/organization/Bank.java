package IT.Java.organization;

public class Bank {

	public String openAccount(String companyId) {
		return String.format("1%015d", 0x7fffffff & companyId.hashCode() * companyId.hashCode());
	}
}
