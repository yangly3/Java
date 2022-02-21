package IT.Java;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import IT.Java.service.User;
import IT.Java.service.UserService;

@Configuration
@ComponentScan
@EnableTransactionManagement
@PropertySource("jdbc.properties")
public class AppConfig {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		// 
		if (userService.fetchUserByEmail("denis@example.com") == null) {
			userService.register("denis@example.com", "password1", "Denis");
		}
		// 
		if (userService.fetchUserByEmail("alice@example.com") == null) {
			userService.register("alice@example.com", "password2", "Alice");
		}
		// 
		if (userService.fetchUserByEmail("tom@example.com") == null) {
			userService.register("tom@example.com", "password2", "Tom");
		}
		//
		try {
			userService.register("root@example.com", "password3", "root");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		// 
		for (User u : userService.getUsers(1)) {
			System.out.println(u);
		}
		((ConfigurableApplicationContext) context).close();
	}

	@Value("${jdbc.url}")
	String jdbcUrl;

	@Value("${jdbc.username}")
	String jdbcUsername;

	@Value("${jdbc.password}")
	String jdbcPassword;

	@Bean
	DataSource createDataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(jdbcUrl);
		config.setUsername(jdbcUsername);
		config.setPassword(jdbcPassword);
		config.addDataSourceProperty("autoCommit", "false");
		config.addDataSourceProperty("connectionTimeout", "5");
		config.addDataSourceProperty("idleTimeout", "60");
		return new HikariDataSource(config);
	}

	@Bean
	JdbcTemplate createJdbcTemplate(@Autowired DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	TransactionManager createTxManager(@Autowired DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
