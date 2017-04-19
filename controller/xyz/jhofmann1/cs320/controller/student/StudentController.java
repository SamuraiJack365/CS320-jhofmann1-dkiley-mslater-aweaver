package xyz.jhofmann1.cs320.controller.student;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

import xyz.jhofmann1.cs320.model.main.Credentials;
import xyz.jhofmann1.cs320.model.student.Student;

/**
 * @author Andy
 */
public class StudentController {
	private Student model;
	private ArrayList<Credentials> users;
	
	public StudentController() {
		
	}
	
	@SuppressWarnings("finally")
	public boolean addUser(String firstName, String lastName, String majors){
		try{
			users.add(new Credentials("firstName", "lastName"));
			return true;
		} finally {
			return false;
		}	
		
	}
	
	/**
	 * 
	 * @param model, sets the model
	 * generates a temporary table
	 */
	public void setModel(Student model) {
		this.model = model;
		generateUserTable();
	}
	
	/**
	 * temporary table generator
	 */
	private void generateUserTable()
	{
		for(int i = 0; i < 10; i++)
		{
			try {
				users.add(new Credentials("firstName"+i, "lastName"+i));
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * temporary return for junit tests, removed once database is implemented
	 */
		public ArrayList<Credentials> getUsers()
		{
			return users;
		}
	
	public void uploadPics(){
		
	}

	
	public void uploadVideo(){
		
	}

	public void uploadAudio(){
	
	}
}
