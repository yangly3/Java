package IT.Java;

public class Student {

	private long id;
	private String name;
	private int gender;
	private int grade;
	private int score;

	public Student() {
	}

	public Student(long id, String name, int gender, int grade, int i) {
		this.id=id;
		this.name=name;
		this.gender=gender;
		this.grade=grade;
		this.score=score;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int isGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public long getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return String.format("{Student: id=%s, name=%s, gender=%s, grade=%d, score=%d}", this.id, this.name,this.gender, this.grade, this.score);
	}
}
