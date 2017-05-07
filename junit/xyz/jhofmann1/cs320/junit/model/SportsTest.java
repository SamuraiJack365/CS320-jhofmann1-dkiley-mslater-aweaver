package xyz.jhofmann1.cs320.junit.model;

import static org.junit.Assert.*;

import org.junit.Test;

import xyz.jhofmann1.cs320.model.main.Sport;

public class SportsTest {

	@Test
	public void testAll(){
		assertEquals("Baseball",Sport.BASE.getTitle());
		assertEquals(1,Sport.BASE.getID());
		assertEquals("Basketball",Sport.BASKET.getTitle());
		assertEquals(2,Sport.BASKET.getID());
		assertEquals("Cross Country",Sport.CC.getTitle());
		assertEquals(3,Sport.CC.getID());
		assertEquals("Field Hockey",Sport.FH.getTitle());
		assertEquals(4,Sport.FH.getID());
		assertEquals("Golf",Sport.GOLF.getTitle());
		assertEquals(5,Sport.GOLF.getID());
		assertEquals("Lacrosse",Sport.LACROSSE.getTitle());
		assertEquals(6,Sport.LACROSSE.getID());
		assertEquals("Soccer",Sport.SOCCER.getTitle());
		assertEquals(7,Sport.SOCCER.getID());
		assertEquals("Softball",Sport.SOFT.getTitle());
		assertEquals(8,Sport.SOFT.getID());
		assertEquals("Swimming",Sport.SWIM.getTitle());
		assertEquals(9,Sport.SWIM.getID());
		assertEquals("Tennis",Sport.TENNIS.getTitle());
		assertEquals(10,Sport.TENNIS.getID());
		assertEquals("Track and Field",Sport.TF.getTitle());
		assertEquals(11,Sport.TF.getID());
		assertEquals("Volleyball",Sport.VOLLEY.getTitle());
		assertEquals(12,Sport.VOLLEY.getID());
		assertEquals("Wrestling",Sport.WWE.getTitle());
		assertEquals(13,Sport.WWE.getID());
	}
}
