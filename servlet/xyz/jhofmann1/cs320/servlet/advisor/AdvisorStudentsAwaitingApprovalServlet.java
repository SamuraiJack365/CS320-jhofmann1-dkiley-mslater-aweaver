package xyz.jhofmann1.cs320.servlet.advisor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.jhofmann1.cs320.controller.advisor.AdvisorAllStudentsController;
import xyz.jhofmann1.cs320.controller.advisor.AdvisorStudentsAwaitingApprovalController;
import xyz.jhofmann1.cs320.database.studentsdb.persist.DatabaseProvider;
import xyz.jhofmann1.cs320.database.studentsdb.persist.DerbyDatabase;
import xyz.jhofmann1.cs320.database.studentsdb.persist.IDatabase;
import xyz.jhofmann1.cs320.model.student.Student;

public class AdvisorStudentsAwaitingApprovalServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	private AdvisorStudentsAwaitingApprovalController controller = null;

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
		
		controller = new AdvisorStudentsAwaitingApprovalController();
		
		students = controller.getAllStudents(user);
		
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
		
		req.getRequestDispatcher("/_view/advisor/advisorStudentsAwaitingApproval.jsp").forward(req, resp);
	}
	
	protected void previewStudent(String studentUsername)
	{
		System.out.println(studentUsername + " Preview");
	}
	
	//approve the student in the database and set reviewed to true
	protected void approveStudent(String studentUsername)
	{
		controller.approveStudent(studentUsername);
	}
	
	//reject the student in the database and set reviewed to true
	protected void rejectStudent(String studentUsername)
	{
		controller.rejectStudent(studentUsername);
	}
}
