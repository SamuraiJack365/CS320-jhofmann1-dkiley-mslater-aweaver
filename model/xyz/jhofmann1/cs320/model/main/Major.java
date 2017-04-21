package xyz.jhofmann1.cs320.model.main;

import java.util.HashMap;
import java.util.Map;
//random comment to push with
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
	CM		("Cybersecurity Management", 12),
	EEE		("Early Elementary Education", 13),
	EESE	("Early Elementary/Special Education", 14),
	Econ	("Economics", 15),
	EE		("Electrical Engineering", 16),
	EM		("Engineering Management", 17),
	Eng		("English", 18),
	EI		("Entrepreneurship and Innovation", 19),
	Fin		("Finance", 20),
	FA		("Fine Art", 21),
	FC		("Forensic Chemeistry", 22),
	GD		("Graphic Design", 23),
	Hist	("History", 24),
	HM		("Hospitality Management", 25),
	HRM		("Human Resource Management", 26),
	HS		("Human Services", 27),
	ITM		("Information Technology Management", 28),
	IA		("Intelligence Analysis", 29),
	IR		("Internation Relations", 30),
	LOD		("Leadership and Organizational Dynamics", 31),
	Market	("Marketing", 32),
	MC		("Mass Communications", 33),
	Math	("Mathematics", 34),
	ME		("Mechanical Engineering", 35),
	MLS		("Medical Lab Science", 36),
	MLE		("Middle Level Education", 37),
	MLSE	("Middle Level/Special Education", 38),
	Music	("Music", 39),
	MusicE	("Music Education", 40),
	MIRT	("Music Industry/Recording Technology", 41),
	NMT		("Nuclear Medicine Technology", 42),
	Nurse	("Nursing", 43),
	Philo	("Philosophy", 44),
	PS		("Political Science", 45),
	PW		("Professional Writing", 46),
	Pysch	("Pyschology", 47),
	PR		("Public Relations", 48),
	RBN		("RN to BS in Nursing", 49),
	Radio	("Radiography", 50),
	RLA		("Recreation and Leisure Administration", 51),
	RC		("Respiratory Care", 52),
	SEB		("Secondary Education Biology", 53),
	SEE		("Secondary Education English", 54),
	SEGS	("Secondary Education General Science", 55),
	SEM		("Secondary Education Mathematics", 56),
	SESS	("Secondary Education Social Studies", 57),
	SD		("Self-Designed", 58),
	SENM	("Social Enterprise and Not-for-Profit Management", 59),
	Soc		("Sociology", 60),
	SE		("Spanish Education", 61),
	Spanish	("Spanish/Español", 62),
	SM		("Sports Management", 63),
	SCOM	("Supply Chain Operations Management", 64),
	Theatre	("Theatre", 65),
	UB		("Undeclared Business", 66);
	
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
