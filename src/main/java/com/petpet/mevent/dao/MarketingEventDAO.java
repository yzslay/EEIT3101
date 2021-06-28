package com.petpet.mevent.dao;

import java.io.ByteArrayInputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import com.petpet.bean.mevent.MarketingEventBean;


public class MarketingEventDAO {
	
private Connection conn;
	
	protected void disconnect() throws SQLException {
		if (conn != null && !conn.isClosed()) {
            conn.close();
        }
	}
		
	public List<MarketingEventBean> list() throws SQLException{
		List<MarketingEventBean> listbean = new ArrayList<>();
		String sql = "SELECT * FROM MarketingEvent";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			MarketingEventBean bean =new MarketingEventBean();
			bean.setMeventid(rs.getInt("meventid"));
			bean.setMeventtitle(rs.getString("meventtitle"));
			if(rs.getObject("meventpicture")==null) {}else{bean.setMeventpicture(rs.getBlob("meventpicture").getBytes(1, (int)rs.getBlob("meventpicture").length()));};
			bean.setMeventstartdate(rs.getTimestamp("meventstartdate"));
			bean.setMeventenddate(rs.getTimestamp("meventenddate"));
			bean.setMeventname(rs.getString("meventname"));
			bean.setMeventdescription(rs.getString("meventdescription"));
			bean.setMeventtypeid(rs.getInt("meventtypeid"));
			bean.setMeventownerid(rs.getInt("meventownerid"));
			bean.setMeventonline(rs.getBoolean("meventonline"));
			listbean.add(bean);
		}
		rs.close();
		stmt.close();
		disconnect();
		return listbean;
	};
	
	public List<MarketingEventBean> query(String sql) throws SQLException{
		List<MarketingEventBean> listbean = new ArrayList<>();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			MarketingEventBean bean =new MarketingEventBean();
			bean.setMeventid(rs.getInt("meventid"));
			bean.setMeventtitle(rs.getString("meventtitle"));
			if(rs.getObject("meventpicture")==null) {}else{bean.setMeventpicture(rs.getBlob("meventpicture").getBytes(1, (int)rs.getBlob("meventpicture").length()));};
			bean.setMeventstartdate(rs.getTimestamp("meventstartdate"));
			bean.setMeventenddate(rs.getTimestamp("meventenddate"));
			bean.setMeventname(rs.getString("meventname"));
			bean.setMeventdescription(rs.getString("meventdescription"));
			bean.setMeventtypeid(rs.getInt("meventtypeid"));
			bean.setMeventownerid(rs.getInt("meventownerid"));
			bean.setMeventonline(rs.getBoolean("meventonline"));
			listbean.add(bean);
		}
		rs.close();
		stmt.close();
		disconnect();
		return listbean;
	};
	
	public MarketingEventBean get(int eid) throws SQLException{
		String sql = "SELECT * FROM MarketingEvent WHERE meventid = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,eid);
		ResultSet rs = stmt.executeQuery();
		MarketingEventBean bean = new MarketingEventBean();
		if(rs.next()) {
			bean.setMeventid(rs.getInt("meventid"));
			bean.setMeventtitle(rs.getString("meventtitle"));
			if(rs.getObject("meventpicture")==null) {}else{bean.setMeventpicture(rs.getBlob("meventpicture").getBytes(1, (int)rs.getBlob("meventpicture").length()));};
			bean.setMeventstartdate(rs.getTimestamp("meventstartdate"));
			bean.setMeventenddate(rs.getTimestamp("meventenddate"));
			bean.setMeventname(rs.getString("meventname"));
			bean.setMeventdescription(rs.getString("meventdescription"));
			bean.setMeventtypeid(rs.getInt("meventtypeid"));
			bean.setMeventownerid(rs.getInt("meventownerid"));
			bean.setMeventonline(rs.getBoolean("meventonline"));
		}
		rs.close();
		stmt.close();
		return bean;
	};
	
	public boolean insert(MarketingEventBean bean) throws SQLException {
		String sql = "INSERT INTO MarketingEvent (meventtitle,meventpicture,"
				+ "meventstartdate,meventenddate,meventname,meventdescription,meventtypeid,"
				+ "meventownerid,meventonline) VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, bean.getMeventtitle());
		if(bean.getMeventpicture().length==0) {
			stmt.setBinaryStream(2, null);
		}else {
			stmt.setBinaryStream(2, new ByteArrayInputStream(bean.getMeventpicture()));
			};
		stmt.setTimestamp(3, bean.getMeventstartdate());
		stmt.setTimestamp(4, bean.getMeventenddate());
		stmt.setString(5, bean.getMeventname());
		stmt.setString(6, bean.getMeventdescription());
		stmt.setInt(7, bean.getMeventtypeid());
		stmt.setInt(8, bean.getMeventownerid());
		stmt.setBoolean(9, bean.isMeventonline());
		boolean inserted = stmt.executeUpdate()>0;
		stmt.close();
		disconnect();
		return inserted;
	};
	
	public boolean update(MarketingEventBean bean) throws SQLException {
		String sql = "UPDATE MarketingEvent SET meventtitle=?,meventpicture=?,meventstartdate=?,meventenddate=?,meventname=?,meventdescription=?,meventtypeid=?,meventownerid=?,meventonline=? WHERE meventid=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, bean.getMeventtitle());
		if(bean.getMeventpicture()==null) {stmt.setBinaryStream(2, null);}else{stmt.setBinaryStream(2, new ByteArrayInputStream(bean.getMeventpicture()));}
		stmt.setTimestamp(3, bean.getMeventstartdate());
		stmt.setTimestamp(4, bean.getMeventenddate());
		stmt.setString(5, bean.getMeventname());
		stmt.setString(6, bean.getMeventdescription());
		stmt.setInt(7, bean.getMeventtypeid());
		stmt.setInt(8, bean.getMeventownerid());
		stmt.setBoolean(9, bean.isMeventonline());
		stmt.setInt(10, bean.getMeventid());
		boolean updated = stmt.executeUpdate()>0;
		stmt.close();
		disconnect();
		return updated;
	};
	
	public boolean delete(MarketingEventBean bean) throws SQLException {
		String sql = "DELETE FROM MarketingEvent WHERE meventid = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, bean.getMeventid());
		boolean deleted = stmt.executeUpdate()>0;
		stmt.close();
		disconnect();
		return deleted;
	};
	
	public String title() throws SQLException{
		String sqlcount = "{call count_event(?,?)}";
		String title=new SimpleDateFormat("yyyyMMdd").format(new Date())+"ME";
		String sql = "'"+title+"%'";
		CallableStatement cstmt = conn.prepareCall(sqlcount);
		cstmt.setString(1,sql);
		cstmt.registerOutParameter(2, Types.INTEGER);
		cstmt.execute();
		int num = cstmt.getInt(2);
		title=title+(num+1);
		cstmt.close();
		return title;
	}
	
	//getter setter
		public Connection getConn() {
			return conn;
		}
		public void setConn(Connection conn) {
			this.conn = conn;
		}
		
		//constructor
		public MarketingEventDAO() {}
		
		public MarketingEventDAO(Connection conn) {
			this.conn=conn;
		}
}
