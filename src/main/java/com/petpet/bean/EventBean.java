package com.petpet.bean;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class EventBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int eventID;
	private int hostID;
	private String eventDate;
	private String eventName;
	private String eventStratTime;
	private String eventEndTime;
	
	private String eventLocation;
	private byte[] eventPicture;
	private String eventType1;
	private String eventType2;
	private String eventCustom;
	private int eventMaxLimit;
	private int eventFee;
	private boolean eventStatus;

	
	public int getEventID() {  return eventID;  }
	public int getHostID() {  return hostID;  }
	public String getEventDate() {  return eventDate;  }
	public String getEventName() {  return eventName;  }
	public String getEventStratTime() {  return eventStratTime;  }
	public String getEventEndTime() {  return eventEndTime;  }
	public String getEventLocation() {  return eventLocation;  }
	public byte[] getEventPicture() {  return eventPicture;  }
	public String getEventType1() {  return eventType1;  }
	public String getEventType2() {  return eventType2;  }
	public String getEventCustom() {  return eventCustom;  }
	public int getEventMaxLimit() {  return eventMaxLimit;  }
	public int getEventFee() {  return eventFee;  }
	
	
	public void setEventID(int eventID) {  this.eventID= eventID;  }
	public void setHostID(int hostID) {   this.hostID= hostID;  }
	public void setEventDate(String eventDate ) {  this.eventDate= eventDate;  }
	public void setEventName(String eventName ) {  this.eventName =eventName;  }
	public void setEventStratTime(Timestamp ts) { 
		String tsStr = "";  
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");  
		tsStr = sdf.format(ts);  
		this.eventStratTime = tsStr ;  
		}
	public void setEventEndTime(Timestamp ts) { 
		String tsStr = "";  
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");  
		tsStr = sdf.format(ts);  
		this.eventEndTime = tsStr ;  
 }
	public void setEventLocation(String eventLocation) {  this.eventLocation = eventLocation;  }
	public void setEventPicture(byte[] eventPicture) {  this.eventPicture = eventPicture;  }
	public void setEventType1(String eventType1) {  this.eventType1= eventType1;  }
	public void setEventType2(String eventType2) {  this.eventType2 = eventType2;  }
	public void setEventCustom(String eventCustom) {  this.eventCustom= eventCustom;  }
	public void setEventMaxLimit(int eventMaxLimit) {  this.eventMaxLimit= eventMaxLimit;  }
	public void setEventFee(int eventFee) {  this.eventFee= eventFee;  }
	public boolean isEventStatus() {
		return eventStatus;
	}
	public void setEventStatus(boolean eventStatus) {
		this.eventStatus = eventStatus;
	}


	


}