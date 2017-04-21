package xyz.jhofmann1.cs320.servlet.student;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.jhofmann1.cs320.controller.main.LoginController;
import xyz.jhofmann1.cs320.controller.student.LayoutDemoController;
import xyz.jhofmann1.cs320.model.main.Major;
import xyz.jhofmann1.cs320.model.student.Student;
import xyz.jhofmann1.cs320.servlet.main.MasterServlet;

/**
 * @author Jackson
 *
 */
public class LayoutDemoServlet extends MasterServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("In the LayoutDemo servlet");
		checkLogged(req);
		boolean loggedin = (boolean) req.getSession().getAttribute("loggedin");
		if(loggedin)
		{
			LayoutDemoController controller = new LayoutDemoController();
			Student student = controller.getStudent(getStringFromParameter((String) req.getSession().getAttribute("user")));
			req.setAttribute("firstname", student.getStudentFirstName());
			req.setAttribute("lastname", student.getStudentLastName());
			req.setAttribute("major1", Major.CompSci.toString(student.getMajors()[0]));
			if(student.getMajors().length > 1)
			{
				req.setAttribute("major2", student.getMajors()[1]);
			}
			if(student.getMinors() != null)
			{
				switch(student.getMinors().length)
				{
					case 1:
						req.setAttribute("minor1", student.getMinors()[0]);
						break;
					case 2:
						req.setAttribute("minor1", student.getMinors()[0]);
						req.setAttribute("minor2", student.getMinors()[1]);
						break;
				}
			}
			System.out.println(req.getAttribute("minor1"));
			req.setAttribute("studentpic", student.getStudentPic());
			req.setAttribute("club", "Temp");
			req.getRequestDispatcher("/_view/layouts/layout1.jsp").forward(req, resp);
		}
		else
		{
			req.getSession().setAttribute("origin", "layouts");
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
	
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
			resp.sendRedirect(req.getContextPath() + "/home");
		}
	}
	

}
