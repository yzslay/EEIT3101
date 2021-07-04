package com.petpet.mevent;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.petpet.util.HibernateUtil;
import com.petpet.bean.mevent.MarketingEventBean;

@MultipartConfig
@WebServlet("/mevent")
public class MEventControllerHibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int EMPNO=1012;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
			if(action==null) {action="list";}
        try {
            switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "insert":
                insertMEvent(request, response);
                break;
            case "delete":
                deleteMEvent(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateMEvent(request, response);
                break;
            case "search":
            	showSearchForm(request,response);
            	break;
            case "query":
            	queryMEvent(request,response);
            	break;
            default:
                listMEvent(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	private void listMEvent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		List<MarketingEventBean> mevents = new MarketingEventService(session).selectAll();
        request.setAttribute("mevents", mevents);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mevent/ListMEvent.jsp");
        dispatcher.forward(request, response);
    }
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mevent/MEventForm.jsp");
        dispatcher.forward(request, response);
    }
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int eid = Integer.parseInt(request.getParameter("eid"));
        SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
        MarketingEventBean existingmevent = new MarketingEventService(session).selectById(eid);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mevent/MEventForm.jsp");
        request.setAttribute("mevent", existingmevent);
        dispatcher.forward(request, response);
 
    }
	
	private void showSearchForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mevent/QueryMEvent.jsp");
        dispatcher.forward(request, response);
    }
	
	private void insertMEvent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		MarketingEventService mes = new MarketingEventService(session);
        String title = mes.title();
        InputStream pic= request.getPart("pic").getInputStream(); 
		Timestamp startdate = Timestamp.valueOf(request.getParameter("startdate")+" "+request.getParameter("starttime"));
		Timestamp enddate = Timestamp.valueOf(request.getParameter("enddate")+" "+request.getParameter("endtime"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int typeid =Integer.parseInt(request.getParameter("typeid"));
		int ownerid = EMPNO;
		boolean online = Boolean.valueOf(request.getParameter("online"));
        MarketingEventBean mevent = new MarketingEventBean();
        mevent.setMeventtitle(title);
        if(request.getPart("pic").getSubmittedFileName()=="") {mevent.setMeventpicture(null);}else {mevent.setMeventpicture(pic.readAllBytes());}
        mevent.setMeventstartdate(startdate);
        mevent.setMeventenddate(enddate);
        mevent.setMeventname(name);
        mevent.setMeventdescription(description);
        mevent.setMeventtypeid(typeid);
        mevent.setMeventownerid(ownerid);
        mevent.setMeventonline(online);	
        mes.insert(mevent);
        response.sendRedirect("/EEIT3101/mevent");
    }
	
	private void updateMEvent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		MarketingEventService mes = new MarketingEventService(session);
		int id=Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		InputStream pic;
		if(request.getPart("pic").getSubmittedFileName()=="") {
			if(mes.selectById(id).getMeventpicture()==null) {pic=null;}else {
			pic = new ByteArrayInputStream(mes.selectById(id).getMeventpicture());}
		}else {pic = request.getPart("pic").getInputStream();}       
		Timestamp startdate = Timestamp.valueOf(request.getParameter("startdate")+" "+request.getParameter("starttime"));
		Timestamp enddate = Timestamp.valueOf(request.getParameter("enddate")+" "+request.getParameter("endtime"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int typeid =Integer.parseInt(request.getParameter("typeid"));
		int ownerid = EMPNO;
		boolean online = Boolean.valueOf(request.getParameter("online"));
        MarketingEventBean mevent = new MarketingEventBean();
        mevent.setMeventid(id);
        mevent.setMeventtitle(title);
        if(pic==null) {mevent.setMeventpicture(null);}else{mevent.setMeventpicture(pic.readAllBytes());}
        mevent.setMeventstartdate(startdate);
        mevent.setMeventenddate(enddate);
        mevent.setMeventname(name);
        mevent.setMeventdescription(description);
        mevent.setMeventtypeid(typeid);
        mevent.setMeventownerid(ownerid);
        mevent.setMeventonline(online);    
        mes.update(mevent);
        response.sendRedirect("/EEIT3101/mevent");
    }
	
	private void deleteMEvent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int eid=Integer.parseInt(request.getParameter("eid"));
		MarketingEventBean mevent = new MarketingEventBean();
	    mevent.setMeventid(eid);
	    SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		MarketingEventService mes = new MarketingEventService(session);
        mes.delete(mevent);
        response.sendRedirect("/EEIT3101/mevent");
    }
	
	private void queryMEvent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String name="%"+request.getParameter("name")+"%";
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		MarketingEventService mes = new MarketingEventService(session);
		List<MarketingEventBean> mevents =mes.query(name);
		request.setAttribute("mevents", mevents);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mevent/ListMEvent.jsp");
        dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
