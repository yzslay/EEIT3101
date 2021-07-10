package com.petpet.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petpet.bean.EventBean;


@Service("EventService")
@Transactional
public class EventService implements IEventService {
	
	@Autowired @Qualifier("EventDAO")
	private IEventDAO EventDAO;

	@Override
	public List<EventBean> queryall() {
		return EventDAO.queryall();
	}
	@Override
	public EventBean query(int eventid)  {
		return EventDAO.query(eventid);
	}
	@Override
	public EventBean insert(EventBean eventbean)  {
		return EventDAO.insert(eventbean);
	}
	@Override
	public EventBean update(EventBean eventbean)  {
		return EventDAO.update(eventbean);
	}
	@Override
	public EventBean delete(int eventid)  {
		return EventDAO.delete(eventid);
	}
}
