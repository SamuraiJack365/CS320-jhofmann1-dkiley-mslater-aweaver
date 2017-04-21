package xyz.jhofmann1.cs320.database.studentsdb.model;


public class Student {
	
	private int student_Id;
	private int ycp_Id;
	private String firstName;
	private String lastName;
	private int major;
//	private int major2;
//	private int major3;
//	private int minor;
//	private int minor2;
//	private int minor3;
	private	String picture;
//	private String picture2;
//	private String picture3;
//	private String picture4;
//	private	String picture5;
	private int sport;
//	private int sport2;
//	private int sport3;
//	private int sport4;
//	private int sport5;
	private int club;
//	private int club2;
//	private int club3;
	private double GPA;
	private boolean displayGPA;
	private boolean isReviewed;
	private String userName;
	
	public Student() {
		
	}
	
	public void setStudentId(int student_Id) {
		this.student_Id = student_Id;
	}
	
	public int getStudentId() {
		return student_Id;
	}
	
	public void setYcpId(int ycp_Id) {
		this.ycp_Id = ycp_Id;
	}
	
	public int getYcpId() {
		return ycp_Id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setMajor(int major) {
		this.major = major;
	}
	
	public int getMajor() {
		return major;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public String getPicture() {
		return picture;
	}
	
	public void setSport(int sport) {
		this.sport = sport;
	}
	
	public int getSport() {
		return sport;
	}
	
	public void setClub(int club) {
		this.club = club;
	}
	
	public int getClub() {
		return club;
	}
	
	public void setGPA(double GPA) {
		this.GPA = GPA;
	}
	
	public double getGPA() {
		return GPA;
	}
	
	public void setDisplayGPA(boolean displayGPA) {
		this.displayGPA = displayGPA;
	}
	
	public boolean getDisplayGPA() {
		return displayGPA;
	}
	
	public void setIsReviewed(boolean isReviewed) {
		this.isReviewed = isReviewed;
	}
	
	public boolean getIsReviewed() {
		return isReviewed;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
}
