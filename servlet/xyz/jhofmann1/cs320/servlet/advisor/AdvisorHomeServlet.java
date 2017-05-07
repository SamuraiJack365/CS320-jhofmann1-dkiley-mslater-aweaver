package xyz.jhofmann1.cs320.servlet.advisor;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.jhofmann1.cs320.controller.advisor.AdvisorHomeController;
import xyz.jhofmann1.cs320.model.advisor.Advisor;
import xyz.jhofmann1.cs320.model.student.Student;

public class AdvisorHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdvisorHomeController controller = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String user = (String) req.getSession().getAttribute("user");
		if (user == null) {
			System.out.println("   User: <" + user + "> not logged in or session timed out");
			
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		System.out.println("In the Advisor Home servlet");
		
		Queue<Student> students = null;
		Student student = null;
		String errorMessage = null;
		
		controller = new AdvisorHomeController();
		
		students = controller.getFiveUnnaprovedStudents(user);
		
		if (students == null) {
			errorMessage = "No students were found";
		}
		else {
			student  = students.peek();
		}
		
		// Add objects as request attributes
		req.setAttribute("advisor_username", user);
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("student",   student);
		req.setAttribute("students",  students);
		
		req.getRequestDispatcher("/_view/advisor/advisorHome.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String user = (String) req.getSession().getAttribute("user");
		if (user == null) {
			System.out.println("   User: <" + user + "> not logged in or session timed out");
			
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		System.out.println("In the Advisor Home servlet");
		
		Queue<Student> students = null;
		Student student = null;
		String errorMessage = null;
		
		controller = new AdvisorHomeController();
		
		students = controller.getFiveUnnaprovedStudents(user);
		
		if (students == null) {
			errorMessage = "No students were found";
		}
		else {
			student  = students.peek();
		}
		
		// Add objects as request attributes
		req.setAttribute("advisor_username", user);
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("student",   student);
		req.setAttribute("students",  students);
		
		req.getRequestDispatcher("/_view/advisor/advisorHome.jsp").forward(req, resp);
		String studentUsername = (String) req.getParameter("studentSelect");
		switch((String)req.getParameter("studentOption"))
		{
		case "preview":
			previewStudent(studentUsername);
			break;
		case "approve":
			approveStudent(studentUsername);
			break;
		case "reject":
			rejectStudent(studentUsername);
			break;
		}
	}
	protected void previewStudent(String studentUsername)
	{
		System.out.println(studentUsername + " Preview");
	}
	
	protected void approveStudent(String studentUsername)
	{
		System.out.println(studentUsername + " approve");
	}
	
	protected void rejectStudent(String studentUsername)
	{
		System.out.println(studentUsername + " reject");
	}
}
