package xyz.jhofmann1.cs320.servlet.advisor;

import java.io.IOException;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.jhofmann1.cs320.controller.advisor.AdvisorAllStudentsController;
import xyz.jhofmann1.cs320.model.student.Student;

public class AdvisorAllStudentsServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	private AdvisorAllStudentsController controller = null;

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
		
		controller = new AdvisorAllStudentsController();
		
		students = controller.getAllStudents(user);
		
		if (students == null) {
			errorMessage = "No students were found";
		}
		else {
			student  = students.poll();
		}
		
		// Add objects as request attributes
		req.setAttribute("advisor_username", user);
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("student",   student);
		req.setAttribute("students",  students);
		
		req.getRequestDispatcher("/_view/advisor/advisorAllStudents.jsp").forward(req, resp);
	}
}
