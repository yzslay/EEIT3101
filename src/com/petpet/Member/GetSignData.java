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

import com.petpet.bean.LoginBean;


@WebServlet("/GetSignData")
public class GetSignData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INSERT = "INSERT INTO Member (Email,Password) VALUES (?, ?)";
	private static final String QUERY = "SELECT * FROM Member WHERE email = ?";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Connection conn = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/petpet");
			conn = ds.getConnection();

			PreparedStatement stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, email);
			stmt.setString(2, password);
			stmt.executeUpdate();

			stmt.close();
			
			PreparedStatement stmtp = conn.prepareStatement(QUERY);
			stmtp.setString(1, email);

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
			
			request.getRequestDispatcher("/Member/MemberCenter.jsp").forward(request, response);


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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
