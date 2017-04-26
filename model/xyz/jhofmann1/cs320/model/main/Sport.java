package xyz.jhofmann1.cs320.model.main;

import java.util.HashMap;
import java.util.Map;

public enum Sport {
	BASE 	(1, "Baseball"),
	BASKET	(2, "Basketball"),
	CC 		(3, "Cross Country"),
	FH		(4, "Field Hockey"),
	GOLF	(5, "Golf"),
	LACROSSE(6, "Lacrosse"),
	SOCCER 	(7, "Soccer"),
	SOFT	(8, "Softball"),
	SWIM	(9, "Swimming"),
	TENNIS	(10,"Tennis"),
	TF		(11,"Track and Field"),
	VOLLEY	(12,"Volleyball"),
	WWE		(13,"Wrestling");
	
	private final String title;
	private final int ID;
	
	//Reverse look up map for int into String
	private static final Map<Integer, Sport> reverse = new HashMap<Integer, Sport>();
	
	static {
		for(Sport m : Sport.values())
			reverse.put(m.getID(), m);
	}
	
	Sport(String title, int ID){
		this.title = title;
		this.ID = ID;
	}
	
	Sport(int ID, String title){
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
	
	public Map getReverse(){
		return reverse;
	}
}
