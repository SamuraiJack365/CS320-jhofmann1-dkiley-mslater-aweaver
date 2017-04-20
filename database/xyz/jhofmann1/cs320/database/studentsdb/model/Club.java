package xyz.jhofmann1.cs320.database.studentsdb.model;

public class Club {

	private int club_Id;
	private String club;
	
	public Club() {
		
	}
	
	public void setClubId(int club_Id) {
		this.club_Id = club_Id;
	}
	
	public int getClubId() {
		return club_Id;
	}
	
	public void setClub(String club) {
		this.club = club;
	}
	
	public String getClub() {
		return club;
	}
}
