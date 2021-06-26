package com.petpet.bean.mevent;

import java.sql.Timestamp;

public class MarketingEventBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int meventid;
	private String meventtitle;
	private byte[] meventpicture;
	private Timestamp meventstartdate;
	private Timestamp meventenddate;
	private String meventname;
	private String meventdescription;
	private int meventtypeid;
	private int meventownerid;
	private boolean meventonline;
	
	public int getMeventid() {
		return meventid;
	}
	public void setMeventid(int meventid) {
		this.meventid = meventid;
	}
	public String getMeventtitle() {
		return meventtitle;
	}
	public void setMeventtitle(String meventtitle) {
		this.meventtitle = meventtitle;
	}
	public byte[] getMeventpicture() {
		return meventpicture;
	}
	public void setMeventpicture(byte[] meventpicture) {
		this.meventpicture = meventpicture;
	}
	public Timestamp getMeventstartdate() {
		return meventstartdate;
	}
	public void setMeventstartdate(Timestamp meventstartdate) {
		this.meventstartdate = meventstartdate;
	}
	public Timestamp getMeventenddate() {
		return meventenddate;
	}
	public void setMeventenddate(Timestamp meventenddate) {
		this.meventenddate = meventenddate;
	}
	public String getMeventname() {
		return meventname;
	}
	public void setMeventname(String meventname) {
		this.meventname = meventname;
	}
	public String getMeventdescription() {
		return meventdescription;
	}
	public void setMeventdescription(String meventdescription) {
		this.meventdescription = meventdescription;
	}
	public int getMeventtypeid() {
		return meventtypeid;
	}
	public void setMeventtypeid(int meventtypeid) {
		this.meventtypeid = meventtypeid;
	}
	public int getMeventownerid() {
		return meventownerid;
	}
	public void setMeventownerid(int meventownerid) {
		this.meventownerid = meventownerid;
	}
	public boolean isMeventonline() {
		return meventonline;
	}
	public void setMeventonline(boolean meventonline) {
		this.meventonline = meventonline;
	}
	
	
}

