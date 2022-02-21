package IT.Java;


public class Main {

	public static void main(String[] args) {
		String token = login("admin", "pass");
		System.out.println("Token: " + token);
	}

	static String login(String username, String password) {
		if (username.equals("admin")) {
			if (password.equals("password")) {
				return "xxxxxx";
			} else {
				// 
				throw new LoginFailedException("Bad username or password.");
			}
		} else {
			// 
			throw new UserNotFoundException("User not found.");
		}
	}
}
