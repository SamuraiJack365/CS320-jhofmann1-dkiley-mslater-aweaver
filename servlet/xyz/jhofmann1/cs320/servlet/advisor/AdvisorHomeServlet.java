package xyz.jhofmann1.cs320.servlet.advisor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.jhofmann1.cs320.controller.advisor.AdvisorHomeController;
import xyz.jhofmann1.cs320.model.advisor.Advisor;

public class AdvisorHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("In the Advisor Home servlet");
		
		req.getRequestDispatcher("/_view/advisor/advisorHome.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Advisor model = new Advisor();

		AdvisorHomeController controller = new AdvisorHomeController();
		controller.setModel(model);
		
		if (req.getParameter("startGame") != null) {
			controller.startGame();
		} else {
			//
			Integer numStu = getInteger(req, "min");
			
			model.setNumStudents(numStu);

			if (req.getParameter("gotIt") != null) {
				controller.setNumStudents();
			} else {
				throw new ServletException("Unknown command");
			}
		}
		
		req.setAttribute("game", model);
		
		req.getRequestDispatcher("/_view/advisor/advisorHome.jsp").forward(req, resp);
	}

	private int getInteger(HttpServletRequest req, String name) {
		return Integer.parseInt(req.getParameter(name));
	}
}
