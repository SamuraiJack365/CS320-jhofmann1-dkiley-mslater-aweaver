package xyz.jhofmann1.cs320.model.main; // Is this in the right spot?

import java.util.HashMap;
import java.util.Map;

public enum Officer {
	MEMBER		("Member", 0),
	PRESIDENT	("President", 1),
	VICE		("Vice-President", 2),
	TREASURER 	("Treasurer", 3),
	SECRETARY	("Secretary", 4);
	
	private final String title;
	private final int ID;
	
	//reverse lookup hashmap times
	private static final Map<Integer, Officer> reverse = new HashMap<Integer, Officer>();
	
	static {
		for(Officer o : Officer.values()){
			reverse.put(o.getID(), o);
		}
	}
	
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
	
	public String toString() {
		return title;
	}
	
	public String toString(int ID) {
		return reverse.get(ID).getTitle();
	}
}
