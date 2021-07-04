package com.petpet.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.petpet.util.HibernateUtil;


@WebServlet("/CheckMemberData")
public class CopyTestCheckMemberData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean check= false;
		
		try {
			session.beginTransaction();

			LoginBeanService lBean = new LoginBeanService(session);
			LoginBean result = lBean.selectByEmail(email);
			
			if(result == null) {
				check = false;
			}else {
				if(result.getPassword().equals(password)) {
					check=true;
					request.setAttribute("member", result);
				}
			}

			
			if(check==true) {
				request.getRequestDispatcher("/MyTestLab/LoginTrue.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/MyTestLab/LoginFail.jsp").forward(request, response);
			}
			
			

		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			
		}
		HibernateUtil.closeSessionFactory();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
