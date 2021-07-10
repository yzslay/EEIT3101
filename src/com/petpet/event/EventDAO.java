package com.petpet.event;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.petpet.bean.EventBean;
import com.petpet.bean.mevent.MarketingEventBean;

@Repository("EventDAO")
@Transactional
public class EventDAO implements IEventDAO {
	@Autowired
	private SessionFactory sessionFactory ;
	
	@Override
	public List<EventBean> queryall() {
		Session session = sessionFactory.getCurrentSession();
		Query<EventBean> query = session.createQuery("from EventBean",EventBean.class);
		return query.list();
	};
	@Override
	public  EventBean query(int eventid) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(EventBean.class,eventid);
	}
	@Override
	public  EventBean insert(EventBean eventbean) {  //要在前面塞eventstatus=1,因為那個不能是空值
		Session session = sessionFactory.getCurrentSession();
		EventBean result = session.get(EventBean.class, eventbean.getEventID());
		if(result==null) {
			session.save(eventbean);
			return eventbean;
		}
		return null;
	};
	@Override
	public  EventBean update(EventBean eventbean) {
		Session session = sessionFactory.getCurrentSession();
		EventBean result = session.get(EventBean.class, eventbean.getEventID());
		
		if(result!=null) {
			result.setEventName(eventbean.getEventName());
			result.setEventDate(eventbean.getEventDate());
			result.setEventStratTime(eventbean.getEventStratTime());
			result.setEventEndTime(eventbean.getEventEndTime());
			result.setEventLocation(eventbean.getEventLocation());
			result.setEventType(eventbean.getEventType());
			result.setEventType1(eventbean.getEventType1());
			result.setEventType2(eventbean.getEventType2());
			result.setEventTypeCustom(eventbean.getEventTypeCustom());
			result.setEventMaxLimit(eventbean.getEventMaxLimit());
			result.setEventFee(eventbean.getEventFee());
			result.setEventDescribe(eventbean.getEventDescribe());	
		}		
		return result;
	}
	@Override
	public EventBean delete(int eventid) {
		Session session = sessionFactory.getCurrentSession();
		EventBean result = session.get(EventBean.class, eventid);
		
			session.delete(result);
			return result;
		}

	
	
}


	
	

