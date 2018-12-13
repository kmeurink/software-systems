package ss.additional.week5;

public class Course {
	private List<Student> enrollees;
	
	//Initializing the list enrollees
	public Course() {
		this.enrollees = new ArrayList<Student>();
	}
	
	//Adding method for adding student to list
	public void enroll (Student student) {
		//To ensure the student is not already in the list, a check is added:
		if (!enrollees.contain(student)) {
			enrollees.add(student);	
		}
	}
	//Unenroll the student from the list
	public void unenroll(Student student) {
		enrollees.remove(student);
	}

}
 