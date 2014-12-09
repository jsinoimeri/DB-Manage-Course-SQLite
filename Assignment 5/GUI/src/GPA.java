
public class GPA 
{
	private double grade;
	
	private String studentID,
	               courseID,
	               semesterID,
	               sectionID;

	public GPA(double grade, String studentID, String courseID,
			String semesterID, String sectionID) {
		this.grade = grade;
		this.studentID = studentID;
		this.courseID = courseID;
		this.semesterID = semesterID;
		this.sectionID = sectionID;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
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

	@Override
	public String toString() {
		return ""+grade +  " " + studentID
				+ " " + courseID + " " + semesterID
				+ " " + sectionID;
	}
	
	
	

}
