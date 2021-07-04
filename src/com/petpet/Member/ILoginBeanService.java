package com.petpet.Member;

public interface ILoginBeanService {
	public LoginBean insert(LoginBean loginBean);
	public LoginBean selectByEmail(String email);
	public LoginBean update(String email, LoginBean loginBean);

}
