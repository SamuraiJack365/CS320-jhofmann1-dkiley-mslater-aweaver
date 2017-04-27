package xyz.jhofmann1.cs320.database.studentsdb.persist;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import xyz.jhofmann1.cs320.model.student.Student;
import xyz.jhofmann1.cs320.database.studentsdb.model.StudentAdvisor;
import xyz.jhofmann1.cs320.model.advisor.Advisor;
import xyz.jhofmann1.cs320.model.main.Credentials;
import xyz.jhofmann1.cs320.model.main.User;
import xyz.jhofmann1.cs320.model.main.Activity;
import xyz.jhofmann1.cs320.model.main.Major;
import xyz.jhofmann1.cs320.model.main.Minor;
import xyz.jhofmann1.cs320.model.main.Sport;

public class InitialData {
	
	public static Major[] getMajors() {
		return Major.values();
	}
	
	public static Minor[] getMinors() {
		return Minor.values();
	}
	
	public static Sport[] getSports() {
		return Sport.values();
	}
	
	public static Activity[] getClubs() {
		return Activity.values();		
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
				Advisor advisor = null;
				try {
					advisor = new Advisor();
				} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// read author ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file				
				Integer.parseInt(i.next());
				// auto-generate author ID, instead
				advisor.setUserID(advisorId);	
				advisor.setFirstName(i.next());
				advisor.setLastName(i.next());
				advisor.setUsername(i.next());
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
					student.setFirstName(i.next());
					student.setLastName(i.next());
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
