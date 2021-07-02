package com.petpet.Member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String QUERY = "SELECT * FROM Member WHERE memberid = ?";
	private static final String UPDATE = "UPDATE Member SET firstname = ?, lastname = ?, "
			+ "gender = ?, birthday = ?,mobile =? WHERE memberid = ?";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String memberid = request.getParameter("memberid");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String mobile = request.getParameter("mobile");
		
		Connection conn = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/petpet");
			conn = ds.getConnection();

			PreparedStatement stmt = conn.prepareStatement(UPDATE);
			stmt.setString(1, firstname);
			stmt.setString(2, lastname);
			stmt.setString(3, gender);
			stmt.setString(4, birthday);
			stmt.setString(5, mobile);
			stmt.setString(6, memberid);
			stmt.executeUpdate();

			stmt.close();
			
			
			PreparedStatement stmtp = conn.prepareStatement(QUERY);
			stmtp.setString(1, memberid);

			ResultSet rs = stmtp.executeQuery();
			
			LoginBean member = new LoginBean();
			if (rs.next()) {
				member.setMemberid(rs.getString("memberid"));
				member.setFirstname(rs.getString("firstname"));
				member.setLastname(rs.getString("lastname"));
				member.setGender(rs.getString("gender"));
				member.setBirthday(rs.getString("Birthday"));
				member.setMobile(rs.getString("mobile"));
			}
			
			request.setAttribute("member", member);
			stmtp.close();
			
			request.getRequestDispatcher("/MyTestLab/MemberShow.jsp").forward(request, response);


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
