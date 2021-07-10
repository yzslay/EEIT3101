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

import com.petpet.bean.EmpBean;
import com.petpet.bean.EventBean;

@WebServlet("/ModifyEvent")
public class ModifyEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SQL = "UPDATE event SET eventname = ?, eventdate = ?, eventstarttime = ?,eventendtime =? , eventlocation = ?, eventtype = ?, eventtype1 = ?, eventtype2 = ?,eventtypecustom =?  , eventmaxlimit = ?, eventfee = ?, eventdescribe = ?,  hostid=100001  WHERE eventid = ?";
	
	Connection conn ;

    public ModifyEvent() {
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
			EventBean event = new EventBean();
			event.setEventID(Integer.parseInt(request.getParameter("eventid")));
			event.setEventName((String)(request.getParameter("eventname")));
			event.setEventDate((String)(request.getParameter("eventdate")));
			event.setEventStratTime((String)(request.getParameter("eventstarttime")));
			event.setEventEndTime((String)(request.getParameter("eventendtime")));
			event.setEventLocation((String)(request.getParameter("eventlocation")));
			event.setEventType((String)(request.getParameter("eventtype")));
			event.setEventType1((String)(request.getParameter("eventtype1")));
			event.setEventType2((String)(request.getParameter("eventtype2")));
			event.setEventTypeCustom((String)(request.getParameter("eventtypecustom")));
			event.setEventMaxLimit(Integer.parseInt(request.getParameter("eventmaxlimit")));
			event.setEventFee(Integer.parseInt(request.getParameter("eventfee")));
			event.setEventDescribe((String)(request.getParameter("eventdescribe")));
         
			PreparedStatement statement = conn.prepareStatement(SQL);
			statement.setString(1, event.getEventName());
			statement.setString(2, event.getEventDate());
			statement.setString(3, event.getEventStratTime());
			statement.setString(4, event.getEventEndTime());
			statement.setString(5, event.getEventLocation());
			statement.setString(6, event.getEventType());
			statement.setString(7, event.getEventType1());
			statement.setString(8, event.getEventType2());
			statement.setString(9, event.getEventTypeCustom());
			statement.setInt(10, event.getEventMaxLimit());
			statement.setInt(11, event.getEventFee());   
			statement.setString(12, event.getEventDescribe());   
			statement.setInt(13, event.getEventID());   
			boolean rowInserted = statement.executeUpdate() > 0;
			System.out.println(rowInserted);
			if (rowInserted) {
				request.setAttribute("event", event);
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
