package IT.Java;

import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import IT.Java.service.UserService;

@Configuration
@ComponentScan
@PropertySource("app.properties")
@PropertySource("smtp.properties")
public class AppConfig {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		userService.login("denis@example.com", "password");
	}

	@Bean
	ZoneId createZoneId(@Value("${app.zone:Z}") String zoneId) {
		return ZoneId.of(zoneId);
	}
}
