package xyz.jhofmann1.cs320.database.studentsdb.model;

public class Major {

	private int major_Id;
	private String major;
	
	public Major() {
		
	}
	
	public void setMajorId(int major_Id) {
		this.major_Id = major_Id;
	}
	
	public int getMajorId() {
		return major_Id;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getMajor() {
		return major;
	}
}
