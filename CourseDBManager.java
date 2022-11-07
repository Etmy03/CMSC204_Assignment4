import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class CourseDBManager implements CourseDBManagerInterface{

	CourseDBStructure elementsList = new CourseDBStructure(20);
	
	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crny
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		elementsList.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}
	
	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	public CourseDBElement get(int crn) {
		int index = (int)Math.ceil(crn%elementsList.getTableSize());
		for(LinkedList<CourseDBElement> listOfEl : elementsList.hashElementsTable) {
			if(listOfEl == null) {
				continue;
			}
			for(CourseDBElement el : listOfEl) {
				if(el.getCRN() == crn){
					return new CourseDBElement(el);
				}
			}
		}
		return null;
	}
	
	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	public void readFile(File input) throws FileNotFoundException{
		String courseSTR;
		String[] courseArr;
		Scanner fileCourses=new Scanner(input);
		CourseDBElement course;
		while (fileCourses.hasNextLine()) {
			courseSTR=fileCourses.nextLine();
			courseArr=courseSTR.split(" ",5);
			course=new CourseDBElement(courseArr[0],Integer.parseInt(courseArr[1]),Integer.parseInt(courseArr[2]),courseArr[3],courseArr[4]);
			elementsList.add(course);
		}
	}
	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	public ArrayList<String> showAll(){
		ArrayList<String> newElementsList = elementsList.showAll();
		return newElementsList;
	}
}
