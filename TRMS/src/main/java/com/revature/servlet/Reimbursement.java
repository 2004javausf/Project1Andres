package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.FormBean;
import com.revature.beans.ReimbursementBean;
import com.revature.dao.FormDAOImpl;
import com.revature.dao.ReimbursementDaoImpl;


public class Reimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet Reimbursement");
		 ObjectMapper mapper= new ObjectMapper();
		 ReimbursementDaoImpl frdi= new ReimbursementDaoImpl();
		 int id=mapper.readValue(request.getParameter("frid"), Integer.class);
		 PrintWriter pw = response.getWriter();
		 String frJSON;
		 
			try {
				frJSON = mapper.writeValueAsString(frdi.getR());
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				pw.print(frJSON);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.flush();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in doPostReimbursement");
		FormBean r=null;
		ObjectMapper mapper= new ObjectMapper();
		//convert JSON to java object
		int id = mapper.readValue(request.getParameter("formId"),Integer.class);
		System.out.println();
		ReimbursementDaoImpl rdi= new ReimbursementDaoImpl();
		request.getRequestDispatcher("Consult.html").include (request, response);
		try {
			rdi.insertStatusApprove(id);
			PrintWriter pw=response.getWriter();
			pw.write("<h3>Added status</h3>");
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
	}

}
