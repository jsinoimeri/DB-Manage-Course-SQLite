
public class Section 
{
	private String courseID,
	               employeeID,
	               semesterID,
	               sectionID;

	public Section(String courseID, String employeeID, String semesterID,
			String sectionID) {
		super();
		this.courseID = courseID;
		this.employeeID = employeeID;
		this.semesterID = semesterID;
		this.sectionID = sectionID;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getSemesterID() {
		return semesterID;
	}

	public void setSemesterID(String semesterID) {
		this.semesterID = semesterID;
	}

	public String getSectionID() {
		return sectionID;
	}

	public void setSectionID(String sectionID) {
		this.sectionID = sectionID;
	}
	
	public String toString()
	{
		return this.courseID + " " + this.employeeID + " " + this.semesterID + " " + this.sectionID;
	}

}
