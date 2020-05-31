package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.FormBean;
import com.revature.dao.FormDAOImpl;
import com.revature.dao.ReimbursementDaoImpl;


public class ReimbursementDeny extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in doPostReimbursement");
		//FormBean r=null;
		ObjectMapper mapper= new ObjectMapper();
		//convert JSON to java object
		int id = mapper.readValue(request.getParameter("formId"),Integer.class);
		System.out.println();
		ReimbursementDaoImpl rdi= new ReimbursementDaoImpl();
		request.getRequestDispatcher("Consult.html").include (request, response);
		try {
			rdi.insertStatusDeny(id);
			PrintWriter pw=response.getWriter();
			pw.write("<h3>Added status</h3>");
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
