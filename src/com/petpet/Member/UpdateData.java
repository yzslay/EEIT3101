package com.petpet.Member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.petpet.bean.LoginBean;
import com.petpet.util.HibernateUtil;

@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String memberid = request.getParameter("memberid");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String mobile = request.getParameter("mobile");
		

		try {
			
			LoginBeanService lBean = new LoginBeanService(session);
			LoginBean result = lBean.update2(memberid, firstname, lastname, gender, birthday, mobile);
			
			request.setAttribute("member", result);
			request.getRequestDispatcher("/Member/ShowLogin.jsp").forward(request, response);

		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
