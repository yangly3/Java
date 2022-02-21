package IT.Java.state;

public class BotContext {

	private State state = new DisconnectedState();

	public String chat(String input) {
		if ("hello".equalsIgnoreCase(input)) {
			state = new ConnectedState();
			return state.init();
		} else if ("bye".equalsIgnoreCase(input)) {
			state = new DisconnectedState();
			return state.init();
		}
		return state.reply(input);
	}
}
