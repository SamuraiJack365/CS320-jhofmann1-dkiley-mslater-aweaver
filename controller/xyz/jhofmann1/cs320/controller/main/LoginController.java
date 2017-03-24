/**
 * 
 */
package xyz.jhofmann1.cs320.controller.main;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import xyz.jhofmann1.cs320.model.main.Credentials;
import xyz.jhofmann1.cs320.model.main.PasswordEncryptionService;
/**
 * @author Jackson
 *
 */
public class LoginController {
	
	private String username = "username";
	private String password = "password";
	private PasswordEncryptionService encrypt;
	private Credentials cred;
	
	public boolean verifyUserData(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		encrypt = new PasswordEncryptionService();
		try {
			cred = new Credentials(this.username, this.password);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(password);
		boolean result = false;
		if(encrypt.authenticate(password, cred.getEncryptedPassword(), cred.getSalt()))
		{
			result = true;
		}
		return result;
	}

}
