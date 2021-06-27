package com.petpet.mevent;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.petpet.mevent.dao.MarketingEventDAO;
import com.petpet.bean.mevent.MarketingEventBean;

@MultipartConfig
@WebServlet("/mevent")
public class MEventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private MarketingEventDAO medao;
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

	@SuppressWarnings("finally")
	private Connection connect() throws SQLException{
			try {
				Context context = new InitialContext();
				DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/petpet");
				conn = ds.getConnection();
			}catch(NamingException e) {
				e.printStackTrace();
			}finally {
				return conn;
			}
		}
	
	private void listMEvent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        medao = new MarketingEventDAO(connect());
		List<MarketingEventBean> mevents = medao.list();
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
		medao = new MarketingEventDAO(connect());
        int eid = Integer.parseInt(request.getParameter("eid"));
        MarketingEventBean existingmevent = medao.get(eid);
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
		medao = new MarketingEventDAO(connect());
        String title = medao.title();
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
        mevent.setMeventpicture(pic.readAllBytes());
        mevent.setMeventstartdate(startdate);
        mevent.setMeventenddate(enddate);
        mevent.setMeventname(name);
        mevent.setMeventdescription(description);
        mevent.setMeventtypeid(typeid);
        mevent.setMeventownerid(ownerid);
        mevent.setMeventonline(online);	
        medao.insert(mevent);
        response.sendRedirect("/EEIT3101/mevent");
    }
	
	private void updateMEvent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		medao = new MarketingEventDAO(connect());
		int id=Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		InputStream pic;
		if(request.getPart("pic").getSubmittedFileName()=="") {
			pic = new ByteArrayInputStream(medao.get(id).getMeventpicture());
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
        mevent.setMeventpicture(pic.readAllBytes());
        mevent.setMeventstartdate(startdate);
        mevent.setMeventenddate(enddate);
        mevent.setMeventname(name);
        mevent.setMeventdescription(description);
        mevent.setMeventtypeid(typeid);
        mevent.setMeventownerid(ownerid);
        mevent.setMeventonline(online);    
        medao.update(mevent);
        response.sendRedirect("/EEIT3101/mevent");
    }
	
	private void deleteMEvent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int eid=Integer.parseInt(request.getParameter("eid"));
		MarketingEventBean mevent = new MarketingEventBean();
	    mevent.setMeventid(eid);
	    medao = new MarketingEventDAO(connect());
        medao.delete(mevent);
        response.sendRedirect("/EEIT3101/mevent");
    }
	
	private void queryMEvent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String name=request.getParameter("name");
		System.out.println(name);
		String sql="SELECT * FROM MarketingEvent WHERE meventname LIKE '%"+name+"%'";
		System.out.println(sql);
		medao = new MarketingEventDAO(connect());
		List<MarketingEventBean> mevents =medao.query(sql);
		request.setAttribute("mevents", mevents);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mevent/ListMEvent.jsp");
        dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
