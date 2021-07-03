package com.petpet.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.SessionFactory;


@WebFilter("/*")
public class OpenSessionViewFilter implements Filter {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			System.out.println("Transaction Begin");
			chain.doFilter(request, response);
			sessionFactory.getCurrentSession().getTransaction().commit();
			System.out.println("Transaction Commit");
		}catch(Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			System.out.println("Transaction Rollback");
		}finally {
			System.out.println("Session Closed");
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
