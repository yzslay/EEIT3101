package com.petpet.mevent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petpet.bean.mevent.MarketingEventBean;
import com.petpet.mevent.dao.IMarketingEventDAO;

@Service("marketingEventService")
@Transactional
public class MarketingEventService implements IMarketingEventService {

	@Autowired @Qualifier("marketingEventDAO")
	private IMarketingEventDAO marketingEventDAO;
	
	@Override
	public List<MarketingEventBean> selectAll() {
		return marketingEventDAO.selectAll();
	}

	@Override
	public List<MarketingEventBean> query(String name) {
		return marketingEventDAO.query(name);
	}

	@Override
	public MarketingEventBean selectById(int eid) {
		return marketingEventDAO.selectById(eid);
	}

	@Override
	public MarketingEventBean insert(MarketingEventBean bean) {
		return marketingEventDAO.insert(bean);
	}

	@Override
	public MarketingEventBean update(MarketingEventBean bean) {
		return marketingEventDAO.update(bean);
	}

	@Override
	public boolean delete(MarketingEventBean bean) {
		return marketingEventDAO.delete(bean);
	}

	@Override
	public String title() {
		return marketingEventDAO.title();
	}

}
