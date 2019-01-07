package ss.additional.week1;

public class Student {
	private int grade;
	
	//Constructors:
	public Student() {
		
	}
	
	//Queries:
	
	
	//Commands:
	public int adjustedGrade(int highGrade) {
		int maxAdj = 100 - highGrade;
		double adjRatio = (double) this.grade / highGrade;
		int adjGrade = (int) (adjRatio * maxAdj);
		return grade + adjGrade;
	}

}
