package xyz.jhofmann1.cs320.servlet.ajax.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.jhofmann1.cs320.controller.student.StudentController;

public class StudentHomeAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}

	private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get parameters
		String firstName = getString(req, "firstName");
		String lastName = getString(req, "lastName");
		String majors = getString(req, "majors");
		double gpa = getDouble(req, "gpa");
		
		// Check whether parameters are valid
		if (firstName == null || lastName == null || majors == null) {
			badRequest("Bad parameters", resp);
			return;
		}
		
		// Use a controller to process the request
		StudentController controller = new StudentController();
		boolean result = controller.addUser(firstName, lastName, majors);
		
		// Send back a response
		resp.setContentType("text/plain");
		resp.getWriter().println(result);
	}

	private Double getDouble(HttpServletRequest req, String name) {
		String val = req.getParameter(name);
		if (val == null) {
			return null;
		}
		try {
			return Double.parseDouble(val);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	private String getString(HttpServletRequest req, String name) {
		String val = req.getParameter(name);
		if (val == null || val == "") {
			return null;
		}else{
			return name;
		}
		
	}

	private void badRequest(String message, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		resp.getWriter().println(message);
	}
}
