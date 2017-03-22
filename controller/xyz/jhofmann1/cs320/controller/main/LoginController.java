/**
 * 
 */
package xyz.jhofmann1.cs320.controller.main;

/**
 * @author Jackson
 *
 */
public class LoginController {
	String username = "user";
	String password = "pass";
	public boolean verifyUserData(String username, String password)
	{
		boolean result = false;
		if(username.equals(this.username) && password.equals(this.password))
		{
			result = true;
		}
		return result;
	}

}
