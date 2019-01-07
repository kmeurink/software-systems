package ss.additional.week5;

import java.util.*;

//Exercise 12.3
public class Course {
	private List<Student> enrollees;
	private final static int MINIMUM_PASS = 7;
	//Initializing the list enrollees
	public Course() {
		this.enrollees = new ArrayList<Student>();
	}
	
	//Adding method for adding student to list
	public void enroll(Student student) {
		//To ensure the student is not already in the list, a check is added:
		if (!enrollees.contains(student)) {
			enrollees.add(student);	
		}
	}
	//Unenroll the student from the list
	public void unenroll(Student student) {
		enrollees.remove(student);
	}
	
	//Exercise 12.4
	public int studentFailedAmount(List<Student> student) {
		int count = 0;
		for (int i = 0; i < student.size(); i++) {
			if (student.get(i).finalGrade() < MINIMUM_PASS) {
				count++;
			}
		}
		return count;
	}
	public List<Student> failingStudents() {
		List<Student> failedList = new ArrayList<Student>();
		for (int i = 0; i < enrollees.size(); i++) {
			if (enrollees.get(i).finalGrade() < MINIMUM_PASS) {
				failedList.add(enrollees.get(i));
			}
		}
		return failedList;
	}
	
	private class Student {
		public int finalGrade() {
		// TODO Auto-generated method stub
			return 0;
		}
	}

}
 