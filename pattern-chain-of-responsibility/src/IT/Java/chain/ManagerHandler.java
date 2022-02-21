package IT.Java.chain;

import java.math.BigDecimal;

public class ManagerHandler implements Handler {

	@Override
	public Boolean process(Request request) {
		if (request.getAmount().compareTo(BigDecimal.valueOf(1000)) > 0) {
			return null;
		}
		return !request.getName().equalsIgnoreCase("bob");
	}
}
