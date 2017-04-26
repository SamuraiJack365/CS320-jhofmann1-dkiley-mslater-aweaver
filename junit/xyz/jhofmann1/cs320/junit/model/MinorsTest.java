package xyz.jhofmann1.cs320.junit.model;

import static org.junit.Assert.*;

import org.junit.Test;

import xyz.jhofmann1.cs320.model.main.Minor;

public class MinorsTest {

	@Test
	public void testAll(){
		assertEquals("Advertising",Minor.Adv.getTitle());
		assertEquals(1,Minor.Adv.getID());
		assertEquals("African and African-American Studies",Minor.AAAS.getTitle());
		assertEquals(2,Minor.AAAS.getID());
		assertEquals("American History",Minor.AH.getTitle());
		assertEquals(3,Minor.AH.getID());
		assertEquals("Anthropology",Minor.Anthro.getTitle());
		assertEquals(4,Minor.Anthro.getID());
		assertEquals("Applied Youth Development",Minor.AYD.getTitle());
		assertEquals(5,Minor.AYD.getID());
		assertEquals("Art History",Minor.ArtHist.getTitle());
		assertEquals(6,Minor.ArtHist.getID());
		assertEquals("Art Administration",Minor.ArtAdmin.getTitle());
		assertEquals(7,Minor.ArtAdmin.getID());
		assertEquals("Athletic Coaching",Minor.AC.getTitle());
		assertEquals(8,Minor.AC.getID());
		assertEquals("Continuous Improvement",Minor.CI.getTitle());
		assertEquals(9,Minor.CI.getID());
		assertEquals("Creative Writing",Minor.CW.getTitle());
		assertEquals(10,Minor.CW.getID());
		assertEquals("Criminalistics",Minor.C.getTitle());
		assertEquals(11,Minor.C.getID());
		assertEquals("Critical Thinking and Theory",Minor.CTT.getTitle());
		assertEquals(12,Minor.CTT.getID());
		assertEquals("Entrepeneurship",Minor.Entre.getTitle());
		assertEquals(13,Minor.Entre.getID());
		assertEquals("Ethics",Minor.Ethics.getTitle());
		assertEquals(14,Minor.Ethics.getID());
		assertEquals("Film Studies",Minor.FS.getTitle());
		assertEquals(15,Minor.FS.getID());
		assertEquals("French",Minor.Fr.getTitle());
		assertEquals(16,Minor.Fr.getID());
		assertEquals("Geography",Minor.Geo.getTitle());
		assertEquals(17,Minor.Geo.getID());
		assertEquals("German",Minor.Ger.getTitle());
		assertEquals(18,Minor.Ger.getID());
		assertEquals("Gerontology",Minor.Geron.getTitle());
		assertEquals(19,Minor.Geron.getID());
		assertEquals("Hospitality Marketing",Minor.HM.getTitle());
		assertEquals(20,Minor.HM.getID());
		assertEquals("Human Resource Management",Minor.HRM.getTitle());
		assertEquals(21,Minor.HRM.getID());
		assertEquals("Information Systems",Minor.IS.getTitle());
		assertEquals(22,Minor.IS.getID());
		assertEquals("International Business",Minor.IB.getTitle());
		assertEquals(23,Minor.IB.getID());
		assertEquals("International Management",Minor.IM.getTitle());
		assertEquals(24,Minor.IM.getID());
		assertEquals("Legal Studies",Minor.LeS.getTitle());
		assertEquals(25,Minor.LeS.getID());
		assertEquals("Literary Studies",Minor.LiS.getTitle());
		assertEquals(26,Minor.LiS.getID());
		assertEquals("Management",Minor.M.getTitle());
		assertEquals(27,Minor.M.getID());
		assertEquals("Marketing Communications",Minor.MC.getTitle());
		assertEquals(28,Minor.MC.getID());
		assertEquals("Marketing Management",Minor.MM.getTitle());
		assertEquals(29,Minor.MM.getID());
		assertEquals("Mathematics",Minor.Math.getTitle());
		assertEquals(30,Minor.Math.getID());
		assertEquals("Music Theatre",Minor.MT.getTitle());
		assertEquals(31,Minor.MT.getID());
		assertEquals("Not-For-Profit Management",Minor.NFPM.getTitle());
		assertEquals(32,Minor.NFPM.getID());
		assertEquals("Operations Management",Minor.OM.getTitle());
		assertEquals(33,Minor.OM.getID());
		assertEquals("Outdoor Leadership",Minor.OL.getTitle());
		assertEquals(34,Minor.OL.getID());
		assertEquals("Photography",Minor.Photo.getTitle());
		assertEquals(35,Minor.Photo.getID());
		assertEquals("Physics",Minor.Physics.getTitle());
		assertEquals(36,Minor.Physics.getID());
		assertEquals("Public Administration",Minor.PA.getTitle());
		assertEquals(37,Minor.PA.getID());
		assertEquals("Religious Studies",Minor.RS.getTitle());
		assertEquals(38,Minor.RS.getID());
		assertEquals("Retailing",Minor.R.getTitle());
		assertEquals(39,Minor.R.getID());
		assertEquals("Speech Communication",Minor.SC.getTitle());
		assertEquals(40,Minor.SC.getID());
		assertEquals("Sustainability and Environmental Studies",Minor.SES.getTitle());
		assertEquals(41,Minor.SES.getID());
		assertEquals("Visual Communication",Minor.VC.getTitle());
		assertEquals(42,Minor.VC.getID());
		assertEquals("Women's and Gender Studies",Minor.SWaG.getTitle());
		assertEquals(43,Minor.SWaG.getID());
		assertEquals("World History",Minor.WH.getTitle());
		assertEquals(44,Minor.WH.getID());
	}
}
