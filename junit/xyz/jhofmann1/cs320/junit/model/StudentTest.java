package xyz.jhofmann1.cs320.junit.model;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import xyz.jhofmann1.cs320.model.student.Student;

public class StudentTest {
	private Student model;
	private ArrayList<Object> fields;
	private int[] majors;
	private int[] minors;
	private int[] activities;
	private int[] officer;
	
	@Before
	public void setUp() throws NoSuchAlgorithmException, InvalidKeySpecException{
		//studentID, accolades, majors, minors, activities, officer, studentIDNum, 
		//GPA, displayGPA, reviewed, approvalState
		majors = new int[3]; majors[0] = 1; majors[2] = 7;
		minors = new int[3]; minors[0] = 8;
		activities = new int[4];
		activities[0] = 12;
		activities[1] = 16;
		
		officer = new int[4];
		officer[1] = 3;
		
		fields = new ArrayList<Object>();
		fields.add("903589175");
		fields.add("GOOD STUDENT");
		fields.add(majors);
		fields.add(minors);
		fields.add(activities);
		fields.add(officer);
		fields.add(16);
		fields.add(2.54);
		fields.add(true);
		fields.add(false);
		fields.add(1);
		fields.add("jsmith@ycp.edu");
		fields.add("Joe");
		fields.add("Smith");
		
		System.out.println(fields);
		
		model = new Student("Username", "Password", fields);
	}
	
	public void testGetters() {
		assertEquals("903589175",model.getStudentID());
		assertEquals("GOOD STUDENT",model.getAccolades());
		assertEquals(majors,model.getMajors());
		assertEquals(minors,model.getMinors());
		assertEquals(activities,model.getActivities());
		assertEquals(officer,model.getOfficer());
		assertEquals(16,model.getStudentIDNum());
		assertEquals(true,model.isDisplayGPA());
		assertEquals(false,model.isReviewed());
		assertEquals("jsmith@ycp.edu",model.getEmail());
		assertEquals("Joe",model.getStudentFirstName());
		assertEquals("Smith",model.getStudentLastName());
	}
}
