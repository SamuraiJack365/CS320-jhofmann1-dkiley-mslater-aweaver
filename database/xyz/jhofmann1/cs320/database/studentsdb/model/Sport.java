package xyz.jhofmann1.cs320.database.studentsdb.model;

public class Sport {
	
	private int sport_Id;
	private String sport;
	
	public Sport() {
		
	}
	
	public void setSportId(int sport_Id) {
		this.sport_Id = sport_Id;
	}
	
	public int getSportId() {
		return sport_Id;
	}
	
	public void setSport(String sport) {
		this.sport = sport;
	}
	
	public String getSport() {
		return sport;
	}

}
