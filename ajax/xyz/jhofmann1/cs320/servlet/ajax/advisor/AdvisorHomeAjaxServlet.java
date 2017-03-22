package xyz.jhofmann1.cs320.servlet.ajax.advisor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.jhofmann1.cs320.controller.advisor.AdvisorHomeController;
import xyz.jhofmann1.cs320.model.advisor.AdvisorHome;

public class AdvisorHomeAjaxServlet extends HttpServlet {
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

	private void doRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Read client's model
//		Integer min = getInteger(req, "min");
//		Integer max = getInteger(req, "max");
//		
//		if (min == null || max == null) {
//			badRequest("Invalid min/max values", resp);
//			return;
//		}
		
		AdvisorHome model = new AdvisorHome();
		model.setNumStudents(5);
		
		// If an action was specified, use a GuessingGameController to carry it out
		String action = req.getParameter("action");
		if (action != null) {
			AdvisorHomeController controller = new AdvisorHomeController();
			controller.setModel(model);
			
//			if (action.equals("less")) {
//				controller.setNumberIsLessThanGuess();
//			} else if (action.equals("more")) {
//				controller.setNumberIsGreaterThanGuess();
//			}
		}
		
//		int guess = model.getGuess();
		
		// Send back updated model to client
		resp.setContentType("application/json");
		resp.getWriter().println(
				"{ \"min\": " + model.getNumStudents() + "}" );
	}

	private Integer getInteger(HttpServletRequest req, String name) {
		String val = req.getParameter(name);
		if (val == null) {
			return null;
		}
		try {
			return Integer.parseInt(val);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	private void badRequest(String message, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		resp.getWriter().println(message);
	}
}
