
public class Semester 
{
	private String semesterID,
	               name;

	public Semester(String semesterID, String name) {
		super();
		this.semesterID = semesterID;
		this.name = name;
	}

	public String getSemesterID() {
		return semesterID;
	}

	public void setSemesterID(String semesterID) {
		this.semesterID = semesterID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString()
	{
		return this.semesterID + " " + this.name;
	}

}
