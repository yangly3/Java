package IT.Java.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import IT.Java.dao.UserDao;
import IT.Java.service.User;
import IT.Java.service.UserService;

class UserServiceTest {

	UserService userService;

	@BeforeEach
	void setUp() throws Exception {
		this.userService = new UserService();
		this.userService.setUserDao(new UserDao() {
			@Override
			public User fetchUserByEmail(String email) {
				User user = new User();
				user.setEmail("denis@example.com");
				user.setId(123);
				user.setName("Denis");
				user.setPassword("password");
				if (user.getEmail().equals(email)) {
					return user;
				}
				return null;
			}
		});
	}

	@Test
	void testLoginOk() {
		User user = this.userService.login("denis@example.com", "password");
		assertNotNull(user);
	}

	@Test
	void testLoginFailed() {
		assertThrows(RuntimeException.class, () -> {
			this.userService.login("denis@example.com", "password");
		});
	}
}
