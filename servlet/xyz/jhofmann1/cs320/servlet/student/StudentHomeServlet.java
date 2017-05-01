package xyz.jhofmann1.cs320.servlet.student;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.jhofmann1.cs320.controller.student.StudentController;
import xyz.jhofmann1.cs320.database.studentsdb.persist.DerbyDatabase;
import xyz.jhofmann1.cs320.model.main.Club;
import xyz.jhofmann1.cs320.model.main.Major;
import xyz.jhofmann1.cs320.model.main.Minor;
import xyz.jhofmann1.cs320.model.main.Sport;
import xyz.jhofmann1.cs320.model.student.Student;
import xyz.jhofmann1.cs320.servlet.main.MasterServlet;
/**
 * @author Andy
 */
public class StudentHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) //SOMETHING IS NULL HERE AND I AM UPSET
			throws ServletException, IOException, NullPointerException {
		System.out.println("In the Student Home servlet"); //This doesn't display correctly
		if(req.getSession().getAttribute("loggedin") == null)
		{
			req.getSession().setAttribute("loggedin", false);
		}
		
		boolean loggedin = (boolean) req.getSession().getAttribute("loggedin");
		
		if(loggedin)
		{
			HashMap sport = (HashMap) Sport.BASE.getReverseString();
			req.setAttribute("sport", sport);
			HashMap club = (HashMap) Club.AC.getReverseString();
			req.setAttribute("club", club);
			HashMap major = (HashMap) Major.AaDM.getReverseString();
			req.setAttribute("major", major);
			HashMap minor = (HashMap) Minor.AAAS.getReverseString();
			req.setAttribute("minor", minor);
			
			DerbyDatabase data = new DerbyDatabase();
			Student model = data.findStudentByUsername((String) req.getSession().getAttribute("user")).get(0);
			
			req.setAttribute("firstName", model.getFirstName());
			req.setAttribute("lastName", model.getLastName());
			
			req.getRequestDispatcher("/_view/student/studentHome.jsp").forward(req, resp);
		}
		else
		{
			req.getSession().setAttribute("origin", "student");
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
				String major1 = getStringFromParameter(req.getParameter("major1"));
				String major2 = getStringFromParameter(req.getParameter("major2"));
				String minor1 = getStringFromParameter(req.getParameter("minor1"));
				String minor2 = getStringFromParameter(req.getParameter("minor2"));
				String honors = getStringFromParameter(req.getParameter("honors"));
				double gpa = getDoubleFromParameter(req.getParameter("gpa"));
				String sport1 = getStringFromParameter(req.getParameter("sport1"));
				String sport2 = getStringFromParameter(req.getParameter("sport2"));
				String club1 = getStringFromParameter(req.getParameter("club1"));
				String club2 = getStringFromParameter(req.getParameter("club2"));
				String club3 = getStringFromParameter(req.getParameter("club3"));
				Double layout = getDoubleFromParameter(req.getParameter("layout"));
	
				if (firstName == null || lastName == null || major1 == null || "gpa" == null) {
					errorMessage = "Required fields are marked with a *";
				} else {
					StudentController controller = new StudentController();
					result = controller.addUser(firstName, lastName, major1);
				}
			} catch (NumberFormatException e) {
				errorMessage = "Invalid double";
			}
			
			// Add parameters as request attributes
			req.setAttribute("firstName", req.getParameter("firstName"));
			req.setAttribute("lastName", req.getParameter("lastName"));
			req.setAttribute("major1", req.getParameter("major1"));
			req.setAttribute("gpa", req.getParameter("gpa"));
			if("minors" != null){		req.setAttribute("minors", req.getParameter("minors"));}
			if("honors" != null){		req.setAttribute("honors", req.getParameter("honors"));}
			if("sports" != null){		req.setAttribute("sports", req.getParameter("sports"));}
			if("clubs" != null){		req.setAttribute("clubs", req.getParameter("clubs"));}
			
			HashMap sport = (HashMap) Sport.BASE.getReverseString();
			req.setAttribute("sport", sport);
			HashMap club = (HashMap) Club.AC.getReverseString();
			req.setAttribute("club", club);
			HashMap major = (HashMap) Major.AaDM.getReverseString();
			req.setAttribute("major", major);
			HashMap minor = (HashMap) Minor.AAAS.getReverseString();
			req.setAttribute("minor", minor);
			
			// Add result objects as request attributes
			req.setAttribute("errorMessage", errorMessage);
			req.setAttribute("result", result);
			req.setAttribute("sport", sport);
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
