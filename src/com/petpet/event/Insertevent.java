package com.petpet.event;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import com.petpet.bean.EventBean;

@WebServlet("/insertevent")
public class Insertevent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  String SQL = "INSERT into event  (eventname, eventdate, eventstarttime,eventendtime, eventlocation , eventtype , eventtype1 "
			+ ", eventtype2 ,eventtypecustom , eventmaxlimit , eventfee , eventdescribe ,  hostid, eventStatus) "
			+ "VALUES (?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ? , ?, 1)";
	
	Connection conn ;

    public Insertevent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8"); 
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/petpet");
			conn = ds.getConnection();
			EventBean eventbean = new EventBean();
			eventbean.setEventName((String)(request.getParameter("eventname")));
			eventbean.setEventDate((String)(request.getParameter("eventdate")));
			eventbean.setEventStratTime((String)(request.getParameter("eventstarttime")));
			eventbean.setEventEndTime((String)(request.getParameter("eventendtime")));
			eventbean.setEventLocation((String)(request.getParameter("eventlocation")));
			eventbean.setEventType((String)(request.getParameter("eventtype")));
			eventbean.setEventType1((String)(request.getParameter("eventtype1")));
			eventbean.setEventType2((String)(request.getParameter("eventtype2")));
			eventbean.setEventTypeCustom((String)(request.getParameter("eventtypecustom")));
			eventbean.setEventMaxLimit(Integer.parseInt(request.getParameter("eventmaxlimit")));
			eventbean.setEventFee(Integer.parseInt(request.getParameter("eventfee")));
			eventbean.setEventDescribe((String)(request.getParameter("eventdescribe")));
			
			PreparedStatement statement = conn.prepareStatement(SQL);
			statement.setString(1, eventbean.getEventName());
			statement.setString(2, eventbean.getEventDate());
			statement.setString(3, eventbean.getEventStratTime());
			statement.setString(4, eventbean.getEventEndTime());
			statement.setString(5, eventbean.getEventLocation());
			statement.setString(6, eventbean.getEventType());
			statement.setString(7, eventbean.getEventType1());
			statement.setString(8, eventbean.getEventType2());
			statement.setString(9, eventbean.getEventTypeCustom());
			statement.setInt(10, eventbean.getEventMaxLimit());
			statement.setInt(11, eventbean.getEventFee());   
			statement.setString(12, eventbean.getEventDescribe());   
			statement.setInt(13, 100001);
	        boolean rowInserted = statement.executeUpdate() > 0;
	        System.out.println(rowInserted);
	        if (rowInserted) {
	        	request.setAttribute("event", eventbean);
	        	request.getRequestDispatcher("/event/correct.jsp").forward(request,response);    	
		    }else {
	        	request.getRequestDispatcher("/event/error.html").forward(request,response);
	        }
	
			}catch (SQLException e) {
				e.printStackTrace();
				request.getRequestDispatcher("/event/error.html").forward(request,response);
			}
			catch(Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("/event/error.html").forward(request,response);
			} finally {
				if (conn != null)
					try {
						conn.close();
					} catch(SQLException e) { 
						e.printStackTrace();
					}

		}
	}
}
