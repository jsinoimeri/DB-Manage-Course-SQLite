
public class Courses 
{
	private String courseID,
	               PrerequisitesID,
	               programID,
	               name,
	               description;

	public Courses(String courseID, String prerequisitesID, String programID,
			String name, String description) {
		super();
		this.courseID = courseID;
		PrerequisitesID = prerequisitesID;
		this.programID = programID;
		this.name = name;
		this.description = description;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getPrerequisitesID() {
		return PrerequisitesID;
	}

	public void setPrerequisitesID(String prerequisitesID) {
		PrerequisitesID = prerequisitesID;
	}

	public String getProgramID() {
		return programID;
	}

	public void setProgramID(String programID) {
		this.programID = programID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString()
	{
		return this.courseID + " " + this.PrerequisitesID + " " + this.programID + " " + this.name + " " + this.description;
	}

}
