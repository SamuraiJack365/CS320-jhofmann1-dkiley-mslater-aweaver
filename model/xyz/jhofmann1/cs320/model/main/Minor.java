package xyz.jhofmann1.cs320.model.main;

import java.util.HashMap;
import java.util.Map;

public enum Minor {
	test 	(null, 0),
	Adv	 	("Advertising", 1),
	AAAS 	("African and African-American Studies", 2),
	AH		("American History", 3),
	Anthro	("Anthropology", 4),
	AYD		("Applied Youth Development", 5),
	ArtHist	("Art History", 6),
	ArtAdmin("Art Administration", 7),
	AC		("Athletic Coaching", 8),
	CI		("Continuous Improvement", 9),
	CW		("Creative Writing", 10),
	C		("Criminalistics", 11),
	CTT		("Critical Thinking and Theory", 12),
	Entre	("Entrepeneurship", 13),
	Ethics	("Ethics", 14),
	FS		("Film Studies", 15),
	Fr		("French", 16),
	Geo		("Geography", 17),
	Ger		("German", 18),
	Geron	("Gerontology", 19),
	HM		("Hospitality Marketing", 20),
	HRM		("Human Resource Management", 21),
	IS		("Information Systems", 22),
	IB		("International Business", 23),
	IM		("International Management", 24),
	LeS		("Legal Studies", 25),
	LiS		("Literary Studies", 26),
	M		("Management", 27),
	MC		("Marketing Communications", 28),
	MM		("Marketing Management", 29),
	Math	("Mathematics", 30),
	MT		("Music Theatre", 31),
	NFPM	("Not-For-Profit Management", 32),
	OM		("Operations Management", 33),
	OL		("Outdoor Leadership", 34),
	Photo	("Photography", 35),
	Physics	("Physics", 36),
	PA		("Public Administration", 37),
	RS		("Religious Studies", 38),
	R		("Retailing", 39),
	SC		("Speech Communication", 40),
	SES		("Sustainability and Environmental Studies", 41),
	VC		("Visual Communication", 42),
	SWaG	("Women's and Gender Studies", 43), //Study of Women And Gender = SWAG
	WH		("World History", 44);
	
	private final String title;
	private final int ID;
	
	//Reverse look up map for int into String
	private static final Map<Integer, Minor> reverse = new HashMap<Integer, Minor>();
	private static final Map<Integer, String> reverseString = new HashMap<Integer, String>();
	
	static {
		for(Minor m : Minor.values()){
			reverse.put(m.getID(), m);
			reverseString.put(m.getID(), m.getTitle());
		}
	}
	
	Minor(String title, int ID){
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
	
	public Map<Integer, Minor> getReverse(){
		return reverse;
	}
	public Map<Integer, String> getReverseString(){
		return reverseString;
	}
}
