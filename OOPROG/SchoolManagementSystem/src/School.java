import java.util.ArrayList;

public class School {
	ArrayList<Student> students = new ArrayList<>();
	ArrayList<Teacher> teachers = new ArrayList<>();

	public void addStudent(Student student) {
		students.add(student);
	}

	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}

	public void removeTeacher(String teacherID) {
		teachers.removeIf(teacher -> teacher.getTeacherID().equals(teacherID));
	}

	public void removeStudent(String studID) {
		students.removeIf(stud -> stud.getStudentID().equals(studID));
	}

	public void displayStudents() {
		for (Student stud : students) {
			System.out.println(stud.toString());
		}
	}

	public void displayTeachers() {
		for (Teacher teach : teachers) {
			System.out.println(teach.toString());
		}
	}

	public Student searchStudent(String studentID) throws StudentNotFoundException {
		for (Student stud : students) {
			if (stud.getStudentID().equals(studentID)){
				return stud;
			}
		}
		throw new StudentNotFoundException("Student " + studentID + " not found");
	}

	public Teacher searchTeacher(String teacherID) throws TeacherNotFoundException {
		for (Teacher teach : teachers) {
			if (teach.getTeacherID().equals(teacherID)){
				return teach;
			}
		}
		throw new TeacherNotFoundException("Teacher " + teacherID + " not found!");
	}
}