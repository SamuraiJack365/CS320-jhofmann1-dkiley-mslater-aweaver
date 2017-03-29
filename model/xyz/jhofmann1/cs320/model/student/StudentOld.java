package xyz.jhofmann1.cs320.model.student;

public class StudentOld {
	private String studentID; 	// This holds the student's YCP Username
	private String accolades; 	// This holds misc. achievements of the student
	private int[] majors; 		// This holds the IDs of the student's major(s)
	private int[] minors; 		// This holds the IDs of the student's minor(s)
	private int[] activities;	// This holds the IDs for all the clubs 
								// and sports the student were part of
	private int[] officer; 		// Contains the int IDs of the offices the student held
	private int studentIDNum; 	// 903 or 902 number for each student
	private double GPA;			
	private boolean displayGPA;
	private boolean reviewed;	// Shows whether or not the advisor has seen student's submissions
	private int approvalState; 	// Shows how close the student is to finishing their submissions
	
	public StudentOld(String studentID, String accolades, int[] majors, int[] minors, int[] activities, int[] officer, int studentIDNum, double GPA, boolean displayGPA, boolean reviewed, int approvalState){
		this.studentID = studentID;
		this.accolades = accolades;
		this.majors = majors;
		this.minors = minors;
		this.activities = activities;
		this.officer = officer;
		this.studentIDNum = studentIDNum;
		this.GPA = GPA;
		this.displayGPA = displayGPA;
		this.reviewed = reviewed;
		this.approvalState = approvalState;
	}
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getAccolades() {
		return accolades;
	}
	public void setAccolades(String accolades) {
		this.accolades = accolades;
	}
	public int[] getMajors() {
		return majors;
	}
	public void setMajors(int[] majors) {
		this.majors = majors;
	}
	public int[] getMinors() {
		return minors;
	}
	public void setMinors(int[] minors) {
		this.minors = minors;
	}
	public int[] getActivities() {
		return activities;
	}
	public void setActivities(int[] activities) {
		this.activities = activities;
	}
	public int[] getOfficer() {
		return officer;
	}
	public void setOfficer(int[] officer) {
		this.officer = officer;
	}
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double gPA) {
		GPA = gPA;
	}
	public boolean isDisplayGPA() {
		return displayGPA;
	}
	public void setDisplayGPA(boolean displayGPA) {
		this.displayGPA = displayGPA;
	}
	public boolean isReviewed() {
		return reviewed;
	}
	public void setReviewed(boolean reviewed) {
		this.reviewed = reviewed;
	}
	public int getApprovalState() {
		return approvalState;
	}
	public void setApprovalState(int approvalState) {
		this.approvalState = approvalState;
	}
	
}
