package xyz.jhofmann1.cs320.controller.advisor;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import xyz.jhofmann1.cs320.database.studentsdb.persist.DatabaseProvider;
import xyz.jhofmann1.cs320.database.studentsdb.persist.DerbyDatabase;
import xyz.jhofmann1.cs320.database.studentsdb.persist.IDatabase;
import xyz.jhofmann1.cs320.model.advisor.Advisor;
import xyz.jhofmann1.cs320.model.student.Student;

//Controller for the advisor home page
public class AdvisorHomeController {
	
	private IDatabase db = null;
	
	public AdvisorHomeController() {
		
		//creating database instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	public Queue<Student> getFiveUnnaprovedStudents(String advisorUsername) {
		
		//get list of students from database
		List<Student> studentsList = db.firstFiveUnapprovedStudents(advisorUsername);
		Queue<Student> firstFiveStudentsList = null;
		
		if (studentsList.isEmpty()) {
			System.out.println("No students found for advisor <" + advisorUsername + ">");
		}
		else {
			firstFiveStudentsList = new LinkedList<Student>();
			int i = 0;
			for (Student student : studentsList) {
				if (i == 5) {
					break;
				}
				else {
					firstFiveStudentsList.add(student);
					i++;
				}
			}
		}
		
		//return the first five students for the advisor
		return firstFiveStudentsList;
		
	}
	
	public void approveStudent(String studentUsername) {
		db.updateDatabaseApproveStudent(studentUsername);
	}

	public void rejectStudent(String studentUsername) {
		db.updateDatabaseRejectStudent(studentUsername);
	}
}