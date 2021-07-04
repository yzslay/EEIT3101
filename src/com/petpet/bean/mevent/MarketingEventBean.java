package com.petpet.bean.mevent;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="marketingevent")
public class MarketingEventBean implements java.io.Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id @Column(name="MEVENTID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int meventid;
	
	@Column(name="MEVENTTITLE")
	private String meventtitle;
	
	@Column(name="MEVENTPICTURE")
	private byte[] meventpicture;
	
	@Column(name = "MEVENTSTARTDATE")
	private Timestamp meventstartdate;
	
	@Column(name = "MEVENTENDDATE")
	private Timestamp meventenddate;
	
	@Column(name = "MEVENTNAME")
	private String meventname;
	
	@Column(name = "MEVENTDESCRIPTION")
	private String meventdescription;
	
	@Column(name = "MEVENTTYPEID")
	private int meventtypeid;
	
	@Column(name = "MEVENTOWNERID")
	private int meventownerid;
	
	@Column(name = "MEVENTONLINE")
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

