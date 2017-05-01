package xyz.jhofmann1.cs320.model.student;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

import xyz.jhofmann1.cs320.model.main.User;

public class Student extends User {

	private int studentIDNum; 	// 903 or 902 number for each student
	private int[] majors; 		// This holds the IDs of the student's major(s)
	private String accolades; 	// This holds misc. achievements of the student
	private int[] minors; 		// This holds the IDs of the student's minor(s)
	private int[] sports;
	private int[] clubs;
	
	private int[] officer; 		// Contains the int IDs of the offices the student held
	private double GPA;			
	private boolean displayGPA;
	private boolean reviewed;	// Shows whether or not the advisor has seen student's submissions
	private boolean approvalState; 	// Shows how close the student is to finishing their submissions
	private String studentPic;

	public Student() throws NoSuchAlgorithmException, InvalidKeySpecException {
		super();
	}

	public Student(String username, String password, ArrayList<Object> fields) throws NoSuchAlgorithmException, InvalidKeySpecException {
		super(username, password);
		minors = new int[]{0, 0, 0};
		majors = new int[]{0, 0, 0};
		sports = new int[]{0, 0};
		clubs = new int[]{0, 0};
		officer = new int[]{0, 0};
		
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
		setUsername((String) fields.get(0));
		setAccolades((String) fields.get(1));
		setMajors((int[]) fields.get(2));
		setMinors((int[]) fields.get(3));
		setSports((int[]) fields.get(4));
		setClubs((int[]) fields.get(13));
		setOfficer((int[]) fields.get(5));
		setStudentIDNum((int) fields.get(6));
		setGPA((double) fields.get(7));
		setDisplayGPA((boolean) fields.get(8));
		setReviewed((boolean) fields.get(9));
		setApprovalState((boolean) fields.get(10));
		setFirstName((String) fields.get(11));
		setLastName((String) fields.get(12));
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
	public boolean getApprovalState() {
		return approvalState;
	}

	/**
	 * 
	 * @param approvalState
	 */
	public void setApprovalState(boolean approvalState) {
		this.approvalState = approvalState;
	}

	public String getStudentPic() {
		return studentPic;
	}

	public void setStudentPic(String studentPic) {
		this.studentPic = studentPic;
	}

	public int[] getSports() {
		return sports;
	}

	public void setSports(int[] sports) {
		this.sports = sports;
	}

	public int[] getClubs() {
		return clubs;
	}

	public void setClubs(int[] clubs) {
		this.clubs = clubs;
	}
}