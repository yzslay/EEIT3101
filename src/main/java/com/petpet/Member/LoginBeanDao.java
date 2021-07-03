package com.petpet.Member;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class LoginBeanDao {

	private Session session;

	public LoginBeanDao(Session session) {
		this.session = session;
	}
	 
	public LoginBean insert(LoginBean loginBean) {  //新增會員，輸入LoginBean裡的Email & Password  如果對方email不是空值，寫入資料庫
		LoginBean resultBean = session.get(LoginBean.class, loginBean.getEmail()); 
		
		if(resultBean==null) {
			session.save(loginBean);
			return loginBean;
		}		
		return null;
	}
	
	public LoginBean selectByEmail(String email) {  // email 查詢會員輸入Email，利用Email查詢資料庫裡的會員資料
		return session.get(LoginBean.class, email);
	}
	
//	public List<LoginBean> selectAll() {
//		Query<LoginBean> query = session.createQuery("from LoginBean", LoginBean.class);
//		return query.list();
//	}
	
	public LoginBean update(String email, LoginBean loginBean) {  // 更新，先前的有六項但我不知道為什麼ID需要更新
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
	
//	public boolean delete(int houseid) {  先不做刪除
//		HouseBean resultBean = session.get(HouseBean.class, houseid);
//		
//		if(resultBean!=null) {
//			session.delete(resultBean);
//			return true;
//		}
//		
//		return false;
	}

}
