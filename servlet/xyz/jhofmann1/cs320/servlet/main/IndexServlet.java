package xyz.jhofmann1.cs320.servlet.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndexServlet extends MasterServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("In the Index servlet");
		checkLogged(req);
		req.getRequestDispatcher("/_view/main/index.jsp").forward(req, resp);
	}
}
