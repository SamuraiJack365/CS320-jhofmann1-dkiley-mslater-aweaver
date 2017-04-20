package xyz.jhofmann1.cs320.model.main;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import xyz.jhofmann1.cs320.controller.main.PasswordHashingService;

/**
 * 
 * @author jhofmann1
 *
 */
public class User {
	
	
	private Credentials cred;
	
	/**
	 * Constructor with default values, shouldn't really be used for anything but testing
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public User() throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		cred = new Credentials("username", "password");
	}
	
	/**
	 * Constructor with username and password that encrypts the password.
	 * @param username
	 * @param password
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public User(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		cred = new Credentials(username, password);
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return cred.getUsername();
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		cred.setUsername(username);
	}
	public String getPassword()
	{
		return cred.getHashedPassword();
	}
	public void setPasswordPlain(String password)
	{
		PasswordHashingService encrypt = new PasswordHashingService();
		password = encrypt.hashPassword(password);
		cred.setEncryptedPassword(password);
	}
	
	public void setPasswordHashed(String passsword)
	{
		cred.setEncryptedPassword(passsword);
	}

}
