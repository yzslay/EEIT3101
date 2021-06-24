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
	private static final String SQL = "UPDATE event SET  eventname = ?, eventdate = ?, eventstarttime = ?,eventendtime =? "
			+ " eventlocation = ?, eventtype = ?, eventtype1 = ?, eventtype2 = ?,eventcustom =?   "
			+ "eventmaxlimit = ?, eventfee = ?, eventdescribe = ?,  hostid=100001"
			+ "WHERE eventID = ?";
	
	Connection conn ;

    public ModifyEvent() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/petpet");
			conn = ds.getConnection();
		
		EventBean.setEventID((Int)(request.getParameter("eventname")));
		EventBean.setEname((String)(request.getParameter("eventdate")));
		EventBean.setHiredate((String)(request.getParameter("eventstarttime")));
		EventBean.setSalary((String)(request.getParameter("eventendtime")));
		EventBean.setDeptno((String)(request.getParameter("eventlocation")));
		EventBean.setTitle((String)(request.getParameter("eventtype")));
		EventBean.setEmpno((String)(request.getParameter("eventtype1")));
		EventBean.setEname((String)(request.getParameter("eventtype2")));
		EventBean.setHiredate((String)(request.getParameter("eventcustom")));
		EventBean.setSalary((String)(request.getParameter("eventmaxlimit")));
		EventBean.setDeptno((String)(request.getParameter("eventfee")));
		EventBean.setTitle((String)(request.getParameter("eventdescribe")));
		EventBean.setTitle((String)(request.getParameter("eventdescribe")));
         
        PreparedStatement statement = conn.prepareStatement(SQL);
        statement.setString(6, empbean.getEmpno());
        statement.setString(1, empbean.getEname());
        statement.setString(2, empbean.getHiredate());
        statement.setString(3, empbean.getSalary());
        statement.setString(4, empbean.getDeptno());
        statement.setString(5, empbean.getTitle());        
        boolean rowInserted = statement.executeUpdate() > 0;
        System.out.println(rowInserted);
        if (rowInserted) {
        	request.setAttribute("emps", empbean);
        	request.getRequestDispatcher("/HW/correct.jsp").forward(request,response);    	
	    }else {
        	request.getRequestDispatcher("/HW/error.html").forward(request,response);
        }

		}catch (SQLException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/HW/error.html").forward(request,response);
		}
		catch(Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/HW/error.html").forward(request,response);
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
