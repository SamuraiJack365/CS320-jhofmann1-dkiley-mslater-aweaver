package xyz.jhofmann1.cs320.junit.controller;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.Before;
import org.junit.Test;

import xyz.jhofmann1.cs320.controller.main.LoginController;

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
			assertTrue(login.verifyUserData("username", "password"));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
