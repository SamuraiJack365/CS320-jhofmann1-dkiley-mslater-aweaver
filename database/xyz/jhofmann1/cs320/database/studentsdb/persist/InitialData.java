package xyz.jhofmann1.cs320.database.studentsdb.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import xyz.jhofmann1.cs320.database.studentsdb.model.Student;
import xyz.jhofmann1.cs320.database.studentsdb.model.Major;
import xyz.jhofmann1.cs320.database.studentsdb.model.Minor;

public class InitialData {
	// reads initial Author data from CSV file and returns a List of Authors
	public static List<Student> getStudents() throws IOException {
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
				Integer.parseInt(i.next());
				// auto-generate author ID, instead
				student.setId(studentId++);	
				student.setYcpId(Integer.parseInt(i.next()));
				student.setFirstName(i.next());
				student.setLastName(i.next());
				student.setMajor(Integer.parseInt(i.next()));
				student.setPicture(i.next());
				student.setSport(Integer.parseInt(i.next()));
				student.setClub(Integer.parseInt(i.next()));
				student.setGPA(Double.parseDouble(i.next()));
				student.setDisplayGPA(Boolean.parseBoolean(i.next()));
				student.setIsReviewed(Boolean.parseBoolean(i.next()));
				studentList.add(student);
			}
			System.out.println("studentList loaded from CSV file");
			return studentList;
		} finally {
			readStudents.close();
		}
	}
	
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
			System.out.println("majorList loaded from CSV file");
			return minorList;
		} finally {
			readMinors.close();
		}
	}
}
