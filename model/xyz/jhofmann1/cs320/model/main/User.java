package xyz.jhofmann1.cs320.model.main;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * 
 * @author jhofmann1
 *
 */
public class User {
	
	/**
	 * String username the user's username
	 * byte[] password the user's encrypted password
	 * byte[] salt the user's salt value for the encrypted password
	 */
	private String username;
	private byte[] password, salt;
	
	public User() throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		username = "username";
		PasswordEncryptionService encrypt = new PasswordEncryptionService();
		salt = encrypt.generateSalt();
		password = encrypt.getEncryptedPassword("password", salt);
	}
	
	public User(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		this.username = username;
		PasswordEncryptionService encrypt = new PasswordEncryptionService();
		salt = encrypt.generateSalt();
		this.password = encrypt.getEncryptedPassword(password, salt);
	}
	public User(String username, byte[] password)
	{
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public byte[] getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(byte[] password) {
		this.password = password;
	}

	/**
	 * @return the salt
	 */
	public byte[] getSalt() {
		return salt;
	}

	/**
	 * @param salt the salt to set
	 */
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

}
