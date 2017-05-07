package xyz.jhofmann1.cs320.database.studentsdb.persist;

import java.util.List;

import xyz.jhofmann1.cs320.model.main.User;
import xyz.jhofmann1.cs320.model.student.Student;

public interface IDatabase {
	public List<Student> findStudentByUsername(String username);
	public List<Student> firstFiveUnapprovedStudents(String advisorUsername);
	public List<Student> getAllStudents(String advisorUsername);
	public List<Student> getAllStudentsAwaitingApproval(String advisorUsername);
	public String getUserType(String username);
	public User getUserByUsername(String username);
	public void updateDatabaseApproveStudent(String username);
	public void updateDatabaseRejectStudent(String username);
}
