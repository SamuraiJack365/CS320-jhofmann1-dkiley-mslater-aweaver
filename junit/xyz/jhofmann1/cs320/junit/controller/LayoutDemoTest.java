package xyz.jhofmann1.cs320.junit.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import xyz.jhofmann1.cs320.controller.student.LayoutDemoController;
import xyz.jhofmann1.cs320.model.student.Student;

public class LayoutDemoTest {

	private LayoutDemoController demo;
	@Before
	public void setUp()
	{
		demo = new LayoutDemoController();
	}
	
	@Test
	public void testKnownUser() {
		Student student = demo.getStudent("jhofmann1");
		assertEquals("Jack", student.getFirstName());
		assertEquals("Hofmann", student.getLastName());
		
	}
	
	@Test
	public void testKnownBadUser()
	{
		Student student = demo.getStudent("derp");
		assertNull(student);
	}

}
