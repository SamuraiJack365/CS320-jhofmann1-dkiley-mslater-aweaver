/**
 * 
 */
package xyz.jhofmann1.cs320.controller.main;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

import xyz.jhofmann1.cs320.model.main.Credentials;
/**
 * @author Jackson
 *
 */
public class LoginController {
	
	private PasswordHashingService encrypt;
	private ArrayList<Credentials> users;
	/**
	 * Constructor initiates arraylist of users then generates list of users
	 * this is temporary fake database
	 */
	public LoginController()
	{
		users = new ArrayList<Credentials>();
		generateUserTable();
	}
	
	/**
	 * Verifies the user entered the correct information
	 * @param username is the entered username
	 * @param password is the entered password
	 * @return true if the username matches a user in the database and the password matches the password for that user
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public boolean verifyUserData(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		//creates new encryption service
		encrypt = new PasswordHashingService();
		//sets return to default to false
		boolean result = false;
		
		//searches database for user data
		//will later search database for the specific user then check the password for just that user
		for(Credentials cred : users)
		{
			if(cred.getUsername().equalsIgnoreCase(username))
			{
				if(encrypt.checkPassword(password, cred.getHashedPassword()))
				{
					result = true;
				}
			}
		}
		return result;
	}
	
	/**
	 * Temporary implementation of a fake database
	 */
	private void generateUserTable()
	{
		for(int i = 0; i < 10; i++)
		{
			try {
				users.add(new Credentials("username"+i, "password"+i));
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//used only for junit, will be removed once database is implemented
	public ArrayList<Credentials> getUsers()
	{
		return users;
	}
	

}
