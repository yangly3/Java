package IT.Java.web;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Component
public class ChatHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

	public ChatHandshakeInterceptor() {
		// 
		super(List.of(UserController.KEY_USER));
	}
}
