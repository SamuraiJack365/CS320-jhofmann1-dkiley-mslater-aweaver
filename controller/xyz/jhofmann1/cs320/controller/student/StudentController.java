package xyz.jhofmann1.cs320.controller.student;

import xyz.jhofmann1.cs320.model.student.Student;

public class StudentController {
	private Student model;
	
	public StudentController() {
		// Only exists remove errors in other classes
	}
	
	public StudentController(Student model) {
		this.model = model;
	}
	
	public double add(double first, double second, double third) {
		return first + second + third;
	}
	
	public double add(double first, double second) {
		return first + second;
	}
}
