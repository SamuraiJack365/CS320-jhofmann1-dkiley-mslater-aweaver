package xyz.jhofmann1.cs320.junit.controller;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.Before;
import org.junit.Test;

import xyz.jhofmann1.cs320.controller.main.LoginController;
import xyz.jhofmann1.cs320.controller.main.PasswordEncryptionService;

public class LoginControllerTest {

	private LoginController login;
	
	@Before
	public void setUp()
	{
		login = new LoginController();
	}
	
	@Test
	public void testVerifyUserData()
	{
		try {
			assertFalse(login.verifyUserData("username", "p@ssword"));
			assertFalse(login.verifyUserData("username", "p@sswo"));
			assertTrue(login.verifyUserData("username1", "password1"));
			assertFalse(login.verifyUserData("username1", "password"));
			assertFalse(login.verifyUserData("username", "password1"));
			assertFalse(login.verifyUserData("username1", "password0"));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGenerateUserTable() throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		PasswordEncryptionService encrypt = new PasswordEncryptionService();
		assertEquals(login.getUsers().get(0).getUsername(), "username0");
		assertTrue(encrypt.authenticate("password0", login.getUsers().get(0).getEncryptedPassword(), login.getUsers().get(0).getSalt()));
		assertEquals(login.getUsers().get(9).getUsername(), "username9");
		assertTrue(encrypt.authenticate("password9", login.getUsers().get(9).getEncryptedPassword(), login.getUsers().get(9).getSalt()));
	}

}
