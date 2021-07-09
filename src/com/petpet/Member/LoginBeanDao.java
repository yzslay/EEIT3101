package com.petpet.Member;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.petpet.bean.LoginBean;


@Repository("loginDao")
@Transactional
public class LoginBeanDao {

	@Autowired
	private SessionFactory sessionFactory;
	

	public LoginBean insert(LoginBean loginBean) {
		String hql = "from LoginBean where email=:email";
		Session session = sessionFactory.getCurrentSession();
		Query<LoginBean> query = session.createQuery(hql, LoginBean.class);
		query.setParameter("email", loginBean.getEmail());
		LoginBean loginbeanfomwsql = query.uniqueResult();

		if (loginbeanfomwsql == null) {
			session.save(loginBean);
			return loginBean;
		}
		return null;
	}

	public LoginBean selectByEmail(String email) {
		String hql = "from LoginBean where email=:email";
		Session session = sessionFactory.getCurrentSession();
		Query<LoginBean> query = session.createQuery(hql, LoginBean.class);
		query.setParameter("email", email);
		return query.uniqueResult();
	}

	public LoginBean update(String memberid, LoginBean loginBean) {
		Session session = sessionFactory.getCurrentSession();
		LoginBean resultBean = session.get(LoginBean.class, memberid);
		if (resultBean != null) {
			resultBean.setFirstname(loginBean.getFirstname());
			resultBean.setLastname(loginBean.getLastname());
			resultBean.setGender(loginBean.getGender());
			resultBean.setBirthday(loginBean.getBirthday());
			resultBean.setMobile(loginBean.getMobile());
		}

		return resultBean;
	}

	public LoginBean selectById(String memberid) {
		Session session = sessionFactory.getCurrentSession();
		LoginBean resultBean = session.get(LoginBean.class, memberid);
		return resultBean;
	}
	
	public LoginBean update2(String memberid, String Firstname, String Lastname, String Gender, String Birthday, String Mobile) {
		Session session = sessionFactory.getCurrentSession();
		LoginBean resultBean = session.get(LoginBean.class, memberid);
		if(resultBean != null){
			resultBean.setFirstname(Firstname);
			resultBean.setLastname(Lastname);
			resultBean.setGender(Gender);
			resultBean.setBirthday(Birthday);
			resultBean.setMobile(Mobile);
		}
		return resultBean;
	}
	
	
	public boolean checkLogin(LoginBean users) {
		Session session = sessionFactory.openSession();
		
		String hql = "from LoginBean where email=:user and password=:pwd";
		Query<LoginBean> query = session.createQuery(hql, LoginBean.class);
		query.setParameter("user", users.getEmail());
		query.setParameter("pwd", users.getPassword());
		LoginBean result = query.uniqueResult();
		
		if(result!=null) {
			return true;
		}
		return false;
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
