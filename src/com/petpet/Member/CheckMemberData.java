package com.petpet.Member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/CheckMemberData")
public class CheckMemberData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String QUERY = "SELECT * FROM Member WHERE email = ? AND password = ?";
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean check= false;
		
		Connection conn = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/petpet");
			conn = ds.getConnection();

			
			PreparedStatement stmtp = conn.prepareStatement(QUERY);
			stmtp.setString(1, email);
			stmtp.setString(2, password);

			ResultSet rs = stmtp.executeQuery();
			
			LoginBean member = null;
			while(rs.next()) {
				member = new LoginBean();
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("password"));
				
				if((member.getEmail().equals(email))&&(member.getPassword().equals(password))) {
					check = true;
					request.setAttribute("member", member);
				}
			}
			
			stmtp.close();
			
			if(check==true) {
				request.getRequestDispatcher("/MyTestLab/LoginTrue.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/MyTestLab/LoginFail.jsp").forward(request, response);
			}
			


		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
