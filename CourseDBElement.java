
public class CourseDBElement implements Comparable{
	
	public String ID;
	protected int CRN;
	public int credits;
	public String roomNum;
	public String instructorName;

	public CourseDBElement() {
		this.ID = null;
		this.CRN = 0;
		this.credits = 0;
		this.roomNum = null;
		this.instructorName = null;
	}
	public CourseDBElement(CourseDBElement newElement) {
		this.ID = newElement.ID;
		this.CRN = newElement.CRN;
		this.credits = newElement.credits;
		this.roomNum = newElement.roomNum;
		this.instructorName = newElement.instructorName;
	}
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		this.ID = id;
		this.CRN = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructorName = instructor;
	}
	
	
	
	public String getID() {
		return ID;
	}
	public int getCRN() {
		return CRN;
	}
	public int getCredits() {
		return credits;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setCRN(int cRN) {
		CRN = cRN;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	@Override
	public String toString() {
		return "Course:" +ID+ " CRN:" +String.valueOf(CRN)+ " Credits:" +credits+ " Instructor:" +instructorName+ " Room:" +roomNum;
	}
	
	public int compareTo(CourseDBElement o) {
		if((this.CRN) == (o.CRN)) {
			return 0;
		}
		else if((this.CRN) < (o.CRN)) {
		return -1;
		}
		return 1;
	}
	
	public int hashCode() {
		String crnSTR = String.valueOf(CRN);
		return crnSTR.hashCode();
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return -2;
	}

}
