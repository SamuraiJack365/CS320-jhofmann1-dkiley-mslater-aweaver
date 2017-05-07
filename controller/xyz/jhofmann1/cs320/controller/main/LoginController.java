/**
 * 
 */
package xyz.jhofmann1.cs320.controller.main;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

import xyz.jhofmann1.cs320.database.studentsdb.persist.DatabaseProvider;
import xyz.jhofmann1.cs320.database.studentsdb.persist.DerbyDatabase;
import xyz.jhofmann1.cs320.database.studentsdb.persist.IDatabase;
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
		
		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance();
		if(encrypt.checkPassword(password, db.getUserByUsername(username).getCred().getHashedPassword()))
		{
			result = true;
		}
		return result;
	}
	

}
