package xyz.jhofmann1.cs320.servlet.main;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Jackson
 *
 */
public class MasterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	protected void checkLogged(HttpServletRequest req)
	{
		if(req.getSession().getAttribute("loggedin") == null)
		{
			req.getSession().setAttribute("loggedin", false);
		}
	}
	
	protected String getStringFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return s;
		}
	}
	

}
