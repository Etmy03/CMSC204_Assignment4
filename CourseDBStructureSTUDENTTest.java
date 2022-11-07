import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBStructureSTUDENTTest {
	CourseDBStructure cds;
	CourseDBElement cde1 ,cde2 ,cde3;
	@Before
	public void setUp() throws Exception {
		cds = new CourseDBStructure(19);
		cde1 = cde2 =new CourseDBElement("CMSC203", 39009, 4, "SC100", "Nobody InParticular");
		cde3 = new CourseDBElement("CMSC207", 38705, 4, "SC100", "Nobody InParticular");
		cds.add(cde1);
		cds.add(cde2);
		cds.add(cde3);
	}

	@After
	public void tearDown() throws Exception {
		cds = null;
	}

	@Test
	public void testAdd() throws IOException {
		CourseDBElement cds4 =new CourseDBElement("CMSC203-update", 39009, 4, "SC100", "NP");
		cds.add(cds4);
		assertEquals("NP", cds.get(39009).getInstructorName());
	}
	@Test
	public void testGet() throws IOException {
		assertEquals(cde3.getClass(), cds.get(39009).getClass());
		
	}

	@Test
	public void testShowAll() {
		ArrayList<String> courseList = cds.showAll(); 
		assertTrue(courseList.size()==2);  
	}
}
