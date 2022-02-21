package IT.Java.chain;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain {

	private List<Handler> handlers = new ArrayList<>();

	public void addHandler(Handler handler) {
		this.handlers.add(handler);
	}

	public boolean process(Request request) {
		for (Handler handler : handlers) {
			Boolean r = handler.process(request);
			if (r != null) {
				System.out.println(
						request + " " + (r ? "Approved by " : "Denied by ") + handler.getClass().getSimpleName());
				return r;
			}
		}
		throw new RuntimeException("Could not handle request: " + request);
	}
}
