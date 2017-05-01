package xyz.jhofmann1.cs320.model.main;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import xyz.jhofmann1.cs320.controller.main.PasswordHashingService;

/**
 * 
 * @author Jackson
 *
 */
public class Credentials {

	String hashededPassword;
	private String username;
	private PasswordHashingService encrypt;
	
	/**
	 * Constructor for credential storage
	 * @param username Username of user that will eventually be stored
	 * @param password password that will be hashed
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public Credentials(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		//initializes password service
		encrypt = new PasswordHashingService();
		
		//hashes the password and sets it to the encryptedPasswordField
		hashededPassword = encrypt.hashPassword(password);
		this.username = username;
	}
	
	public Credentials() throws NoSuchAlgorithmException, InvalidKeySpecException {
		
	}

	/**
	 * Getter for the hashed password
	 * @return the hashed password as a byte array
	 */
	public String getHashedPassword() {
		return hashededPassword;
	}
 
	/**
	 * Getter for the user's username
	 * @return the user's username as a String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param hashedPassword the hashededPassword to set
	 */
	public void setHashedPassword(String hashedPassword) {
		this.hashededPassword = hashedPassword;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
