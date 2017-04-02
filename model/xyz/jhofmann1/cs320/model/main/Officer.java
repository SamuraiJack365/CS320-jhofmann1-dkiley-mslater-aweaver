package xyz.jhofmann1.cs320.model.main;

public enum Officer {
	MEMBER		("Member", 0),
	PRESIDENT	("President", 1),
	VICE		("Vice-President", 2),
	TREASURER 	("Treasurer", 3),
	SECRETARY	("Secretary", 4);
	
	private final String title;
	private final int ID;
	
	Officer (String title, int ID){
		this.title = title;
		this.ID = ID;
	}

	public String getTitle() {
		return title;
	}

	public int getID() {
		return ID;
	}
	
	
}
