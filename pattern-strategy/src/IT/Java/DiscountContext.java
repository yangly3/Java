package IT.Java;

import java.math.BigDecimal;

public class DiscountContext {

	private DiscountStrategy strategy = new UserDiscountStrategy();

	public void setStrategy(DiscountStrategy strategy) {
		this.strategy = strategy;
	}

	public BigDecimal calculatePrice(BigDecimal total) {
		return total.subtract(this.strategy.getDiscount(total)).setScale(2);
	}
}
