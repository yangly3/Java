package IT.Java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import IT.Java.dao.UserDao;

@Component
@Transactional
public class UserService {

	@Autowired
	private
	UserDao userDao;

	public User getUserById(long id) {
		return getUserDao().getById(id);
	}

	public User fetchUserByEmail(String email) {
		return getUserDao().fetchUserByEmail(email);
	}

	public User getUserByEmail(String email) {
		return getUserDao().getUserByEmail(email);
	}

	public List<User> getUsers(int pageIndex) {
		return getUserDao().getAll(pageIndex);
	}

	public User login(String email, String password) {
		User user = fetchUserByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		throw new RuntimeException("login failed.");
	}

	public User register(String email, String password, String name) {
		if (getUserDao().fetchUserByEmail(email) != null) {
			throw new RuntimeException("Email is alreay exist.");
		}
		return getUserDao().createUser(email, password, name);
	}

	public void updateUser(User user) {
		getUserDao().updateUser(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
