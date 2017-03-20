package xyz.jhofmann1.cs320.junit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import xyz.jhofmann1.cs320.model.advisor.AdvisorHome;

public class AdvisorHomeTest {
	private AdvisorHome model;
	
	@Before
	public void setUp() {
		model = new AdvisorHome();
		model.setNumStudents(50);
		model.createFirstNameList();
		model.createLastNameList();
		model.createEmailList();
		model.createIDList();
	}
	
	@Test
	public void testSetNumStudents() {
		assertEquals(50, model.getNumStudents());
	}
	@Test
	public void testCreateFirstNameList()
	{
		//firstname
		assertEquals("Joe0", model.getFirstName(0));
		assertEquals("Joe12", model.getFirstName(12));
		assertEquals("Joe49", model.getFirstName(49));
		
	}
	@Test
	public void testCreateLastNameList()
	{
		//lastname
		assertEquals("Smith3", model.getLastName(3));
		assertEquals("Smith2", model.getLastName(2));
		assertEquals("Smith17", model.getLastName(17));
 	}
	@Test
	public void testCreateEmailList()
	{

		//emails
		assertEquals("Smith4@ycp.edu", model.getEmail(4));
		assertEquals("Smith6@ycp.edu", model.getEmail(6));
		assertEquals("Smith27@ycp.edu", model.getEmail(27));
	}
	
	@Test
	public void testCreateIDList()
	{
		//ids
		assertEquals(0, model.getID(0));
		assertEquals(12, model.getID(12));
		assertEquals(49, model.getID(49));
	}
}
