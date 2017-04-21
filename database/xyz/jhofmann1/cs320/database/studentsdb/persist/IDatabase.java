package xyz.jhofmann1.cs320.database.studentsdb.persist;

import java.util.List;

import xyz.jhofmann1.cs320.model.student.Student;

public interface IDatabase {
	public List<Student> findStudentByUsername(String username);
}
