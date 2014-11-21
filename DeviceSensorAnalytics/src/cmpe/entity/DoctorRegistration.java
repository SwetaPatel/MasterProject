package cmpe.entity;

public class DoctorRegistration {
	private String demail;
	private String dpassword;
	private String dgender;
	private String docFname;
	private String docLname;
	private int id;
	public String getDemail() {
		return demail;
	}
	public void setDemail(String demail) {
		this.demail = demail;
	}
	public String getDpassword() {
		return dpassword;
	}
	public void setDpassword(String dpassword) {
		this.dpassword = dpassword;
	}
	public String getDgender() {
		return dgender;
	}
	public void setDgender(String dgender) {
		this.dgender = dgender;
	}
	public String getDocFname() {
		return docFname;
	}
	public void setDocFname(String docFname) {
		this.docFname = docFname;
	}
	public String getDocLname() {
		return docLname;
	}
	public void setDocLname(String docLname) {
		this.docLname = docLname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
