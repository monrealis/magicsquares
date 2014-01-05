package eu.vytenis.magicsq;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class FinderTest {

	private static Finder finder;
	
	@BeforeClass
	public static void before() {
		finder = new Finder();
		finder.find();		
	}
	
	@Test
	public void findCountSucceeds() {
		assertEquals(8, finder.getCount());
	}

}
