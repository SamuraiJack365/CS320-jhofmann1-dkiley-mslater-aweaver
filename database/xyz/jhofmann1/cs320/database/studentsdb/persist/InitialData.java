package xyz.jhofmann1.cs320.database.studentsdb.persist;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import xyz.jhofmann1.cs320.model.student.Student;
import xyz.jhofmann1.cs320.database.studentsdb.model.StudentAdvisor;
import xyz.jhofmann1.cs320.database.studentsdb.model.Advisor;
import xyz.jhofmann1.cs320.model.main.Credentials;
import xyz.jhofmann1.cs320.model.main.User;
import xyz.jhofmann1.cs320.database.studentsdb.model.Club;
import xyz.jhofmann1.cs320.database.studentsdb.model.Major;
import xyz.jhofmann1.cs320.database.studentsdb.model.Minor;
import xyz.jhofmann1.cs320.database.studentsdb.model.Sport;

public class InitialData {
	
	public static List<Major> getMajors() throws IOException {
		List<Major> majorList = new ArrayList<Major>();
		ReadCSV readMajors = new ReadCSV("majors.csv");
		try {
			// auto-generated primary key for authors table
			Integer majorId = 1;
			while (true) {
				List<String> tuple = readMajors.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Major major = new Major();

				// read author ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file				
				Integer.parseInt(i.next());
				// auto-generate author ID, instead
				major.setMajorId(majorId++);	
				major.setMajor(i.next());
				majorList.add(major);
			}
			System.out.println("majorList loaded from CSV file");
			return majorList;
		} finally {
			readMajors.close();
		}
	}
	
	public static List<Minor> getMinors() throws IOException {
		List<Minor> minorList = new ArrayList<Minor>();
		ReadCSV readMinors = new ReadCSV("minors.csv");
		try {
			// auto-generated primary key for authors table
			Integer minorId = 1;
			while (true) {
				List<String> tuple = readMinors.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Minor minor = new Minor();

				// read author ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file				
				Integer.parseInt(i.next());
				// auto-generate author ID, instead
				minor.setMinorId(minorId++);	
				minor.setMinor(i.next());
				minorList.add(minor);
			}
			System.out.println("minorList loaded from CSV file");
			return minorList;
		} finally {
			readMinors.close();
		}
	}
	
	public static List<Sport> getSports() throws IOException {
		List<Sport> sportList = new ArrayList<Sport>();
		ReadCSV readSports = new ReadCSV("sports.csv");
		try {
			// auto-generated primary key for authors table
			Integer sportId = 1;
			while (true) {
				List<String> tuple = readSports.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Sport sport = new Sport();

				// read author ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file				
				Integer.parseInt(i.next());
				// auto-generate author ID, instead
				sport.setSportId(sportId++);	
				sport.setSport(i.next());
				sportList.add(sport);
			}
			System.out.println("sportList loaded from CSV file");
			return sportList;
		} finally {
			readSports.close();
		}
	}
	
	public static List<Club> getClubs() throws IOException {
		List<Club> clubList = new ArrayList<Club>();
		ReadCSV readClubs = new ReadCSV("clubs.csv");
		try {
			// auto-generated primary key for authors table
			Integer clubId = 1;
			while (true) {
				List<String> tuple = readClubs.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Club club = new Club();

				// read author ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file				
				Integer.parseInt(i.next());
				// auto-generate author ID, instead
				club.setClubId(clubId++);	
				club.setClub(i.next());
				clubList.add(club);
			}
			System.out.println("clubList loaded from CSV file");
			return clubList;
		} finally {
			readClubs.close();
		}
	}
	
	public static List<Credentials> getUsers() throws IOException {
		System.out.println("Hashing passwords...");
		List<Credentials> userList = new ArrayList<Credentials>();
		ReadCSV readUsers = new ReadCSV("users.csv");
		try {
			while (true) {
				List<String> tuple = readUsers.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();

				// read author ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file			
				try {
					String username = i.next();
					String password = i.next();
					userList.add(new Credentials(username, password));
				} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("userList loaded from CSV file");
			return userList;
		} finally {
			readUsers.close();
		}
	}
	
	public static List<Advisor> getAdvisors() throws IOException {
		List<Advisor> advisorList = new ArrayList<Advisor>();
		ReadCSV readAdvisors = new ReadCSV("advisors.csv");
		try {
			// auto-generated primary key for authors table
			Integer advisorId = 1;
			while (true) {
				List<String> tuple = readAdvisors.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Advisor advisor = new Advisor();

				// read author ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file				
				Integer.parseInt(i.next());
				// auto-generate author ID, instead
				advisor.setAdvisorId(advisorId);	
				advisor.setFirstName(i.next());
				advisor.setLastName(i.next());
				advisor.setUserName(i.next());
				advisorList.add(advisor);
			}
			System.out.println("advisorList loaded from CSV file");
			return advisorList;
		} finally {
			readAdvisors.close();
		}
	}
	
	// reads initial Author data from CSV file and returns a List of Authors
		public static List<Student> getStudents() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
			List<Student> studentList = new ArrayList<Student>();
			ReadCSV readStudents = new ReadCSV("students.csv");
			try {
				// auto-generated primary key for authors table
				Integer studentId = 1;
				while (true) {
					List<String> tuple = readStudents.next();
					if (tuple == null) {
						break;
					}
					Iterator<String> i = tuple.iterator();
					Student student = new Student();

					// read author ID from CSV file, but don't use it
					// it's there for reference purposes, just make sure that it is correct
					// when setting up the BookAuthors CSV file		
					// auto-generate author ID, instead
					
					i.next();
					student.setStudentIDNum(Integer.parseInt(i.next()));
					student.setUsername(i.next());
					student.setStudentFirstName(i.next());
					student.setStudentLastName(i.next());
					student.setMajors(new int[]{Integer.parseInt(i.next())});
					student.setStudentPic(i.next());
					student.setClubs(new int[] {Integer.parseInt(i.next())});
					student.setSports(new int[] {Integer.parseInt(i.next())});
					student.setGPA(Double.parseDouble(i.next()));
					student.setDisplayGPA(Boolean.parseBoolean(i.next()));
					student.setApprovalState(Boolean.parseBoolean(i.next()));
					studentList.add(student);
				}
				System.out.println("studentList loaded from CSV file");
				return studentList;
			} finally {
				readStudents.close();
			}
		}
		
		public static List<StudentAdvisor> getStudentAdvisors() throws IOException {
			List<StudentAdvisor> studentAdvisorList = new ArrayList<StudentAdvisor>();
			ReadCSV readStudentAdvisors = new ReadCSV("studentAdvisors.csv");
			try {
				while (true) {
					List<String> tuple = readStudentAdvisors.next();
					if (tuple == null) {
						break;
					}
					Iterator<String> i = tuple.iterator();
					StudentAdvisor studentAdvisor = new StudentAdvisor();
		
					studentAdvisor.setStudentId(Integer.parseInt(i.next()));
					studentAdvisor.setAdvisorId(Integer.parseInt(i.next()));
					studentAdvisorList.add(studentAdvisor);
				}
				System.out.println("studentAdvisorList loaded from CSV file");
				return studentAdvisorList;
			} finally {
				readStudentAdvisors.close();
			}
		}
}
