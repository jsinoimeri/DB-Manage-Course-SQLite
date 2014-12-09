
public class Professor 
{
	private String employeeID,
	               departmentID,
	               title,
	               name,
	               officePhoneNum;

	public Professor(String employeeID, String departmentID, String title,
			String name, String officePhoneNum) {
		super();
		this.employeeID = employeeID;
		this.departmentID = departmentID;
		this.title = title;
		this.name = name;
		this.officePhoneNum = officePhoneNum;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOfficePhoneNum() {
		return officePhoneNum;
	}

	public void setOfficePhoneNum(String officePhoneNum) {
		this.officePhoneNum = officePhoneNum;
	}
	
	public String toString()
	{
		return this.employeeID + " " + this.departmentID + " " + this.title + " " + this.name + " " + this.officePhoneNum;
	}

}
