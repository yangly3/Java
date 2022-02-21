package IT.Java;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
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
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import IT.Java.entity.AbstractEntity;
import IT.Java.entity.User;
import IT.Java.service.UserService;

@Configuration
@ComponentScan
@EnableTransactionManagement
@PropertySource("jdbc.properties")
public class AppConfig {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		if (userService.fetchUserByEmail("denis@example.com") == null) {
			User denis = userService.register("denis@example.com", "denis123", "Denis");
			System.out.println("Registered ok: " + denis);
		}
		if (userService.fetchUserByEmail("alice@example.com") == null) {
			try {
				User alice = userService.register("alice@example.com", "helloalice", "Alice");
				System.out.println("Registered ok: " + alice);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 
		for (User u : userService.getUsers(1)) {
			System.out.println(u);
		}
		User denis = userService.login("denis@example.com", "denis123");
		System.out.println(denis);
		((ConfigurableApplicationContext) context).close();
	}

	@Bean
	DataSource createDataSource(
			// JDBC URL:
			@Value("${jdbc.url}") String jdbcUrl,
			// JDBC username:
			@Value("${jdbc.username}") String jdbcUsername,
			// JDBC password:
			@Value("${jdbc.password}") String jdbcPassword) {
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
	LocalContainerEntityManagerFactoryBean createEntityManagerFactory(@Autowired DataSource dataSource) {
		var props = new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", "update"); // 
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		props.setProperty("hibernate.show_sql", "true");
		var entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		//
		entityManagerFactoryBean.setPackagesToScan(AbstractEntity.class.getPackageName());
		// 
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.setJpaProperties(props);
		return entityManagerFactoryBean;
	}

	@Bean
	PlatformTransactionManager createTxManager(@Autowired EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
