package xyz.jhofmann1.cs320.database.studentsdb.model;

public class StudentAdvisor {

	private int student_Id;
	private int advisor_Id;
	
	public void setStudentId(int student_Id) {
		this.student_Id = student_Id;
	}
	
	public int getStudentId() {
		return student_Id;
	}
	
	public void setAdvisorId(int advisor_Id) {
		this.advisor_Id = advisor_Id;
	}
	
	public int getAdvisorId() {
		return advisor_Id;
	}
}
