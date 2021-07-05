package com.petpet.Member;

import org.hibernate.Session;
import org.hibernate.query.Query;


public class LoginBeanDao {

	private Session session;

	public LoginBeanDao(Session session) {
		this.session = session;
	}
	 

	public LoginBean insert(LoginBean loginBean) {  
		String hql = "from LoginBean where email=:email";
		Query<LoginBean> query = session.createQuery(hql, LoginBean.class);
		query.setParameter("email", loginBean.getEmail());
		LoginBean loginbeanfomwsql = query.uniqueResult();
		
		if(loginbeanfomwsql==null) {	
			session.save(loginBean);
			return loginBean;
		}		
		return null;
	}
	
	
	public LoginBean selectByEmail(String email) {
		String hql = "from LoginBean where email=:email";
		Query<LoginBean> query = session.createQuery(hql, LoginBean.class);
		query.setParameter("email", email);
		return query.uniqueResult();  
	}
	

	public LoginBean update(int memberid, LoginBean loginBean) {  
		LoginBean resultBean = session.get(LoginBean.class, memberid);
		if(resultBean!=null) {
			resultBean.setFirstname(loginBean.getFirstname());
			resultBean.setLastname(loginBean.getLastname());
			resultBean.setGender(loginBean.getGender());
			resultBean.setBirthday(loginBean.getBirthday());
			resultBean.setMobile(loginBean.getMobile());
		}
		
		return resultBean;
	}
	

public LoginBean selectById(String memberid) {
	LoginBean resultBean = session.get(LoginBean.class, memberid);
	return resultBean;
}

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
//	}


