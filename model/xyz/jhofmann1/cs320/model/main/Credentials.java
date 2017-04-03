package xyz.jhofmann1.cs320.model.main;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import xyz.jhofmann1.cs320.controller.main.PasswordEncryptionService;

/**
 * 
 * @author Jackson
 *
 */
public class Credentials {

	private byte[] encryptedPassword, salt;
	private String username;
	private PasswordEncryptionService encrypt;
	
	/**
	 * Constructor for credential storage
	 * @param username Username of user that will eventually be stored
	 * @param password password that will be hashed
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public Credentials(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		//initializes password service
		encrypt = new PasswordEncryptionService();
		//generates a salt for the password so two passwords wont hash to the same value
		salt = encrypt.generateSalt();
		
		//hashes the password and sets it to the encryptedPasswordField
		encryptedPassword = encrypt.getEncryptedPassword(password, salt);
		this.username = username;
	}

	public Credentials(String username, byte[] password) {
		this.username = username;
		this.encryptedPassword = password;
	}

	/**
	 * Getter for the hashed password
	 * @return the hashed password as a byte array
	 */
	public byte[] getEncryptedPassword() {
		return encryptedPassword;
	}

	/**
	 * Getter for the user's salt
	 * @return the user's salt as a byte array
	 */
	public byte[] getSalt() {
		return salt;
	}
 
	/**
	 * Getter for the user's username
	 * @return the user's username as a String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param encryptedPassword the encryptedPassword to set
	 */
	public void setEncryptedPassword(byte[] encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	/**
	 * @param salt the salt to set
	 */
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
