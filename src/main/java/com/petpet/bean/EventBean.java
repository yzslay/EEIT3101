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
	
	public int setEventID(int EventID) {  return EventID;  }
	public int setHostID(int HostID) {  return HostID;  }
	public String setEventDate(String EventDate ) {  return EventDate;  }
	public String setEventName(String EventName ) {  return EventName;  }
	public String setEventStratTime(String EventStratTime) {  return EventStratTime;  }
	public String setEventBean(String EventEndTime) {  return EventEndTime;  }
	public String setEventLocation(String EventLocation) {  return EventLocation;  }
	public byte[] setEventPicture(byte[] EventPicture) {  return EventPicture;  }
	public String setEventType1(String EventType1) {  return EventType1;  }
	public String setEventType2(String EventType2) {  return EventType2;  }
	public String setEventCustom(String EventCustom) {  return EventCustom;  }
	public int setEventMaxLimit(int EventMaxLimit) {  return EventMaxLimit;  }
	public int setEventFee(int EventFee) {  return EventFee;  }
	public boolean setEventStatus() {  return EventStatus;  }
	


}