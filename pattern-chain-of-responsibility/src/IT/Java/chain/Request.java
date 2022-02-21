package IT.Java.chain;

import java.math.BigDecimal;

public class Request {

	private String name;
	private BigDecimal amount;

	public Request(String name, BigDecimal amount) {
		this.name = name;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return String.format("{Request: name=%s, amount=%s}", name, amount);
	}
}
