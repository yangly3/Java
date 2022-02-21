package IT.Java.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import IT.Java.messaging.LoginMessage;
import IT.Java.messaging.RegistrationMessage;

@Component
public class MessagingService {

	@Autowired
	RabbitTemplate rabbitTemplate;

	public void sendRegistrationMessage(RegistrationMessage msg) {
		rabbitTemplate.convertAndSend("registration", "", msg);
	}

	public void sendLoginMessage(LoginMessage msg) {
		String routingKey = msg.success ? "" : "login_failed";
		rabbitTemplate.convertAndSend("login", routingKey, msg);
	}
}
