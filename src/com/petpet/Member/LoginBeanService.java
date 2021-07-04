package com.petpet.Member;

import org.hibernate.Session;

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
	public LoginBean update(int memberid, LoginBean loginBean) {
		
		return lbeanDao.update(memberid, loginBean);
	}

}
