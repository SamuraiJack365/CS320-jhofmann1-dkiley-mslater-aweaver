package xyz.jhofmann1.cs320.servlet.student;

import java.awt.List;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.jhofmann1.cs320.controller.student.StudentController;
import xyz.jhofmann1.cs320.database.studentsdb.persist.DerbyDatabase;
import xyz.jhofmann1.cs320.model.main.Club;
import xyz.jhofmann1.cs320.model.main.Major;
import xyz.jhofmann1.cs320.model.main.Minor;
import xyz.jhofmann1.cs320.model.main.Sport;
import xyz.jhofmann1.cs320.model.student.Student;
import xyz.jhofmann1.cs320.servlet.main.MasterServlet;
/**
 * @author Andy
 */
public class StudentHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) //SOMETHING IS NULL HERE AND I AM UPSET
			throws ServletException, IOException, NullPointerException {
		System.out.println("In the Student Home servlet"); //This doesn't display correctly
		if(req.getSession().getAttribute("loggedin") == null)
		{
			req.getSession().setAttribute("loggedin", false);
		}
		
		boolean loggedin = (boolean) req.getSession().getAttribute("loggedin");
		
		if(loggedin)
		{
			HashMap sport = (HashMap) Sport.BASE.getReverseString();
			sport.remove(0);
			req.setAttribute("sport", sport);
			HashMap club = (HashMap) Club.AC.getReverseString();
			club.remove(0);
			req.setAttribute("club", club);
			HashMap major = (HashMap) Major.AaDM.getReverseString();
			major.remove(0);
			req.setAttribute("major", major);
			HashMap minor = (HashMap) Minor.AAAS.getReverseString();
			minor.remove(0);
			req.setAttribute("minor", minor);
			
			DerbyDatabase data = new DerbyDatabase();
			Student model = data.findStudentByUsername((String) req.getSession().getAttribute("user")).get(0);
			
			req.setAttribute("firstName", model.getFirstName());
			req.setAttribute("lastName", model.getLastName());
			
			if(model.getMajors().length > 0 && model.getMajors()[0] != 0){
				req.setAttribute("major1title", (Major.AaDM.toString(model.getMajors()[0])));
				req.setAttribute("major1", ((model.getMajors()[0])));
				if(model.getMajors().length > 1 && model.getMajors()[1] != 0){
					req.setAttribute("major2title", (Major.AaDM.toString(model.getMajors()[1])));
					req.setAttribute("major2", ((model.getMajors()[1])));
				}
				else{
					req.setAttribute("major2title", "Second Major (Optional)");
					req.setAttribute("major2", "0");
				}
			} 
			else{
				req.setAttribute("major1title", "Major");
				req.setAttribute("major1", "0");
				req.setAttribute("major2title", "Second Major (Optional)");
				req.setAttribute("major2", "0");
			}
			if(model.getMinors().length > 0 && model.getMinors()[0] != 0){
				req.setAttribute("minor1title", (Minor.TEST.toString(model.getMinors()[0])));
				req.setAttribute("minor1", ((model.getMinors()[0])));
				if(model.getMinors().length > 1 && model.getMinors()[1] != 0){
					req.setAttribute("minor2title", (Minor.TEST.toString(model.getMinors()[1])));
					req.setAttribute("minor2", ((model.getMinors()[1])));
				}
				else{
					req.setAttribute("minor2title", "Second Minor (Optional)");
					req.setAttribute("minor2", "0");
				}
			} 
			else{
				req.setAttribute("minor1title", "First Minor (Optional)");
				req.setAttribute("minor1", "0");
				req.setAttribute("minor2title", "Second Minor (Optional)");
				req.setAttribute("minor2", "0");
			}
			if(model.getSports().length > 0 && model.getSports()[0] != 0){
				req.setAttribute("sport1title", (Sport.BASE.toString(model.getSports()[0])));
				req.setAttribute("sport1", ((model.getSports()[0])));
				if(model.getSports().length > 1 && model.getSports()[1] != 0){
					req.setAttribute("sport2title", (Sport.BASE.toString(model.getSports()[1])));
					req.setAttribute("sport2", ((model.getSports()[1])));
				}
				else{
					req.setAttribute("sport2title", "Second Sport (Optional)");
					req.setAttribute("sport2", "0");
				}
			} 
			else{
				req.setAttribute("sport1title", "First Sport (Optional)");
				req.setAttribute("sport1", "Sport");
				req.setAttribute("sport2title", "Second Sport (Optional)");
				req.setAttribute("sport2", "0");
			}
			if(model.getClubs().length > 0 && model.getClubs()[0] != 0){
				req.setAttribute("club1title", (Club.TEST.toString(model.getClubs()[0])));
				req.setAttribute("club1", ((model.getClubs()[0])));
				if(model.getClubs().length > 1 && model.getClubs()[1] != 0){
					req.setAttribute("club2title", (Club.TEST.toString(model.getClubs()[1])));
					req.setAttribute("club2", ((model.getClubs()[1])));
					if(model.getClubs().length > 2 && model.getClubs()[2] != 0){
						req.setAttribute("club3title", (Club.TEST.toString(model.getClubs()[2])));
						req.setAttribute("club3", ((model.getClubs()[2])));
					}
					else{
						req.setAttribute("club3title", "Third Club (Optional)");
						req.setAttribute("club3", "0");
					}	
				}
				else{
					req.setAttribute("club2title", "Second Club (Optional)");
					req.setAttribute("club2", "0");
					req.setAttribute("club3title", "Third Club (Optional)");
					req.setAttribute("club3", "0");
				}
			} 
			else{
				req.setAttribute("club1title", "First Club (Optional)");
				req.setAttribute("club1", "0");
				req.setAttribute("club2title", "Second Club (Optional)");
				req.setAttribute("club2", "0");
				req.setAttribute("club3title", "Third Club (Optional)");
				req.setAttribute("club3", "0");
			}
			req.setAttribute("gpa", model.getGPA());
			if(model.getAccolades() == null){
				req.setAttribute("honors", "Honors (100 characters or less)");
			}
			else{
				req.setAttribute("honors", model.getAccolades());
			}
			
			
			
			req.getRequestDispatcher("/_view/student/studentHome.jsp").forward(req, resp);
		}
		else
		{
			req.getSession().setAttribute("origin", "student");
			resp.sendRedirect(req.getContextPath() + "/login");
		}
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
				String firstName = getStringFromParameter(req.getParameter("firstName"));
				String lastName = getStringFromParameter(req.getParameter("lastName"));
				int major1 = getIntFromParameter(req.getParameter("major1"));
				int major2 = getIntFromParameter(req.getParameter("major2"));
				int minor1 = getIntFromParameter(req.getParameter("minor1"));
				int minor2 = getIntFromParameter(req.getParameter("minor2"));
				String honors = getStringFromParameter(req.getParameter("honors"));
				double gpa = getDoubleFromParameter(req.getParameter("gpa"));
				int sport1 = getIntFromParameter(req.getParameter("sport1"));
				int sport2 = getIntFromParameter(req.getParameter("sport2"));
				int club1 = getIntFromParameter(req.getParameter("club1"));
				int club2 = getIntFromParameter(req.getParameter("club2"));
				int club3 = getIntFromParameter(req.getParameter("club3"));
				Double layout = getDoubleFromParameter(req.getParameter("layout"));
				String accolades = getStringFromParameter(req.getParameter("honors"));
				
				/*
				if (firstName == null || lastName == null || major1 == null || "gpa" == null) {
					errorMessage = "Required fields are marked with a *";
				} else {
					StudentController controller = new StudentController();
					result = controller.addUser(firstName, lastName, major1);
				}
				*/
				
				DerbyDatabase data = new DerbyDatabase();
				Student model = data.findStudentByUsername((String) req.getSession().getAttribute("user")).get(0);
				int[] majors = {major1, major2};
				int[] minors = {minor1, minor2};
				int[] sports = {sport1, sport2};
				int[] clubs = {club1, club2, club3};
				ArrayList<Object> fields = new ArrayList<Object>();
				//studentID, accolades, majors, minors, activities, officer, studentIDNum, GPA, displayGPA, reviewed, approvalState
				fields.add(model.getUsername());
				if(accolades == null || accolades.equals("")){
					fields.add(model.getAccolades());
				} else {
					fields.add(accolades);
				}
				fields.add(majors);
				fields.add(minors);
				fields.add(sports);
				fields.add(clubs);
				fields.add(model.getStudentIDNum());
				if(gpa <= 0.00001 && gpa >= -0.00001){
					fields.add(model.getGPA());
				}else{
					fields.add(gpa);
				}
				fields.add(model.isDisplayGPA());
				fields.add(model.isReviewed());
				fields.add(model.getApprovalState());
				if(firstName == null || firstName.isEmpty()){
					fields.add(model.getFirstName());
				} else {
					fields.add(firstName);
				}
				if(lastName == null || lastName.isEmpty()){
					fields.add(model.getLastName());
				} else {
					fields.add(lastName);
				}
				
				for(int i = 0; i < fields.size(); i++){
					System.out.println(fields.get(i));
				}
				
				model = new Student((String) req.getSession().getAttribute("user"), model.getPassword(), fields);
				
				data.updateStudent(model);
				
				req.setAttribute("firstName", model.getFirstName());
				req.setAttribute("lastName", model.getLastName());
				
				if(model.getMajors().length > 0 && model.getMajors()[0] != 0){
					req.setAttribute("major1title", (Major.AaDM.toString(model.getMajors()[0])));
					req.setAttribute("major1", ((model.getMajors()[0])));
					if(model.getMajors().length > 1 && model.getMajors()[1] != 0){
						req.setAttribute("major2title", (Major.AaDM.toString(model.getMajors()[1])));
						req.setAttribute("major2", ((model.getMajors()[1])));
					}
					else{
						//System.out.println("Hell0!"); please ignore this line
						req.setAttribute("major2title", "Second Major (Optional)");
						req.setAttribute("major2", "0");
					}
				} 
				else{
					req.setAttribute("major1title", "Major");
					req.setAttribute("major1", "0");
					req.setAttribute("major2title", "Second Major (Optional)");
					req.setAttribute("major2", "0");
				}
				if(model.getMinors().length > 0 && model.getMinors()[0] != 0){
					req.setAttribute("minor1title", (Minor.TEST.toString(model.getMinors()[0])));
					req.setAttribute("minor1", ((model.getMinors()[0])));
					if(model.getMinors().length > 1 && model.getMinors()[1] != 0){
						req.setAttribute("minor2title", (Minor.TEST.toString(model.getMinors()[1])));
						req.setAttribute("minor2", ((model.getMinors()[1])));
					}
					else{
						req.setAttribute("minor2title", "Second Minor (Optional)");
						req.setAttribute("minor2", "0");
					}
				} 
				else{
					req.setAttribute("minor1title", "First Minor (Optional)");
					req.setAttribute("minor1", "0");
					req.setAttribute("minor2title", "Second Minor (Optional)");
					req.setAttribute("minor2", "0");
				}
				if(model.getSports().length > 0 && model.getSports()[0] != 0){
					req.setAttribute("sport1title", (Sport.BASE.toString(model.getSports()[0])));
					req.setAttribute("sport1", ((model.getSports()[0])));
					if(model.getSports().length > 1 && model.getSports()[1] != 0){
						req.setAttribute("sport2title", (Sport.BASE.toString(model.getSports()[1])));
						req.setAttribute("sport2", ((model.getSports()[1])));
					}
					else{
						req.setAttribute("sport2title", "Second Sport (Optional)");
						req.setAttribute("sport2", "0");
					}
				} 
				else{
					req.setAttribute("sport1title", "First Sport (Optional)");
					req.setAttribute("sport1", "Sport");
					req.setAttribute("sport2title", "Second Sport (Optional)");
					req.setAttribute("sport2", "0");
				}
				if(model.getClubs().length > 0 && model.getClubs()[0] != 0){
					req.setAttribute("club1title", (Club.TEST.toString(model.getClubs()[0])));
					req.setAttribute("club1", ((model.getClubs()[0])));
					if(model.getClubs().length > 1 && model.getClubs()[1] != 0){
						req.setAttribute("club2title", (Club.TEST.toString(model.getClubs()[1])));
						req.setAttribute("club2", ((model.getClubs()[1])));
						if(model.getClubs().length > 2 && model.getClubs()[2] != 0){
							req.setAttribute("club3title", (Club.TEST.toString(model.getClubs()[2])));
							req.setAttribute("club3", ((model.getClubs()[2])));
						}
						else{
							req.setAttribute("club3title", "Third Club (Optional)");
							req.setAttribute("club3", "0");
						}	
					}
					else{
						req.setAttribute("club2title", "Second Club (Optional)");
						req.setAttribute("club2", "0");
						req.setAttribute("club3title", "Third Club (Optional)");
						req.setAttribute("club3", "0");
					}
				} 
				else{
					req.setAttribute("club1title", "First Club (Optional)");
					req.setAttribute("club1", "0");
					req.setAttribute("club2title", "Second Club (Optional)");
					req.setAttribute("club2", "0");
					req.setAttribute("club3title", "Third Club (Optional)");
					req.setAttribute("club3", "0");
				}
				req.setAttribute("gpa", model.getGPA());
				if(model.getAccolades() == null){
					req.setAttribute("honors", "Honors (100 characters or less)");
				}
				else{
					req.setAttribute("honors", model.getAccolades());
				}
			} catch (NumberFormatException e) {
				errorMessage = "Invalid double";
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HashMap sport = (HashMap) Sport.BASE.getReverseString();
			sport.remove(0);
			req.setAttribute("sport", sport);
			HashMap club = (HashMap) Club.AC.getReverseString();
			club.remove(0);
			req.setAttribute("club", club);
			HashMap major = (HashMap) Major.AaDM.getReverseString();
			major.remove(0);
			req.setAttribute("major", major);
			HashMap minor = (HashMap) Minor.AAAS.getReverseString();
			minor.remove(0);
			req.setAttribute("minor", minor);
			
			
			// Add result objects as request attributes
			req.setAttribute("errorMessage", errorMessage);
			req.setAttribute("result", result);
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
			return 0.0;
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
	
	private int getIntFromParameter(String s) {
		if (s == null || s.equals("")) {
			return 0;
		} else {
			return Integer.parseInt(s);
		}
	}
}
