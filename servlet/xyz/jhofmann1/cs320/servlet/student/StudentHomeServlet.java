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
import xyz.jhofmann1.cs320.model.main.Sport;
import xyz.jhofmann1.cs320.servlet.main.MasterServlet;
/**
 * @author Andy
 */
public class StudentHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) //SOMETHING IS NULL HERE AND I AM UPSET
			throws ServletException, IOException, NullPointerException {
		System.out.println("WHY DOES THIS NOT WORK");
		System.out.println("In the Student Home servlet Yes"); //This doesn't display correctly
		if(req.getSession().getAttribute("loggedin") == null)
		{
			req.getSession().setAttribute("loggedin", false);
		}
		
		boolean loggedin = (boolean) req.getSession().getAttribute("loggedin");
		
		if(loggedin)
		{
			System.out.println("Logged In");
//			ArrayList<String> sport = new ArrayList<String>();
//			for(int i = 1; i < Sport.BASE.getReverse().size(); i++){
//				sport.add(Sport.BASE.toString(i));
//			} 
			HashMap sport = (HashMap) Sport.BASE.getReverseString();
			req.setAttribute("sport", sport);
			System.out.println("doGet set sport");
			req.getRequestDispatcher("/_view/student/studentHome.jsp").forward(req, resp);
		}
		else
		{
			System.out.println("Not Logged In");
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		
		System.out.println("I want this to say something");
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
				System.out.println("In Try for doPost");
				String firstName = getStringFromParameter(req.getParameter("firstName"));
				String lastName = getStringFromParameter(req.getParameter("lastName"));
				String majors = getStringFromParameter(req.getParameter("majors"));
				String minors = getStringFromParameter(req.getParameter("minors"));
				String honors = getStringFromParameter(req.getParameter("honors"));
				double gpa = getDoubleFromParameter(req.getParameter("gpa"));
				String sport1 = getStringFromParameter(req.getParameter("sport1"));
				String sport2 = getStringFromParameter(req.getParameter("sport2"));
				String clubs = getStringFromParameter(req.getParameter("clubs"));
				Double layout = getDoubleFromParameter(req.getParameter("layout"));
	
				if (firstName == null || lastName == null || majors == null || "gpa" == null) {
					errorMessage = "Required fields are marked with a *";
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
			
			ArrayList<String> sport = new ArrayList<String>();
			for(int i = 0; i < Sport.BASE.getReverse().size(); i++){
				sport.add(Sport.BASE.toString(i));
			}
			System.out.println("doPost set sport");
			
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
