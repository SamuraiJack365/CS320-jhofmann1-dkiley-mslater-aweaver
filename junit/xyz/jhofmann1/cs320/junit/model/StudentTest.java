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
		majors = new int[3]; majors[0] = 1; majors[2] = 7;
		minors = new int[3]; minors[0] = 8;
		activities = new int[4];
		
		fields = new ArrayList<Object>();
		fields.add("903589175");
		fields.add("GOOD STUDENT");
		
		model = new Student("Username", "Password", fields);
	}
}
