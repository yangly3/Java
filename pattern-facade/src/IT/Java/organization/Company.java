package IT.Java.organization;

public class Company {

	private String name;
	private String id;
	private String bankAccount;
	private String taxCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	@Override
	public String toString() {
		return String.format("{Company: name=%s, id=%s, bankAccount=%s, taxCode=%s}", this.name, this.id,
				this.bankAccount, this.taxCode);
	}
}
