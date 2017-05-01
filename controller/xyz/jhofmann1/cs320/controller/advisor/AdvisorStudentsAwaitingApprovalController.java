package xyz.jhofmann1.cs320.controller.advisor;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import xyz.jhofmann1.cs320.database.studentsdb.persist.DatabaseProvider;
import xyz.jhofmann1.cs320.database.studentsdb.persist.DerbyDatabase;
import xyz.jhofmann1.cs320.database.studentsdb.persist.IDatabase;
import xyz.jhofmann1.cs320.model.student.Student;

public class AdvisorStudentsAwaitingApprovalController {

private IDatabase db = null;
	
	public AdvisorStudentsAwaitingApprovalController() {
		
		//creating database instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	public Queue<Student> getAllStudents(String advisorUsername) {
		
		//get list of students from database
		List<Student> studentsList = db.getAllStudents(advisorUsername);
		Queue<Student> allStudents = null;
		
		if (studentsList.isEmpty()) {
			System.out.println("No students found for advisor <" + advisorUsername + ">");
		}
		else {
			allStudents = new LinkedList<Student>();
			
			for (Student student : studentsList) {
				allStudents.add(student);
			}
		}
		
		//return all of the students for the advisor
		return allStudents;
		
	}
}
