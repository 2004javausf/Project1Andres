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
import com.revature.beans.RegisterBean;
import com.revature.dao.FormDAOImpl;



public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet Formservlet");
		RegisterBean reg=null;
		 ObjectMapper mapper= new ObjectMapper();
		 FormDAOImpl frdi= new FormDAOImpl();
		 int id=mapper.readValue(request.getParameter("frid"), Integer.class);
		 //reg=mapper.readValue(request.getInputStream(), RegisterBean.class);
		 PrintWriter pw = response.getWriter();
		 String frJSON;
		 
			try {
				frJSON = mapper.writeValueAsString(frdi.getFormById(id));
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
	
	
	public static String amount;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("in doPost FormServlet");
		FormBean fr=null;
		ObjectMapper mapper= new ObjectMapper();
		//amount = request.getParameter("cost_ammount");
		//System.out.println(amount);
		//convert JSON to java object
		fr=mapper.readValue(request.getInputStream(), FormBean.class);
		System.out.println();
		FormDAOImpl frdi= new FormDAOImpl();
		try {
			frdi.insertForm(fr);
			PrintWriter pw=response.getWriter();
			pw.write("<h3>Added info</h3>");
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

}
