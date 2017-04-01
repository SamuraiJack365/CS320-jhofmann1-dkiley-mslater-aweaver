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
	
	private PasswordEncryptionService encrypt;
	private ArrayList<Credentials> users;
	
	public LoginController()
	{
		users = new ArrayList<Credentials>();
		generateUserTable();
	}
	public boolean verifyUserData(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		encrypt = new PasswordEncryptionService();
		boolean result = false;
		for(Credentials cred : users)
		{
			if(cred.getUsername().equalsIgnoreCase(username))
			{
				if(encrypt.authenticate(password, cred.getEncryptedPassword(), cred.getSalt()))
				{
					result = true;
				}
			}
		}
		return result;
	}
	
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
	

}
