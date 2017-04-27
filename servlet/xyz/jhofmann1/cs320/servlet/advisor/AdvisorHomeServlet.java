package xyz.jhofmann1.cs320.servlet.advisor;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

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
		Advisor model = null;
		try {
			model = new Advisor();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AdvisorHomeController controller = new AdvisorHomeController();
		controller.setModel(model);
		
		req.setAttribute("game", model);
		
		req.getRequestDispatcher("/_view/advisor/advisorHome.jsp").forward(req, resp);
	}

	private int getInteger(HttpServletRequest req, String name) {
		return Integer.parseInt(req.getParameter(name));
	}
}
