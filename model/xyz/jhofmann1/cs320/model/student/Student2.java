package xyz.jhofmann1.cs320.model.student;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Blob;

import xyz.jhofmann1.cs320.model.main.User;

public class Student2 extends User {

	public Student2() throws NoSuchAlgorithmException, InvalidKeySpecException {
		// TODO Auto-generated constructor stub
	}

	public Student2(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	public Student2(String username, byte[] password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	public Student2(String username, Blob password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

}
