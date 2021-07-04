package com.petpet.Member;



import org.hibernate.Session;


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
		return session.get(LoginBean.class, email);
	}
	

	public LoginBean update(String email, LoginBean loginBean) {  
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


