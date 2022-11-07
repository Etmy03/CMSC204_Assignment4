import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
	LinkedList [] hashElementsTable;
	int numOfCourses;
	final Double loadingFactor = 1.5;

	//int numOfelements=0;
	
	public CourseDBStructure(int numOfCourses) {
		this.numOfCourses = numOfCourses;
		hashElementsTable = new LinkedList[numOfCourses];
//		int findPrime = numOfCourses;
//		findPrime++;
//	    for(int i=2;i<findPrime;i++) {
//	        if(findPrime % i ==0) {
//	        	findPrime++;
//	            i=2;
//	        }
//	        else{
//	            continue;
//	        }
//	    }
//	    len = findPrime;
	}
	
	public CourseDBStructure(String y, int numOfCourses) {
		this.numOfCourses = numOfCourses;
		hashElementsTable = new LinkedList[numOfCourses];
//		int findPrime = numOfCourses;
//		findPrime++;
//	    for(int i=2;i<findPrime;i++) {
//	        if(findPrime % i ==0) {
//	        	findPrime++;
//	            i=2;
//	        }
//	        else{
//	            continue;
//	        }
//	    }
//	    len = findPrime;

	}
	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	public void add(CourseDBElement element) {
		boolean doesExist = false;
		for(LinkedList<CourseDBElement> listOfEl : hashElementsTable) {
			if(listOfEl == null) {
				continue;
			}
			for(CourseDBElement el : listOfEl) {
				if(el.getCRN() == element.getCRN()){
					doesExist = true;
					if(!element.getID().equals(el.getID())) {
						el.setID(element.getID());
					}
					if(!element.getInstructorName().equals(el.getInstructorName())) {
						el.setInstructorName(element.getInstructorName());
					}
					if(!element.getRoomNum().equals(el.getRoomNum())) {
						el.setRoomNum(element.getRoomNum());
					}
					break;
				}
			}
		}
		if(!doesExist) {
			int index = (int)Math.ceil(element.hashCode()%numOfCourses);
			if(hashElementsTable[index] == null) {
				hashElementsTable[index] = new LinkedList<CourseDBElement>();
			}
			hashElementsTable[index].add(new CourseDBElement(element));
			
		}
		
	}
	
	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 */

	public CourseDBElement get(int crn) throws IOException{
		String key=String.valueOf(crn);
		int index=Math.abs(key.hashCode())% numOfCourses;
		if(hashElementsTable[index]==null) {
			throw new IOException();
		}
		else{
			return (CourseDBElement) hashElementsTable[index].get(0);
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
		//String course;
		ArrayList<String> newElementsList = new ArrayList<String>();
		for(LinkedList<CourseDBElement> listOfEl : hashElementsTable) {
			if(listOfEl == null) {
				continue;
			}
			for(CourseDBElement el : listOfEl) {
				newElementsList.add(el.toString());
			}
		}
		return newElementsList;
	}
	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	public int getTableSize() {
		return numOfCourses;
	}
}
