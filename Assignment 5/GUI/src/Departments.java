
public class Departments 
{
	private String departmentID,
	               name;
	
	private double minimumGPA;

	public Departments(String departmentID, String name, double minimumGPA) {
		super();
		this.departmentID = departmentID;
		this.name = name;
		this.minimumGPA = minimumGPA;
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

	public double getMinimumGPA() {
		return minimumGPA;
	}

	public void setMinimumGPA(double minimumGPA) {
		this.minimumGPA = minimumGPA;
	}
	
	
	public String toString()
	{
		return this.departmentID + " " + this.name + " " + this.minimumGPA;
	}
	
	
	               

}
