package xyz.jhofmann1.cs320.servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.jhofmann1.cs320.controller.student.StudentController;
/**
 * @author Andy
 */
public class StudentHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("In the Student Home servlet");
		boolean loggedin = (boolean) req.getSession().getAttribute("loggedin");
		if(loggedin)
		{
		req.getRequestDispatcher("/_view/student/studentHome.jsp").forward(req, resp);
		}
		else
		{
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Decode form parameters and dispatch to controller
		String errorMessage = null;
		boolean result = false;
		if(req.getSession().getAttribute("loggedin").equals(true))
		{
			try {
				String firstName = getStringFromParameter(req.getParameter("firstName"));
				String lastName = getStringFromParameter(req.getParameter("lastName"));
				String majors = getStringFromParameter(req.getParameter("majors"));
				String minors = getStringFromParameter(req.getParameter("minors"));
				String honors = getStringFromParameter(req.getParameter("honors"));
				double gpa = getDoubleFromParameter(req.getParameter("gpa"));
				String sports = getStringFromParameter(req.getParameter("sports"));
				String clubs = getStringFromParameter(req.getParameter("clubs"));
				Double layout = getDoubleFromParameter(req.getParameter("layout"));
	
				if (firstName == null || lastName == null || majors == null || "gpa" == null) {
					errorMessage = "Rquired fields are marked with a *";
				} else {
					StudentController controller = new StudentController();
					result = controller.addUser(firstName, lastName, majors);
				}
			} catch (NumberFormatException e) {
				errorMessage = "Invalid double";
			}
			
			// Add parameters as request attributes
			req.setAttribute("firstName", req.getParameter("firstName"));
			req.setAttribute("lastName", req.getParameter("lastName"));
			req.setAttribute("majors", req.getParameter("majors"));
			req.setAttribute("gpa", req.getParameter("gpa"));
			if("minors" != null){		req.setAttribute("minors", req.getParameter("minors"));}
			if("honors" != null){		req.setAttribute("honors", req.getParameter("honors"));}
			if("sports" != null){		req.setAttribute("sports", req.getParameter("sports"));}
			if("clubs" != null){		req.setAttribute("clubs", req.getParameter("clubs"));}
			
			// Add result objects as request attributes
			req.setAttribute("errorMessage", errorMessage);
			req.setAttribute("result", result);
			
			// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/student/StudentHome.jsp").forward(req, resp);
		}
		else
		{
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	private Double getDoubleFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return Double.parseDouble(s);
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
