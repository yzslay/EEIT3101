package com.petpet.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class SessionFactoryListener implements ServletContextListener {


    public void contextDestroyed(ServletContextEvent sce)  { 
         HibernateUtil.closeSessionFactory();
         System.out.println("Session Factory Destroyed");
    }


    public void contextInitialized(ServletContextEvent sce)  { 
         HibernateUtil.getSessionFactory();
         System.out.println("Session Factory Created");
    }
	
}
