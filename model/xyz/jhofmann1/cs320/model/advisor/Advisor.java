package xyz.jhofmann1.cs320.model.advisor;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;	
import java.util.LinkedList; 
import java.util.Queue;

import xyz.jhofmann1.cs320.model.main.User;
import xyz.jhofmann1.cs320.model.student.Student;

public class Advisor extends User{

	Queue<Student> studentQueue;
	ArrayList<Student> studentList;
	public Advisor() throws NoSuchAlgorithmException, InvalidKeySpecException {
		super();
		studentQueue = new LinkedList<Student>();
		studentList = new ArrayList<Student>();
	}
	
	public Advisor(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		super(username, password);
		studentQueue = new LinkedList<Student>();
		studentList = new ArrayList<Student>();
	}
	
	public Advisor(String username, String password, Queue studentQueue) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		super(username, password);
		this.studentQueue = studentQueue;
		studentList = new ArrayList<Student>();
	}
	
	public Advisor(String username, String password, Queue studentQueue, ArrayList<Student> studentList) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		super(username, password);
		this.studentQueue = studentQueue;
		this.studentList = studentList;
	}
	
	public Advisor(String username, String password, ArrayList<Student> studentList) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		super(username, password);
		this.studentQueue = new LinkedList<Student>();
		this.studentList = studentList;
	}
	
	
}