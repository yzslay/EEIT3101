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

import com.lcpan.bean.EmpBean;

@WebServlet("/ToDeleteMember")
public class ToDeleteMember extends HttpServlet {
	private static final String DELETE ="DELETE FROM member WHERE memberid = ?";
	private static final String QUERY = "SELECT * FROM member";
	private static final long serialVersionUID = 1L;
       
	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String memberid = request.getParameter("memberid");
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/petpet");
			conn = ds.getConnection();
			System.out.print(memberid);
			PreparedStatement stmt = conn.prepareStatement(DELETE);
			stmt.setString(1, memberid);
			
			stmt.executeUpdate();
			stmt.close();
			
			PreparedStatement stmtp = conn.prepareStatement(QUERY);
			
			ResultSet rs = stmtp.executeQuery();
			List<LoginBean> memberData = new ArrayList<>();
			LoginBean member = null;
			while(rs.next()) {
				member = new LoginBean();
				member.setMemberid(rs.getString("memberid"));
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("password"));
				member.setFirstname(rs.getString("firstname"));
				member.setLastname(rs.getString("lastname"));
				member.setGender(rs.getString("gender"));
				member.setBirthday(rs.getString("birthday"));
				member.setMobile(rs.getString("mobile"));
				memberData.add(member);
			}
			request.setAttribute("memberData", memberData);
			stmtp.close();
			request.getRequestDispatcher("/MyTestLab/MemberDelete.jsp").forward(request, response);

		}catch (SQLException e) {
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
