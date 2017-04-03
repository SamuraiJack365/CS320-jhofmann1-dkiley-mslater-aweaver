package xyz.jhofmann1.cs320.model.main;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

/**
 * 
 * @author jhofmann1
 *
 */
public class User {
	
	
	private Credentials cred;
	private Blob passwordStore;
	
	/**
	 * Constructor with default values, shouldn't really be used for anything but testing
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public User() throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		cred = new Credentials("username", "password");
		try {
			passwordStore = getBlobPassword(cred.getEncryptedPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		try {
			passwordStore = getBlobPassword(cred.getEncryptedPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public User(String username, Blob password)
	{
		passwordStore = password;
		try {
			cred = new Credentials(username, this.getBytePassword(password));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User(String username, byte[] password)
	{
		cred = new Credentials(username, password);
	}
	/**
	 * Converts Blob form of password to a byte array
	 * @param pass password as a Blob
	 * @return password as a byte array
	 * @throws SQLException
	 */
	private byte[] getBytePassword(Blob pass) throws SQLException
	{
		int blobLength = (int) pass.length();  
		byte[] blobAsBytes = pass.getBytes(1, blobLength);
		return blobAsBytes;
	}
	
	/**
	 * Converts byte array form of password to a Blob
	 * @param pass as a byte array
	 * @return password as a Blob
	 * @throws SerialException
	 * @throws SQLException
	 */
	private Blob getBlobPassword(byte[] pass) throws SerialException, SQLException
	{
		Blob blob = new javax.sql.rowset.serial.SerialBlob(pass);
		return blob;
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

	/**
	 * @return the password
	 */
	public byte[] getPassword() {
		return cred.getEncryptedPassword();
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(byte[] password) {
		cred.setEncryptedPassword(password);
	}

	/**
	 * @return the salt
	 */
	public byte[] getSalt() {
		return cred.getSalt();
	}

	/**
	 * @param salt the salt to set
	 */
	public void setSalt(byte[] salt) {
		cred.setSalt(salt);
	}

}
