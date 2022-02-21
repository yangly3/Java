package IT.Java.chain;

import java.math.BigDecimal;

public class CEOHandler implements Handler {

	@Override
	public Boolean process(Request request) {
		if (request.getAmount().compareTo(BigDecimal.valueOf(50000)) > 0) {
			return Boolean.FALSE;
		}
		return !request.getName().equalsIgnoreCase("alice");
	}
}
