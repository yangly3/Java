package IT.Java;

public class Main {

	public static void main(String[] args) {
		String[] fields = { "name", "position", "salary" };
		String table = "employee";
		String select = buildSelectSql(table, fields);
		System.out.println(select);
		System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试�?功" : "测试失败");
	}

	static String buildSelectSql(String table, String[] fields) {
		// TODO:
		return "";
	}

}
