import java.sql.Date;


public class Research 
{
	private String employeeID,
	               researchID,
	               name,
	               summary;
	
	private Date startDate,
	             endDate;

	public Research(String employeeID, String researchID, String name,
			String summary, Date startDate, Date endDate) {
		super();
		this.employeeID = employeeID;
		this.researchID = researchID;
		this.name = name;
		this.summary = summary;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getResearchID() {
		return researchID;
	}

	public void setResearchID(String researchID) {
		this.researchID = researchID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	public String toString()
	{
		return this.employeeID + " " + this.researchID + " " + this.name + " " + this.summary + " " + this.startDate.toString() + " " + this.endDate.toString();
	}

}
