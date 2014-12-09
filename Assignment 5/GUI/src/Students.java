
public class Students 
{
	private String studentID,
	               name,
	               email,
	               address,
	               programID;
	
	public Students(String studentID, String name, String email, String address, String programID)
	{
		this.studentID = studentID;
		this.name = name;
		this.email = email;
		this.address = address;
		this.programID = programID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProgramID() {
		return programID;
	}

	public void setProgramID(String programID) {
		this.programID = programID;
	}
	
	public String toString()
	{
		String s = this.studentID  + " " + this.programID + " " + this.name + " " + this.email + " " + this.address;
		return s;
	}

}
