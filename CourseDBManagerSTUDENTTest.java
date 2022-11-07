import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManagerSTUDENTTest {
	private CourseDBManagerInterface dataMgr; 
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	@Test
	public void testShowAll() {
		//testing to see if they are in order of crn
		dataMgr.add("CMSC203",11111,4,"SC450","Joey Bag-O-Donuts");
		dataMgr.add("CMSC203",11111,4,"SC450","Jill B. Who-Dunit");// sub the priv object (same cnr)
		dataMgr.add("CMSC204",22222,4,"SC450","BillyBob Jones");
		ArrayList<String> list = dataMgr.showAll();
	 	assertEquals(list.get(0), "Course:CMSC203 CRN:11111 Credits:4 Instructor:Jill B. Who-Dunit Room:SC450");
		assertEquals(list.get(1), "Course:CMSC204 CRN:22222 Credits:4 Instructor:BillyBob Jones Room:SC450");
	 	
	}

}
