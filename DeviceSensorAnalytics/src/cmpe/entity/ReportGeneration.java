package cmpe.entity;

import java.util.Date;

public class ReportGeneration {
	private String highBp;
	private String lowBp;
	private String pemail;
	private Date dateVal;
	public String getHighBp() {
		return highBp;
	}
	public void setHighBp(String highBp) {
		this.highBp = highBp;
	}
	public String getLowBp() {
		return lowBp;
	}
	public void setLowBp(String lowBp) {
		this.lowBp = lowBp;
	}
//	public String getBpsReading() {
//		return bpsReading;
//	}
//	public void setBpsReading(String bpsReading) {
//		this.bpsReading = bpsReading;
//	}
	public String getPemail() {
		return pemail;
	}
	public void setPemail(String pemail) {
		this.pemail = pemail;
	}
	public Date getDateVal() {
		return dateVal;
	}
	public void setDateVal(Date dateVal) {
		this.dateVal = dateVal;
	}
}
