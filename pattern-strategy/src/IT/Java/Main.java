package IT.Java;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
		DiscountContext ctx = new DiscountContext();
		// 
		BigDecimal pay1 = ctx.calculatePrice(BigDecimal.valueOf(105));
		System.out.println(pay1);
		// 
		ctx.setStrategy(new OverDiscountStrategy());
		BigDecimal pay2 = ctx.calculatePrice(BigDecimal.valueOf(105));
		System.out.println(pay2);
		// 
		ctx.setStrategy(new PrimeDiscountStrategy());
		BigDecimal pay3 = ctx.calculatePrice(BigDecimal.valueOf(105));
		System.out.println(pay3);
	}
}
