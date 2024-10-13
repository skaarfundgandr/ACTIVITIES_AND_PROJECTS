/*
 * Use jdk 21 or higher run with 'java --source 22 --enable-preview Main.java'
 */
void main(){
	School school = new School();
	school.addStudent(new Student("Alice", 20, "S001", 1.5));
	school.addStudent(new Student("Bob", 21, "S002", 1.8));
	school.addTeacher(new Teacher("Mr. Smith", 40, "T001", "Math"));
	school.addTeacher(new Teacher("Ms. Johnson", 35, "T002", "History"));
	school.displayStudents();
	school.addTeacher(new Teacher("Quibs", 21, "S003", "2.0"));
	school.displayTeachers();
	try {
		Student stud = school.searchStudent("S003");
		System.out.println("Student Found");
		System.out.println(stud.toString());
	} catch(StudentNotFoundException e) {
		System.out.println(e.getMessage());
	}

}