package com.petpet.event;

import java.util.List;
import com.petpet.bean.EventBean;

public interface  IEventService {
	
	public List<EventBean> queryall();
	public EventBean query(int eventid);
	public EventBean insert(EventBean EventBean);
	public EventBean update(EventBean eventbean);
	public EventBean delete(int eventid);
}