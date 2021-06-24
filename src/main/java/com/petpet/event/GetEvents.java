package com.petpet.event;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.petpet.bean.EventBean;

@WebServlet("/Getallevent")
public class GetEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SQL="select * from event";

    Connection conn ;
    
    public GetEvents() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/petpet");
			conn = ds.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(SQL);
			ResultSet rs= stmt.executeQuery();	
			List<EventBean> events = new ArrayList<>();
			EventBean event = null ;

			while (rs.next()) {
				event = new EventBean();
				event.setEventName(rs.getString("eventname"));
				event.setEventDate(rs.getString("eventdate"));
//				System.out.println(rs.getString("eventstrattime"));  

				event.setEventStratTime(rs.getTimestamp("eventstarttime"));
				event.setEventEndTime(rs.getTimestamp("eventendtime"));
				event.setEventLocation(rs.getString("eventlocation"));
				event.setEventType1(rs.getString("eventtype1"));
				event.setEventType2(rs.getString("eventtype2"));
				event.setEventMaxLimit(rs.getInt("eventmaxlimit"));
				event.setEventFee(rs.getInt("eventfee"));				
				events.add(event);
	
			}
			request.setAttribute("events", events);		
//			EventBean event = null ;
//			EmpBean emp = null;
//			event.setEventName((String)rs.getString("EventName"));
//			emp.setEname(rs.getString("ename"));
		
			stmt.close();
//			System.out.println(event.getEventName()) ;
//			System.out.println(emp.getEname()) ;
			request.getRequestDispatcher("/event/getallevent.jsp").forward(request,response);
			System.out.println("¶]¨ì³Ì«á") ;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
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