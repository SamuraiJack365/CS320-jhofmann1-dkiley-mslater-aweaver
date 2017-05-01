package xyz.jhofmann1.cs320.model.main;

import java.util.HashMap;
import java.util.Map;

public enum Activity  implements EnumInter{ //54 Activities added, we should probably do a sweep and check if I missed some. I hope I didn't.
	TEST	(null, 0),
	AIGA 	("AIGA", 1),
	AC 		("Alpha Chi", 2),
	ACJA 	("American Criminal Justice Association", 3),
	BC 		("Biology Club", 4),
	CS		("Chemistry Society", 5),
	GC		("German Club", 6),
	GeC		("Gerontology Club", 7), //ARE THEY ACTIVE?
	HISPO	("History and International Studies Professional Organization", 8),
	NAfME	("National Association for Music Educators", 9),
	PMS		("Pre-Medical Society", 10),
	PLS		("Pre-Law Society", 11),
	PRSSA	("Public Relations Students Society of America", 12),
	PC		("Psychology Club", 13),
	SEA		("Student Education Association", 14),
	SNAP	("Student Nurses Association of PA", 15),
	SMSA	("Sports Management Student Association", 16),
	CB		("Club Baseball", 17),
	CSW		("Women's Club Softball", 18),
	EC		("Equestrian Club", 19),
	FC		("Frisbee Club", 20),
	ML		("Men's Lacrosse", 21),
	MR		("Men's Rugby", 22),
	MV		("Men's Volleyball", 23),
	WL		("Women's Lacrosse", 24),
	WR		("Women's Rugby", 25),
	HCS		("Hispanic Cultural Society", 26),
	LAMBDA	("Lambda, LGBT Alliance", 27),
	UC		("Unity Club", 28),
	TS		("The Spartian, The YCP Newspaper", 29),
	WVYC	("WVYC: York College Radio", 30),
	CFO		("Christian Fellowship Organization", 31),
	IVCF	("Inter-Varsity Christian Fellowship", 32),
	NC		("Newman Club", 33),
	H		("Hillel", 34),
	AnC		("Anime Club", 35),
	BB		("Best Buddies", 36),
	CAC		("Colleges Against Cancer", 37),
	CC		("Commuter Club", 38),
	YCCF	("York College Conservative Forum", 39),
	YCDT	("York College Dance Team", 40),
	DE		("Dance Excel", 41),
	YCPFS	("YCP Film Society", 42),
	HFH		("Habitat for Humanity", 43),
	YCPIT	("YCP Improv Troupe", 44),
	YCPFL	("YCP for Liberty", 45),
	PSN		("Peer Support Network", 46),
	YCPR	("Rhapsody", 47),
	RPGC	("York College Roleplaying Games Club", 48),
	SSA		("Student Alumni Association", 49),
	En		("Enactus", 50),
	SAOC	("Ski and Outdoor Club", 51),
	YES		("York Environmental Society", 52),
	CAB		("Campus Activities Board", 53),
	YCPSS	("Student Senate", 54)
	;
	
	private final String title;
	private final int ID;
	
	//reverse lookup map for int to String
	private static final Map<Integer, Activity> reverse = new HashMap<Integer, Activity>();
	
	static {
		for(Activity a : Activity.values()){
			reverse.put(a.getID(), a);
		}
	}
	
	Activity(String title, int ID){
		this.ID = ID;
		this.title = title;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	
	public String toString() {
		return title;
	}
	
	public String toString(int ID){
		return reverse.get(ID).getTitle();
	}
}
