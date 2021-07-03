package com.petpet.Member;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class LoginBeanDao {

	private Session session;

	public LoginBeanDao(Session session) {
		this.session = session;
	}
	 
	public LoginBean insert(LoginBean loginBean) {  //根據Email來看是否資料庫內有資料
		LoginBean resultBean = session.get(LoginBean.class, loginBean.getEmail()); 
		
		if(resultBean==null) {
			session.save(loginBean);
			return loginBean;
		}		
		return null;
	}
	
	public LoginBean selectByEmail(String email) {  // email查看資料庫內的情況
		return session.get(LoginBean.class, email);
	}
	
//	public List<LoginBean> selectAll() {
//		Query<LoginBean> query = session.createQuery("from LoginBean", LoginBean.class);
//		return query.list();
//	}
	
	public LoginBean update(String email, LoginBean loginBean) {  // 用Email來找資料庫相對硬的資料, 已輸入資料為主做更新
		LoginBean resultBean = session.get(LoginBean.class, email);
		if(resultBean!=null) {
			resultBean.setFirstname(loginBean.getFirstname());
			resultBean.setLastname(loginBean.getLastname());
			resultBean.setGender(loginBean.getGender());
			resultBean.setBirthday(loginBean.getBirthday());
			resultBean.setMobile(loginBean.getMobile());
		}
		
		return resultBean;
	}
	
//	public boolean delete(int houseid) {  �������R��
//		HouseBean resultBean = session.get(HouseBean.class, houseid);
//		
//		if(resultBean!=null) {
//			session.delete(resultBean);
//			return true;
//		}
//		
//		return false;
	}


