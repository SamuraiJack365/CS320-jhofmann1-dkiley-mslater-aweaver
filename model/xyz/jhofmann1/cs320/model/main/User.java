package xyz.jhofmann1.cs320.model.main;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import xyz.jhofmann1.cs320.controller.main.PasswordEncryptionService;

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
	private Blob passwordStore;
	
	public User() throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		username = "username";
		PasswordEncryptionService encrypt = new PasswordEncryptionService();
		salt = encrypt.generateSalt();
		password = encrypt.getEncryptedPassword("password", salt);
		try {
			passwordStore = getBlobPassword(password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public User(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		this.username = username;
		PasswordEncryptionService encrypt = new PasswordEncryptionService();
		salt = encrypt.generateSalt();
		this.password = encrypt.getEncryptedPassword(password, salt);
		try {
			passwordStore = getBlobPassword(this.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public User(String username, byte[] password)
	{
		this.username = username;
		this.password = password;
		try {
			passwordStore = getBlobPassword(password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public User(String username, Blob password)
	{
		this.username = username;
		passwordStore = password;
		try {
			this.password = getBytePassword(password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private byte[] getBytePassword(Blob pass) throws SQLException
	{
		int blobLength = (int) pass.length();  
		byte[] blobAsBytes = pass.getBytes(1, blobLength);
		return blobAsBytes;
	}
	private Blob getBlobPassword(byte[] pass) throws SerialException, SQLException
	{
		Blob blob = new javax.sql.rowset.serial.SerialBlob(pass);
		return blob;
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
