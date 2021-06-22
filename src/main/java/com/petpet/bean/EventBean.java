package com.petpet.bean;

public class EventBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int EventID;
	private int HostID;
	private String EventDate;
	private String EventName;
	private String EventStratTime;
	private String EventEndTime;
	private String EventLocation;
	private byte[] EventPicture;
	private String EventType1;
	private String EventType2;
	private String EventCustom;
	private int EventMaxLimit;
	private int EventFee;
	private boolean EventStatus;
	
	public int getEventID() {  return EventID;  }
	public int getHostID() {  return HostID;  }
	public String getEventDate() {  return EventDate;  }
	public String getEventName() {  return EventName;  }
	public String getEventStratTime() {  return EventStratTime;  }
	public String getEventBean() {  return EventEndTime;  }
	public String getEventLocation() {  return EventLocation;  }
	public byte[] getEventPicture() {  return EventPicture;  }
	public String getEventType1() {  return EventType1;  }
	public String getEventType2() {  return EventType2;  }
	public String getEventCustom() {  return EventCustom;  }
	public int getEventMaxLimit() {  return EventMaxLimit;  }
	public int getEventFee() {  return EventFee;  }
	public boolean getEventStatus() {  return EventStatus;  }
	
	public void setEventID(int EventID) {  this.EventID= EventID;  }
	public void setHostID(int HostID) {   this.HostID= HostID;  }
	public void setEventDate(String EventDate ) {  this.EventDate= EventDate;  }
	public void setEventName(String EventName ) {  this.EventName =EventName;  }
	public void setEventStratTime(String EventStratTime) {  this.EventStratTime = EventStratTime ;  }
	public void setEventBean(String EventEndTime) {  this.EventEndTime = EventEndTime;  }
	public void setEventLocation(String EventLocation) {  this.EventLocation = EventLocation;  }
	public void setEventPicture(byte[] EventPicture) {  this.EventPicture = EventPicture;  }
	public void setEventType1(String EventType1) {  this.EventType1= EventType1;  }
	public void setEventType2(String EventType2) {  this.EventType1 = EventType2;  }
	public void setEventCustom(String EventCustom) {  this.EventCustom= EventCustom;  }
	public void setEventMaxLimit(int EventMaxLimit) {  this.EventMaxLimit= EventMaxLimit;  }
	public void setEventFee(int EventFee) {  this.EventFee= EventFee;  }
	public void setEventStatus(boolean True) {  this.EventStatus = True;  }
	


}