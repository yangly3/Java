package IT.Java;


public class Main {

	public static void main(String[] args) {
		String[] fields = { "name", "position", "salary" };
		String table = "employee";
		String insert = buildInsertSql(table, fields);
		System.out.println(insert);
		System.out.println(
				"INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)".equals(insert) ? "Yes" : "No");
	}

	static String buildInsertSql(String table, String[] fields) {
		// TODO:
		return "";
	}

}
