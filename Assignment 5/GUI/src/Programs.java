
public class Programs 
{
	private String programID,
	               departmentID,
	               name;
	
	private int length;

	public Programs(String programID, String departmentID, String name,
			int length) {
		super();
		this.programID = programID;
		this.departmentID = departmentID;
		this.name = name;
		this.length = length;
	}

	public String getProgramID() {
		return programID;
	}

	public void setProgramID(String programID) {
		this.programID = programID;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
	public String toString()
	{
		return this.programID + " "+ this.departmentID + " " + this.name + " " + this.length;
	}

}
