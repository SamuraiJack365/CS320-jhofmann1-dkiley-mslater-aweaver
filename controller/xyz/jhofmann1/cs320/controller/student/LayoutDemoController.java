package xyz.jhofmann1.cs320.controller.student;

import java.util.List;

import xyz.jhofmann1.cs320.database.studentsdb.persist.DatabaseProvider;
import xyz.jhofmann1.cs320.database.studentsdb.persist.DerbyDatabase;
import xyz.jhofmann1.cs320.database.studentsdb.persist.IDatabase;
import xyz.jhofmann1.cs320.model.student.Student;

public class LayoutDemoController {
	
	private Student student;

	public LayoutDemoController()
	{
		
	}
	
	public Student getStudent(String username)
	{
		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance(); 
		List<Student> studentList = db.findStudentByUsername(username);
		if(studentList.isEmpty())
		{
			student = null;
		}
		else if(studentList.size() > 1)
		{
			System.out.println("More than one student found?");
		}
		else
		{
			student = studentList.get(0);
		}
		
		
		return student;
	}
}
