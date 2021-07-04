package com.petpet.mevent.dao;

import java.util.List;

import com.petpet.bean.mevent.MarketingEventBean;

public interface IMarketingEventDAO {
	public List<MarketingEventBean> selectAll();
	public List<MarketingEventBean> query(String name);
	public MarketingEventBean selectById(int eid);
	public MarketingEventBean insert(MarketingEventBean bean);
	public MarketingEventBean update(MarketingEventBean bean);
	public boolean delete(MarketingEventBean bean);
	public String title();
}
