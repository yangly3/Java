package IT.Java.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import IT.Java.mail.MailService;

@Component
public class UserService {

	@Autowired(required = false)
	private MailService mailService;

	@Qualifier("createZoneId")
	@Autowired
	private ZoneId zoneId;

	private List<User> users = new ArrayList<>(List.of( // users:
			new User(1, "denis@example.com", "password", "Denis"), // Denis
			new User(2, "alice@example.com", "password", "Alice"), // Alice
			new User(3, "tom@example.com", "password", "Tom"))); // Tom

	public User login(String email, String password) {
		for (User user : users) {
			if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
				if (mailService != null) {
					mailService.sendMail(user.getEmail(), "Login successfully", "Hi, you have logged in at "
							+ ZonedDateTime.now(this.zoneId).format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
				} else {
					System.out.println("skip send email.");
				}
				return user;
			}
		}
		throw new RuntimeException("login failed.");
	}
}
