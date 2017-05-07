package xyz.jhofmann1.cs320.model.main;

import java.util.HashMap;
import java.util.Map;

public enum Club  implements EnumInter{
	TEST	(0, null),
	AGAD	(1,"AIGA, Graphic Arts & Design"),
	AC		(2,"Alpha Chi"),
	ACJA	(3,"American Criminal Justice Association"),
	AnC		(4,"Anime Club"),
	BB		(5,"Best Buddies"),
	BC		(6,"Biology Club"),
	CAB		(7,"Campus Activities Board"),
	CS		(8,"Chemistry Society"),
	CB		(9,"Club Baseball"),
	CL		(10,"Club Lacrosse"),
	ClS		(11,"Club Softball"),
	CV		(12,"Club Volleyball"),
	CAC		(13,"Colleges Against Cancer"),
	CC		(14,"Commuter Club"),
	DE		(15,"Dance Excel"),
	DT		(16,"Dance Team"),
	E		(17,"Enactus"),
	EC		(18,"Equestrian Club"),
	GC		(19,"German Club"),
	GeC		(20,"Gerontology Club"),
	HfH		(21,"Habitat for Humanity"),
	H		(22,"Hillel"),
	HCS		(23,"Hispanic Cultural Society"),
	HaISPO	(24,"History and International Studies Professional Organization"),
	IH		(25,"Ice Hockey"),
	ICF		(26,"Inter-Varsity Christian Fellowship"),
	LLA		(27,"LAMBDA: LGBT Alliance"),
	NAfME	(28,"National Association for Music Educators"),
	NC		(29,"Newman Club"),
	PSN		(30,"Peer Support Network"),
	PLS		(31,"Pre-Law Society"),
	PMS		(32,"Pre-Medical Society"),
	PRSSoA	(33,"Public Relations Student Society of America"),
	PC		(34,"Psychology Club"),
	R		(35,"Rhapsody"),
	RPGC	(36,"Role Playing Games Club"),
	RT		(37,"Rugby Team"),
	SAA		(38,"Student Alumni Association"),
	SEA		(39,"Student Education Association"),
	SaOC	(40,"Ski and Outdoor Club"),
	SNAoP	(41,"Student Nurses Association of PA"),
	SMSA	(42,"Sport Management Student Association"),
	SS		(43,"Student Senate"),
	TSTYCN	(44,"The Spartan: The York College Newspaper"),
	UF		(45,"Ultimate Frisbee"),
	UC		(46,"Unity Club"),
	WTYCRS	(47,"WVYC: The York College Radio Station"),
	YFS		(48,"YCP Film Society"),
	YfL		(49,"YCP for Liberty"),
	YIT		(50,"YCP Improv Troupe"),
	YES		(51,"York Environmental Society"),
	YCCF	(52,"York College Conservative Forum"),
	O		(53,"Other");
	
	private final String title;
	private final int ID;
	
	//Reverse look up map for int into String
	private static final Map<Integer, Club> reverse = new HashMap<Integer, Club>();
	private static final Map<Integer, String> reverseString = new HashMap<Integer, String>();
	
	Club(String title, int ID){
		this.ID = ID;
		this.title = title;
	}
	
	Club(int ID, String title){
		this.ID = ID;
		this.title = title;
	}
	
	static {
		for(Club m : Club.values())
		{
			reverse.put(m.getID(), m);
		}
		for(Club m : Club.values())
		{
			reverseString.put(m.getID(), m.getTitle());
		}
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
	
	public Map<Integer, Club> getReverse(){
		return reverse;
	}
	public Map<Integer, String> getReverseString(){
		return reverseString;
	}
}
