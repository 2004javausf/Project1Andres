package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.FormBean;
import com.revature.beans.RegisterBean;
import com.revature.util.ConnFactory;

public class FormDAOImpl {
	public static ConnFactory banana=ConnFactory.getInstance();
	
	public FormBean getFormById(int id) throws SQLException {
		FormBean fr = null;
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM FORM_EMPLOYEE WHERE FORM_ID=" +id);
		while (rs.next()) {
			fr=new FormBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getInt(9), rs.getString(10));
		}
		return fr;
	}
	
	//insert row
		public void insertForm(FormBean fr) throws SQLException {
			Connection conn = banana.getConnection();
			String sql="INSERT INTO FORM_EMPLOYEE VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,  fr.getForm_id());
			ps.setString(2,  fr.getEmp_name());
			ps.setString(3,  fr.getEmp_last_name());
			ps.setString(4,  fr.getLocation());
			ps.setFloat(5,  fr.getCost_ammount());
			ps.setDate(6, new java.sql.Date(fr.getdStart().getTime()));
			ps.setDate(7, new java.sql.Date(fr.getdEnd().getTime()));
			ps.setString(8,  fr.getType_course());
			ps.setInt(9,  fr.getGrade());
			ps.setString(10,  fr.getStatus());
			ps.executeUpdate();
		}
		
		public void insertStatus(FormBean fr) throws SQLException {
			Connection conn = banana.getConnection();
			String sql="INSERT INTO FORM_EMPLOYEE (SELECT) VALUES ('accepted')";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(10,  fr.getStatus());
			ps.executeUpdate();
		}
		
}
