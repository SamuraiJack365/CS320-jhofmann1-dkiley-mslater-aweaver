/**
 * 
 */
package xyz.jhofmann1.cs320.servlet.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String first = getStringFromParameter(req.getParameter("username"));
		String second = getStringFromParameter(req.getParameter("password"));

		if (first == null || second == null) {
			errorMessage = "Please specify both username and password";
		} else {
			LoginController controller = new LoginController();
			result = controller.verifyUserData(first, second);
		}
		
		// Add parameters as request attributes
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("result", result);
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/main/login.jsp").forward(req, resp);
	}
	
	private String getStringFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return s;
		}
	}

}
