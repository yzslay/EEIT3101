package com.petpet.mevent.dao;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.petpet.bean.mevent.MarketingEventBean;

public class MarketingEventDAO implements IMarketingEventDAO{

	private Session session;

	@Override
	public List<MarketingEventBean> selectAll() {
		Query<MarketingEventBean> query = session.createQuery("from MarketingEventBean",MarketingEventBean.class);
		return query.list();
	};

	@Override
	public List<MarketingEventBean> query(String name){
		String hql = "from MarketingEventBean where meventname like :name";
		Query<MarketingEventBean> query = session.createQuery(hql, MarketingEventBean.class);
		query.setParameter("name", name);
		return query.list();
	};

	@Override
	public MarketingEventBean selectById(int eid){
		return session.get(MarketingEventBean.class,eid);
	};

	@Override
	public MarketingEventBean insert(MarketingEventBean bean){
		MarketingEventBean result = session.get(MarketingEventBean.class, bean.getMeventid());
		if(result==null) {
			session.save(bean);
			return bean;
		}
		return null;
	};

	@Override
	public MarketingEventBean update(MarketingEventBean bean) {
		MarketingEventBean result = session.get(MarketingEventBean.class, bean.getMeventid());
		if(result!=null) {
			result.setMeventtitle(bean.getMeventtitle());
			result.setMeventpicture(bean.getMeventpicture());
			result.setMeventstartdate(bean.getMeventstartdate());
			result.setMeventenddate(bean.getMeventenddate());
			result.setMeventname(bean.getMeventname());
			result.setMeventdescription(bean.getMeventdescription());
			result.setMeventtypeid(bean.getMeventtypeid());
			result.setMeventownerid(bean.getMeventownerid());
			result.setMeventonline(bean.isMeventonline());
		}
		return result;
	};

	@Override
	public boolean delete(MarketingEventBean bean){
		MarketingEventBean result = session.get(MarketingEventBean.class, bean.getMeventid());
		if(result!=null) {
			session.delete(result);
			return true;
		}
		return false;
	};

	@SuppressWarnings("rawtypes")
	@Override
	public String title() {
		String hql = "select count(*) from MarketingEventBean where meventtitle like :title";
		String title = new SimpleDateFormat("yyyyMMdd").format(new Date()) + "ME";
		Query query = session.createQuery(hql);
		query.setParameter("title", title+"%");
		long num = (Long) query.uniqueResult();
		title = title + (num + 1);
		return title;
	}

	// getter setter
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	// constructor
	public MarketingEventDAO() {
	}

	public MarketingEventDAO(Session session) {
		this.session = session;
	}
}
