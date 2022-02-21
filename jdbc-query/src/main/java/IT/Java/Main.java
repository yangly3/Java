package IT.Java;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		List<Student> students = queryStudents();
		students.forEach(System.out::println);
	}

	static List<Student> queryStudents() throws SQLException {
		List<Student> students = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
			try (Statement stmt = conn.createStatement()) {
				try (ResultSet rs = stmt.executeQuery("SELECT id, grade, name, gender FROM students")) {

					while (rs.next()) {
						long id = rs.getLong(1); // 注意：索引从1开始
						int grade = rs.getInt(2);
						String name = rs.getString(3);
						int gender = rs.getInt(4);
						Student newStudent= new Student(id,name,gender,grade,0);
						students.add(newStudent);
					}
				}
			}
		}

		return students;
	}

	static Student extractRow(ResultSet rs) throws SQLException {
		var std = new Student();
		std.setId(rs.getLong("id"));
		std.setName(rs.getString("name"));
		std.setGender(rs.getInt("gender"));
		std.setGrade(rs.getInt("grade"));
		std.setScore(rs.getInt("score"));
		return std;
	}

	static final String jdbcUrl = "jdbc:mysql://localhost/learnjdbc?allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=utf8";
	static final String jdbcUsername = "learn";
	static final String jdbcPassword = "learnpassword";}
