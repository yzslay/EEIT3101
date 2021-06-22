package com.petpet.event;

import java.io.IOException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import com.petpet.bean.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Getallevent")
public class GetEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn ;
    private static final String SQL="select * from event";
    
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
//			stmt.setString(1,empno);
			ResultSet rs= stmt.executeQuery();
			List<EventBean> events = new ArrayList<>();
			EventBean event = null ;
			while (rs.next()) {
				event = new EventBean();
				event.setEventID(rs.getInt("EventID"));
				event.setHostID(rs.getInt("HostID"));
				event.setEventName(rs.getString("EventName"));
				events.add(event);
				System.out.println(rs.getInt("EventID")) ;
			}
			request.setAttribute("events", events);
			stmt.close();
			request.getRequestDispatcher("/event/getallevent.jsp").forward(request,response);
			System.out.println("mooo") ;
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