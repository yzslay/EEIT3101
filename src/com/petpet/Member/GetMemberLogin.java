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


@WebServlet("/GetMemberLogin")
public class GetMemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int memberid = request.getIntHeader("memberid");
		try {
			
			LoginBeanService lBean = new LoginBeanService(session);
			LoginBean result = lBean.selectById(memberid);
			
			request.setAttribute("member", result);
			request.getRequestDispatcher("/Member/MemberShow.jsp").forward(request, response);
			
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
