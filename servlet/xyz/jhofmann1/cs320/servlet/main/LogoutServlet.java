/**
 * 
 */
package xyz.jhofmann1.cs320.servlet.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jackson
 *
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("In the Logout servlet");
		req.getSession().setAttribute("loggedin", false);
		req.getSession().setAttribute("user", null);
		resp.sendRedirect(req.getContextPath() + "/home");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			req.getSession().setAttribute("loggedin", false);
			req.getSession().setAttribute("user", null);
			resp.sendRedirect(req.getContextPath() + "/home");
	}

}
