package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.FormBean;
import com.revature.beans.RegisterBean;
import com.revature.util.ConnFactory;

public class LoginDaoImpl {
	
	public static ConnFactory banana=ConnFactory.getInstance();
	
	
	/*public RegisterBean getRegById(RegisterBean r) throws SQLException {
		RegisterBean fr = null;
		Connection conn = banana.getConnection();
		String sql=("SELECT * FROM LOGIN WHERE USERNAME = ? AND PASS_WORD = ?");
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(2, r.getUsername());
		ps.setString(3, r.getPass_word());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			fr=new RegisterBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
		return fr;
	}*/

	public void insertRegistration(RegisterBean reg) throws SQLException {
		Connection conn = banana.getConnection();
		String sql="INSERT INTO LOGIN VALUES (?, ?, ?, ?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1,  reg.getLogin_id());
		ps.setString(2,  reg.getUsername());
		ps.setString(3,  reg.getPass_word());
		ps.setString(4,  reg.getRole_name());
		ps.executeUpdate();
	
	}
	
	public List<RegisterBean> getLogin() throws SQLException {
		List<RegisterBean> userList = new ArrayList <RegisterBean>();
		RegisterBean user=null;
		Connection conn =banana.getConnection();
		Statement stmt=conn.createStatement();
		String sql = "SELECT * FROM LOGIN";
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println(rs);
		while (rs.next()) {
			user = new RegisterBean (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			userList.add(user);
		}
		return userList;
	}
	
}
