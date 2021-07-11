package com.petpet.bean;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name="event")
@Component("eventbean")
public class EventBean implements java.io.Serializable {
	
	@Transient //無視
	private static final long serialVersionUID = 1L;
	
	@Id @Column(name = "EVENTID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventID;
	@Column(name = "HOSTID")
	private int hostID;
	@Column(name = "EVENTDATE")
	private String eventDate;
	@Column(name = "EVENTNAME")
	private String eventName;
	@Column(name = "EVENTSTARTTIME")
	private String eventStratTime;
	@Column(name = "EVENTENDTIME")
	private String eventEndTime;
	@Column(name = "EVENTLOCATION")
	private String eventLocation;
	@Column(name = "EVENTPICTURE")
	private byte[] eventPicture;
	@Column(name = "EVENTTYPE")
	private String eventType;
	@Column(name = "EVENTTYPE1")
	private String eventType1;
	@Column(name = "EVENTTYPE2")
	private String eventType2;
	@Column(name = "EVENTTYPECUSTOM")
	private String eventTypeCustom;
	@Column(name = "EVENTMAXLIMIT")
	private int eventMaxLimit;
	@Column(name = "EVENTFEE")
	private int eventFee;
	@Column(name = "EVENTSTATUS")
	private boolean eventStatus;
	@Column(name = "EVENTDESCRIBE")
	private String eventDescribe;
	
	public int getEventID() {  return eventID;  }
	public int getHostID() {  return hostID;  }
	public String getEventDate() {  return eventDate;  }
	public String getEventName() {  return eventName;  }
	public String getEventStratTime() {  return eventStratTime;  }
	public String getEventEndTime() {  return eventEndTime;  }
	public String getEventLocation() {  return eventLocation;  }
	public byte[] getEventPicture() {  return eventPicture;  }
	public String getEventType() {  return eventType;  }

	public String getEventType1() {  return eventType1;  }
	public String getEventType2() {  return eventType2;  }
	public String getEventTypeCustom() {  return eventTypeCustom;  }
	public int getEventMaxLimit() {  return eventMaxLimit;  }
	public int getEventFee() {  return eventFee;  }
	
	
	public void setEventID(int eventID) {  this.eventID= eventID;  }
	public void setHostID(int hostID) {   this.hostID= hostID;  }
	public void setEventDate(String eventDate ) {  this.eventDate= eventDate;  }
	public void setEventName(String eventName ) {  this.eventName =eventName;  }
	public void setEventStratTime(Timestamp ts) { 
		String tsStr = "";  
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
		tsStr = sdf.format(ts);  
		this.eventStratTime = tsStr ;  
		}
	public void setEventStratTime(String date) { 
		  try {
		      DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		       // you can change format of date
		      Date datetime = formatter.parse(date);
		      Timestamp timeStampDate = new Timestamp(datetime.getTime());
		      System.out.println(timeStampDate);
		      String tsStr = timeStampDate.toString();
		      this.eventStratTime= tsStr;
		    } catch (ParseException e) {
		      System.out.println("Exception :" + e);	 
		    }
}
	
	public void setEventEndTime(Timestamp ts) { 
		String tsStr = "";  
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
		tsStr = sdf.format(ts);  
		this.eventEndTime = tsStr ;  
 }
	public void setEventEndTime(String date) { 
		  try {
		      DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		       // you can change format of date
		      Date datetime = formatter.parse(date);
		      Timestamp timeStampDate = new Timestamp(datetime.getTime());
//		      System.out.println(timeStampDate);
		      String tsStr = timeStampDate.toString();
		      this.eventEndTime= tsStr;
		    } catch (ParseException e) {
		      System.out.println("Exception :" + e);	 
		    }
 }
	public void setEventLocation(String eventLocation) {  this.eventLocation = eventLocation;  }
	public void setEventPicture(byte[] eventPicture) {  this.eventPicture = eventPicture;  }
	public void setEventType(String eventType) {  this.eventType= eventType;  }

	public void setEventType1(String eventType1) {  this.eventType1= eventType1;  }
	public void setEventType2(String eventType2) {  this.eventType2 = eventType2;  }
	public void setEventTypeCustom(String eventTypeCustom) {  this.eventTypeCustom= eventTypeCustom;  }
	public void setEventMaxLimit(int eventMaxLimit) {  this.eventMaxLimit= eventMaxLimit;  }
	public void setEventFee(int eventFee) {  this.eventFee= eventFee;  }
	public boolean isEventStatus() {
		return eventStatus;
	}
	public void setEventStatus(boolean eventStatus) {
		this.eventStatus = eventStatus;
	}
	public String getEventDescribe() {
		return eventDescribe;
	}
	public void setEventDescribe(String eventDescribe) {
		this.eventDescribe = eventDescribe;
	}


	


}