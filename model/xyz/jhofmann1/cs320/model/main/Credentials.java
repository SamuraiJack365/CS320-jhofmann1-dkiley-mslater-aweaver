package xyz.jhofmann1.cs320.model.main;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Credentials {

	private byte[] encryptedPassword, salt;
	private String username;
	private PasswordEncryptionService encrypt;
	
	public Credentials(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		encrypt = new PasswordEncryptionService();
		salt = encrypt.generateSalt();
		
		encryptedPassword = encrypt.getEncryptedPassword(password, salt);
		this.username = username;
	}

	public byte[] getEncryptedPassword() {
		return encryptedPassword;
	}

	public byte[] getSalt() {
		return salt;
	}

	public String getUsername() {
		return username;
	}

}
