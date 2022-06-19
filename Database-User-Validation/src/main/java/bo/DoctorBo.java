package bo;

public class DoctorBo {
	//Doctor(did,dname, dpass, dspecialty, pid varchar, primary key: did,foreign key: pid references patient(pid))
	
	private int d_id;
	private String dName;
	private String dPassword;
	private String dSpecialty;
	private String pid;
	
	
	public int get_did() {
		return d_id;
	}
	public void set_did(int d_id) {
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
		return pid;
	}
	
	public void setpid(String pid) {
		this.pid = pid;
	}
	
}
