public class Teacher extends Person {
	private String name, teacherID, subject;
	private int age;

	public Teacher(String name, int age, String teacherID, String subject) {
		this.name = name;
		this.teacherID = teacherID;
		this.subject = subject;
		this.age = age;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	public String getTeacherID() {
		return this.teacherID;
	}
	public String getSubject() {
		return this.subject;
	}
	public String toString() {
		return  "Name: " + this.name + "\n" +
			"Age: " + this.age + "\n" +
			"Teacher ID: " + this.teacherID + "\n" +
			"Subject: " + this.subject;
	}
}