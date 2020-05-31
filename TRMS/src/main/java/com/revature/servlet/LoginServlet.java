	
	package com.revature.servlet;

	import java.io.IOException;
	import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
	import com.fasterxml.jackson.databind.ObjectMapper;
	import com.revature.beans.RegisterBean;
	import com.revature.dao.FormDAOImpl;
	import com.revature.dao.LoginDaoImpl;




	public class LoginServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		String username=null;
		String pass_word = null;
		Connection con=null;
		
		/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("in doGetReg");
			 ObjectMapper mapper= new ObjectMapper();
			 LoginDaoImpl frdi= new LoginDaoImpl();
			 int id=mapper.readValue(request.getParameter("frid"), Integer.class);
			 PrintWriter pw = response.getWriter();
			 String rJSON;
			 	
				try {
					rJSON = mapper.writeValueAsString(frdi.getRegById(null));
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					pw.print(rJSON);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pw.flush();
			
			}*/
		
		
		
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			RegisterBean reg=null;
			ObjectMapper mapp= new ObjectMapper();
			//convert JSON to java object
			reg=mapp.readValue(request.getInputStream(), RegisterBean.class);
			System.out.println();
			LoginDaoImpl regdi= new LoginDaoImpl();
			try {
				regdi.insertRegistration(reg);
				PrintWriter pw=response.getWriter();
				pw.write("<h3>Added username and password</h3>");
				pw.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		/*protected void doPost2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("validation post");
			username = request.getParameter("username");
			pass_word = request.getParameter("pass_word");
			String q = "SELECT * FROM LOGIN WHERE USERNAME ="+username+"";
			
		
			try {
				Statement st = con.createStatement();
				ResultSet rs =st.executeQuery(q);
				
				String username = null;
				String pass_word = null;
				while(rs.next())
				{
					username=rs.getString(2);
					pass_word=rs.getString(3);
				}
				
				if(username.equals(username)&&pass_word.equals(pass_word)) {
					System.out.println("LoginSuccess");
					request.getRequestDispatcher("fr.html").include(request, response);
				}	
				else {
					System.out.println("login failure");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			}*/
		
		}
		
		

	


