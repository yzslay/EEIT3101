package com.petpet.event;

import java.util.List;

import com.petpet.bean.EventBean;

public interface IEventDAO {
	public  EventBean query(int eventid);
	public  EventBean insert(EventBean eventbean);
	public  EventBean update(EventBean eventbean);
	public List<EventBean> queryall();
	public EventBean delete(int eventid);
}
