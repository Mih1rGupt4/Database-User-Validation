package dto;

public class PatientDto { 
	//Patient(pid, pname, problem, bloodgroup, status, primary key pid)
	
	private int p_id;
	private String pName;
	private String problem;
	private String bloodGroup;
	private String status;
	
	
	public int getp_id() {
		return p_id;
	}
	public void setp_id(int p_id) {
		this.p_id = p_id;
	}
	
	public String getpName() {
		return pName;
	}	
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	
	public String getproblem() {
		return problem;
	}
	public void setproblem(String problem) {
		this.problem = problem;
	}
	
	public String getbloodGroup() {
		return bloodGroup;
	}
	
	public void setbloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	public String getstatus() {
		return status;
	}
	
	public void setstatus(String status) {
		this.status = status;
	}
	
}
