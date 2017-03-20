package xyz.jhofmann1.cs320.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.jhofmann1.cs320.controller.GuessingGameController;
import xyz.jhofmann1.cs320.model.GuessingGame;

public class GuessingGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/guessingGame.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		GuessingGame model = new GuessingGame();

		GuessingGameController controller = new GuessingGameController();
		controller.setModel(model);
		
		if (req.getParameter("startGame") != null) {
			controller.startGame();
		} else {
			// Reconstruct current GuessingGame model object
			Integer curMin = getInteger(req, "min");
			Integer curMax = getInteger(req, "max");
			
			model.setMin(curMin);
			model.setMax(curMax);

			if (req.getParameter("gotIt") != null) {
				controller.setNumberFound();
			} else if (req.getParameter("less") != null) {
				controller.setNumberIsLessThanGuess();
			} else if (req.getParameter("more") != null) {
				controller.setNumberIsGreaterThanGuess();
			} else {
				throw new ServletException("Unknown command");
			}
		}
		
		req.setAttribute("game", model);
		
		req.getRequestDispatcher("/_view/guessingGame.jsp").forward(req, resp);
	}

	private int getInteger(HttpServletRequest req, String name) {
		return Integer.parseInt(req.getParameter(name));
	}
}
