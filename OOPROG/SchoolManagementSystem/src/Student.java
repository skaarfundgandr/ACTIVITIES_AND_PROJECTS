public class Student extends Person {
	private String name, studentID;
	private int age;
	private double grade;
	
	public Student(String name, int age, String studID, double grade) {
		this.name = name;
		this.studentID = studID;
		this.age = age;
		this.grade = grade;
	}
	
	public String getName() {
		return this.name;
	}
	public String getStudentID() {
		return this.studentID;
	}
	public int getAge() {
		return this.age;
	}
	public double getGrade() {
		return this.grade;
	}
	public String toString() {
		return  "Name: " + this.name + "\n" +
			"Age: " + this.age + "\n" +
			"Student ID: " + this.studentID + "\n" +
			"Grade: " + this.grade;
	}
}