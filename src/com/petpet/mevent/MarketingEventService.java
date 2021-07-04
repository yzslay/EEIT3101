package com.petpet.mevent;

import java.util.List;

import org.hibernate.Session;

import com.petpet.bean.mevent.MarketingEventBean;
import com.petpet.mevent.dao.MarketingEventDAO;

public class MarketingEventService implements IMarketingEventService {

	private MarketingEventDAO medao;
	
	public MarketingEventService(Session session) {
		medao=new MarketingEventDAO(session);
	}

	@Override
	public List<MarketingEventBean> selectAll() {
		return medao.selectAll();
	}

	@Override
	public List<MarketingEventBean> query(String name) {
		return medao.query(name);
	}

	@Override
	public MarketingEventBean selectById(int eid) {
		return medao.selectById(eid);
	}

	@Override
	public MarketingEventBean insert(MarketingEventBean bean) {
		return medao.insert(bean);
	}

	@Override
	public MarketingEventBean update(MarketingEventBean bean) {
		return medao.update(bean);
	}

	@Override
	public boolean delete(MarketingEventBean bean) {
		return medao.delete(bean);
	}

	@Override
	public String title() {
		return medao.title();
	}

}
