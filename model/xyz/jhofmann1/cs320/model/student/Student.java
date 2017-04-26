package xyz.jhofmann1.cs320.model.student;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

import xyz.jhofmann1.cs320.model.main.User;

public class Student extends User {

	private int studentIDNum; 	// 903 or 902 number for each student
	private String studentID; 	// This holds the student's YCP Username eg. jhofmann1
	private String studentLastName;
	private String studentFirstName; 
	private int[] majors; 		// This holds the IDs of the student's major(s)
	private String accolades; 	// This holds misc. achievements of the student
	private int[] minors; 		// This holds the IDs of the student's minor(s)
	private int[] activities;	// This holds the IDs for all the clubs 
								// and sports the student were part of
	private int[] officer; 		// Contains the int IDs of the offices the student held
	private double GPA;			
	private boolean displayGPA;
	private boolean reviewed;	// Shows whether or not the advisor has seen student's submissions
	private int approvalState; 	// Shows how close the student is to finishing their submissions
	private String studentPic;

	public Student() throws NoSuchAlgorithmException, InvalidKeySpecException {
		// TODO Auto-generated constructor stub
	}

	public Student(String username, String password, ArrayList<Object> fields) throws NoSuchAlgorithmException, InvalidKeySpecException {
		super(username, password);
		setFields(fields);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Initializes all fields by calling setter methods. 
	 * ArrayList<Object> fields contains all fields in this order:
	 * studentID, accolades, majors, minors, activities, officer, studentIDNum, GPA, displayGPA, reviewed, approvalState
	 * @param fields
	 */
	private void setFields(ArrayList<Object> fields) {
		setStudentID((String) fields.get(0));
		setAccolades((String) fields.get(1));
		setMajors((int[]) fields.get(2));
		setMinors((int[]) fields.get(3));
		setActivities((int[]) fields.get(4));
		setOfficer((int[]) fields.get(5));
		setStudentIDNum((int) fields.get(6));
		setGPA((double) fields.get(7));
		setDisplayGPA((boolean) fields.get(8));
		setReviewed((boolean) fields.get(9));
		setApprovalState((int) fields.get(10));
		setStudentFirstName((String) fields.get(11));
		setStudentLastName((String) fields.get(12));
	}

	/**
	 * 
	 * @return
	 */
	public String getStudentID() {
		return studentID;
	}

	/**
	 * 
	 * @param studentID
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	/**
	 * 
	 * @return
	 */
	public String getAccolades() {
		return accolades;
	}

	/**
	 * 
	 * @param accolades
	 */
	public void setAccolades(String accolades) {
		this.accolades = accolades;
	}

	/**
	 * 
	 * @return
	 */
	public int[] getMajors() {
		return majors;
	}

	/**
	 * 
	 * @param majors
	 */
	public void setMajors(int[] majors) {
		this.majors = majors;
	}

	/**
	 * 
	 * @return
	 */
	public int[] getMinors() {
		return minors;
	}

	/**
	 * 
	 * @param minors
	 */
	public void setMinors(int[] minors) {
		this.minors = minors;
	}

	/**
	 * 
	 * @return
	 */
	public int[] getActivities() {
		return activities;
	}
	
	/**
	 * 
	 * @param activities
	 */
	public void setActivities(int[] activities) {
		this.activities = activities;
	}

	/**
	 * 
	 * @return
	 */
	public int[] getOfficer() {
		return officer;
	}

	/**
	 * 
	 * @param officer
	 */
	public void setOfficer(int[] officer) {
		this.officer = officer;
	}

	/**
	 * 
	 * @return
	 */
	public int getStudentIDNum() {
		return studentIDNum;
	}

	/**
	 * 
	 * @param studentIDNum
	 */
	public void setStudentIDNum(int studentIDNum) {
		this.studentIDNum = studentIDNum;
	}

	/**
	 * 
	 * @return
	 */
	public double getGPA() {
		return GPA;
	}

	/**
	 * 
	 * @param gPA
	 */
	public void setGPA(double gPA) {
		GPA = gPA;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isDisplayGPA() {
		return displayGPA;
	}

	/**
	 * 
	 * @param displayGPA
	 */
	public void setDisplayGPA(boolean displayGPA) {
		this.displayGPA = displayGPA;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isReviewed() {
		return reviewed;
	}
	
	/**
	 * 
	 * @param reviewed
	 */
	public void setReviewed(boolean reviewed) {
		this.reviewed = reviewed;
	}

	/**
	 * 
	 * @return
	 */
	public int getApprovalState() {
		return approvalState;
	}

	/**
	 * 
	 * @param approvalState
	 */
	public void setApprovalState(int approvalState) {
		this.approvalState = approvalState;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentPic() {
		return studentPic;
	}

	public void setStudentPic(String studentPic) {
		this.studentPic = studentPic;
	}
}