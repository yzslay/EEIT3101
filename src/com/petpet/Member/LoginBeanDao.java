package com.petpet.Member;



import org.hibernate.Session;
import org.hibernate.query.Query;


public class LoginBeanDao {

	private Session session;

	public LoginBeanDao(Session session) {
		this.session = session;
	}
	 

	public LoginBean insert(LoginBean loginBean) {  
		LoginBean resultBean = session.get(LoginBean.class, loginBean.getEmail()); 
		
		if(resultBean==null) {	
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
	

	public LoginBean update(String email, LoginBean loginBean) {  
		String hql = "from LoginBean where email=:email";
		Query<LoginBean> query = session.createQuery(hql, LoginBean.class);
		query.setParameter("email", email);
		LoginBean loginbeanfomwsql = query.uniqueResult();


		if(loginbeanfomwsql!=null) {
			loginbeanfomwsql.setFirstname(loginBean.getFirstname());
			loginbeanfomwsql.setLastname(loginBean.getLastname());
			loginbeanfomwsql.setGender(loginBean.getGender());
			loginbeanfomwsql.setBirthday(loginBean.getBirthday());
			loginbeanfomwsql.setMobile(loginBean.getMobile());
		}
		return loginbeanfomwsql;
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


