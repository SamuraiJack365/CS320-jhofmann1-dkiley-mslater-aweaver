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
import xyz.jhofmann1.cs320.model.main.Activity;
import xyz.jhofmann1.cs320.model.main.Club;
import xyz.jhofmann1.cs320.model.main.EnumInter;
import xyz.jhofmann1.cs320.model.main.Major;
import xyz.jhofmann1.cs320.model.main.Minor;
import xyz.jhofmann1.cs320.model.main.Officer;
import xyz.jhofmann1.cs320.model.main.Sport;
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
		String showLayout = (req.getParameter("layout") != null ? req.getParameter("layout") : "1");
		if(loggedin)
		{
			System.out.println(showLayout);
			LayoutDemoController controller = new LayoutDemoController();
			Student student = controller.getStudent(getStringFromParameter((String) req.getSession().getAttribute("user")));
//			System.out.println(student.getStudentIDNum());
//			System.out.println(student.getMajors()[0]);
//			System.out.println(student.getMajors()[1]);
//			System.out.println(student.getMajors()[2]);
//			System.out.println(student.getMinors()[0]);
//			System.out.println(student.getMinors()[1]);
//			System.out.println(student.getMinors()[2]);
//			System.out.println(student.getSports()[0]);
//			System.out.println(student.getSports()[1]);
//			System.out.println(student.getClubs()[0]);
//			System.out.println(student.getClubs()[1]);
//			System.out.println(student.getApprovalState());
//			System.out.println(student.isDisplayGPA());
//			System.out.println(student.isReviewed());
//			System.out.println(student.getStudentPic());
			req.setAttribute("firstname", student.getFirstName());
			req.setAttribute("lastname", student.getLastName());
			req.setAttribute("majors", this.getList(student.getMajors(), Major.AaDM));
			req.setAttribute("minors", this.getList(student.getMinors(), Minor.AAAS));
			req.setAttribute("offices", this.getList(student.getOfficer(), Officer.MEMBER));
			req.setAttribute("clubs", this.getList(student.getClubs(), Activity.AC));
			req.setAttribute("sports", this.getList(student.getSports(), Sport.BASE));
			req.setAttribute("GPA", student.getGPA());
			req.setAttribute("isGPA", student.isDisplayGPA());
			req.setAttribute("accolades", student.getAccolades());
			req.setAttribute("studentpic", student.getStudentPic());
			req.getRequestDispatcher("/_view/layouts/layout" + showLayout+".jsp").forward(req, resp);
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
	
	private String[] getList(int[] list, EnumInter enumeration)
	{
		String[] list2 = new String[list.length];
		
		for(int i = 0; i < list.length; i++)
		{
			list2[i] = enumeration.toString(list[i]);
		}
		return list2;
	}
	

}
