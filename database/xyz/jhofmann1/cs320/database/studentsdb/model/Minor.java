package xyz.jhofmann1.cs320.database.studentsdb.model;

public class Minor {
	
	private int minor_Id;
	private String minor;
	
	public Minor() {
		
	}
	
	public void setMinorId(int minor_Id) {
		this.minor_Id = minor_Id;
	}
	
	public int getMinorId() {
		return minor_Id;
	}
	
	public void setMinor(String minor) {
		this.minor = minor;
	}
	
	public String getMinor() {
		return minor;
	}
}
