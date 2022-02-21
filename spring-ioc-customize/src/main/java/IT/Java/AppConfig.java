package IT.Java;

import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import IT.Java.service.MailSession;
import IT.Java.service.User;
import IT.Java.service.UserService;

@Configuration
@ComponentScan
public class AppConfig {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		userService.register("denis@example.com", "password", "Denis");
		User user = userService.login("denis@example.com", "password");
		System.out.println(user.getName());
		context.getBean(MailSession.class);
		context.getBean(MailSession.class);
		context.getBean(MailSession.class);
		((ConfigurableApplicationContext) context).close();

	}

	@Bean
	@Primary
	@Qualifier("z")
	ZoneId createZoneOfZ() {
		return ZoneId.of("Z");
	}

	@Bean
	@Qualifier("utc8")
	ZoneId createZoneOfUTC8() {
		return ZoneId.of("UTC+08:00");
	}
}
