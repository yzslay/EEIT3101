package com.petpet.Member;

import com.petpet.bean.LoginBean;

public interface ILoginBeanService {
	public LoginBean insert(LoginBean loginBean);
	public LoginBean selectByEmail(String email);
	public LoginBean update(String memberid, LoginBean loginBean);
	public LoginBean selectById(String memberid);
	public LoginBean update2(String memberid, String Firstname, String Lastname, String Gender, String Birthday, String Mobile);

}
