package xyz.jhofmann1.cs320.model.main;

import java.util.HashMap;
import java.util.Map;

public enum Major 
{
	TEST	(null, 0),
	AC		("Accounting", 1),
	AaDM	("Advertising and Digital Marketing", 2),
	BIO		("Biology", 3),
	BA		("Business Administration", 4),
	BAAD	("Business Administration A.S", 5),
	BAn		("Business Analytics", 6),
	CHEM	("Chemistry", 7),
	CiVE	("Civil Engineering", 8),
	CompE	("Computer Engineering", 9),
	CompSci	("Computer Science", 10),
	CJ		("Criminal Justice", 11),
	CM		("Cybersecurity Management", 12);
	
	private final String title;
	private final int ID;
	
	//Reverse look up map for int into String
	private static final Map<Integer, Major> reverse = new HashMap<Integer, Major>();
	
	static {
		for(Major m : Major.values())
			reverse.put(m.getID(), m);
	}
	
	Major(String title, int ID){
		this.title = title;
		this.ID = ID;
	}
	
	public int getID(){
		return ID;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String toString(int ID){
		return reverse.get(ID).getTitle();
	}
}
