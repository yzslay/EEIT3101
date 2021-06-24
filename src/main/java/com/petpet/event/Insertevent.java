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

@WebServlet("/insertevent")
public class Insertevent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  String SQL = "INSERT INTO event (empno,ename,hiredate,salary,deptno,title) VALUES (?, ?, ?,?, ?, ?)";
	Connection conn ;

    public Insertevent() {
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
		EmpBean empbean = new EmpBean();
		
		empbean.setEmpno((String)(request.getParameter("empno")));
		empbean.setEname((String)(request.getParameter("ename")));
		empbean.setHiredate((String)(request.getParameter("hiredate")));
		empbean.setSalary((String)(request.getParameter("salary")));
		empbean.setDeptno((String)(request.getParameter("deptno")));
		empbean.setTitle((String)(request.getParameter("title")));
         
        PreparedStatement statement = conn.prepareStatement(SQL);
        statement.setString(1, empbean.getEmpno());
        statement.setString(2, empbean.getEname());
        statement.setString(3, empbean.getHiredate());
        statement.setString(4, empbean.getSalary());
        statement.setString(5, empbean.getDeptno());
        statement.setString(6, empbean.getTitle());        
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
