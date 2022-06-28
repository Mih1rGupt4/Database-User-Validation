package dto;

public class HospitalDto {
	// Model Object
	// Purpose: Allow data from DAO (DatabaseAccess class) to Service class
	
	private int dCount;
	private String d_id;
	private String dName;
	private String dPassword;
	private String dSpecialty;
	private String dBloodGrp;
	
	private String p_id;
	private String pName;
	private String pProblem;
	private String pBloodGroup;
	
	
	public int getdCount() {
		return dCount;
	}
	public void setdCount(int dCount) {
		this.dCount = dCount;
	}
	public String getD_id() {
		return d_id;
	}
	public void setD_id(String d_id) {
		this.d_id = d_id;
	}
	
	public String getdName() {
		return dName;
	}	
	public void setdName(String dName) {
		this.dName = dName;
	}
	
	public String getdPassword() {
		return dPassword;
	}
	public void setdPassword(String dPassword) {
		this.dPassword = dPassword;
	}
	
	public String getdSpecialty() {
		return dSpecialty;
	}
	public void setdSpecialty(String dSpecialty) {
		this.dSpecialty = dSpecialty;
	}
	
	public String getpid() {
		return p_id;
	}
	public void setpid(String pid) {
		this.p_id = pid;
	}
	
	public String getdBloodGrp() {
		return dBloodGrp;
	}
	public void setdBloodGrp(String dBloodGrp) {
		this.dBloodGrp = dBloodGrp;
	}
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public String getpProblem() {
		return pProblem;
	}
	public void setpProblem(String pProblem) {
		this.pProblem = pProblem;
	}
	
	public String getpBloodGroup() {
		return pBloodGroup;
	}
	public void setpBloodGroup(String pBloodGroup) {
		this.pBloodGroup = pBloodGroup;
	}
}
