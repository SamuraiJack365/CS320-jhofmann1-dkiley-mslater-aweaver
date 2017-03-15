package xyz.jhofmann1.cs320.junit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import xyz.jhofmann1.cs320.model.GuessingGame;

public class GuessingGameTest {
	private GuessingGame model;
	
	@Before
	public void setUp() {
		model = new GuessingGame();
	}
	
	@Test
	public void testSetMin() {
		model.setMin(1);
		assertEquals(1, model.getMin());
	}
	@Test
	public void testSetMax() {
		model.setMax(100);
		assertEquals(100, model.getMax());
	}
	@Test
	public void testIsDone()
	{
		model.setMax(100);
		model.setMin(1);
		assertEquals(false, model.isDone());
		model.setMax(50);
		model.setMin(50);
		assertEquals(true, model.isDone());
	}
	@Test
	public void testGetGuess()
	{
		model.setMax(100);
		model.setMin(1);
		assertEquals(50, model.getGuess());
		model.setMax(75);
		assertEquals(38, model.getGuess());
		model.setMin(12);
		assertEquals(43, model.getGuess());
	}
}
