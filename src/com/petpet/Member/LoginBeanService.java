package com.petpet.Member;

import org.hibernate.Session;

import com.petpet.bean.LoginBean;

public class LoginBeanService implements ILoginBeanService {
    private LoginBeanDao lbeanDao;
 
	
	public LoginBeanService(Session session) {
		lbeanDao=new LoginBeanDao(session);
	}

	@Override
	public LoginBean insert(LoginBean loginBean) {
		
		return lbeanDao.insert(loginBean);
	}

	@Override
	public LoginBean selectByEmail(String email) {
		
		return lbeanDao.selectByEmail(email);
	}

	@Override
	public LoginBean update(String memberid, LoginBean loginBean) {
		
		return lbeanDao.update(memberid, loginBean);
	}

	@Override
	public LoginBean selectById(String memberid) {
		return lbeanDao.selectById(memberid);
	}
	
	@Override
	public LoginBean update2(String memberid, String Firstname, String Lastname, String Gender, String Birthday, String Mobile) {
		
		return lbeanDao.update2(memberid, Firstname, Lastname, Gender, Birthday, Mobile);
	}
	
	

}
