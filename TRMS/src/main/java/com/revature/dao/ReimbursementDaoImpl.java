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
import com.revature.beans.ReimbursementBean;
import com.revature.util.ConnFactory;

public class ReimbursementDaoImpl {
	public static ConnFactory banana=ConnFactory.getInstance();
	
	public void insertStatusDeny(int id) throws SQLException {
		
		Connection conn = banana.getConnection();
		String sql="UPDATE FORM_EMPLOYEE SET STATUS = 'DENIED' WHERE FORM_ID = ?";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		ps.executeUpdate();
	
	}
	
	public void insertStatusApprove(int id) throws SQLException {
		
		Connection conn = banana.getConnection();
		String sql="UPDATE FORM_EMPLOYEE SET STATUS = 'APPROVED' WHERE FORM_ID = ?";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		ps.executeUpdate();
	
	}
	
	
	public List<ReimbursementBean> getR() throws SQLException {
		List<ReimbursementBean> userList = new ArrayList <ReimbursementBean>();
		ReimbursementBean user=null;
		Connection conn =banana.getConnection();
		Statement stmt=conn.createStatement();
		String sql = "SELECT * FROM REIMBURSEMENT";
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println(rs);
		while (rs.next()) {
			user = new ReimbursementBean (rs.getInt(1), rs.getString(2), rs.getInt(3));
			userList.add(user);
		}
		return userList;
	}

}
