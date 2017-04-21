/**
 * 
 */
package xyz.jhofmann1.cs320.servlet.main;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.jhofmann1.cs320.controller.main.LoginController;

/**
 * @author Jackson
 *
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("In the Login servlet");
		
		req.getRequestDispatcher("/_view/main/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Decode form parameters and dispatch to controller
		String errorMessage = null;
		boolean result = false;
		String username = getStringFromParameter(req.getParameter("username"));
		String password = getStringFromParameter(req.getParameter("password"));

		if (username == null || password == null) {
			errorMessage = "Please specify both username and password";
		} else {
			LoginController controller = new LoginController();
			try {
				result = controller.verifyUserData(username, password);
				req.setAttribute("result", result);
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Add parameters as request attributes
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		//bad username or password directs to the login page again
		if (!result) {
			// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/main/login.jsp").forward(req, resp);
		}
		//good username and password directs to the home page
		else
		{
			req.getSession().setAttribute("loggedin", true);
			req.getSession().setAttribute("user", username);
			// Forward to view to render the result HTML document
			if(req.getSession().getAttribute("origin") == null)
			{
				resp.sendRedirect(req.getContextPath() + "/home");
			}
			else
			{
				resp.sendRedirect(req.getContextPath() + "/" + req.getSession().getAttribute("origin"));
			}
		}
	}
	
	private String getStringFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return s;
		}
	}

}
