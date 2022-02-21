package IT.Java;

import java.math.BigDecimal;

public interface DiscountStrategy {

	BigDecimal getDiscount(BigDecimal total);

}
