package com.petpet.event;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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


@WebServlet("/deleteevent")
public class deleteevent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  String SQLDelete = "DELETE FROM event where eventid = ? ";
	private  String SQL = "select * from event where eventid =  ?";
	Connection conn ;

    public deleteevent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8"); 
			String eventid = request.getParameter("eventid");
			
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/petpet");
			conn = ds.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(SQL);
			stmt.setString(1,eventid);
			ResultSet rs= stmt.executeQuery();
			EventBean event = new EventBean();
			if (rs.next()) {
				event.setEventID(rs.getInt("eventid"));
				event.setEventName(rs.getString("eventname"));
				event.setEventDate(rs.getString("eventdate"));
				event.setEventStratTime(rs.getTimestamp("eventstarttime"));
				event.setEventEndTime(rs.getTimestamp("eventendtime"));
				event.setEventLocation(rs.getString("eventlocation"));
				event.setEventType(rs.getString("eventtype"));
				event.setEventType1(rs.getString("eventtype1"));
				event.setEventType2(rs.getString("eventtype2"));
				event.setEventTypeCustom(rs.getString("eventtypecustom"));
				event.setEventMaxLimit(rs.getInt("eventmaxlimit"));
				event.setEventFee(rs.getInt("eventfee"));	
				event.setEventDescribe((rs.getString("eventdescribe")));
		
			}
			request.setAttribute("event", event);

			PreparedStatement stmtdelete = conn.prepareStatement(SQLDelete);
			stmtdelete.setString(1,eventid);								
	        boolean rowInserted = stmtdelete.executeUpdate() > 0;
	        System.out.println(rowInserted);
	        if (rowInserted) {
	        	request.getRequestDispatcher("/event/deletecorrect.jsp").forward(request,response);    	
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
