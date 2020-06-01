package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.RegisterBean;
import com.revature.dao.LoginDaoImpl;
import com.revature.util.ConnFactory;

/**
 * Servlet implementation class LoginValidation
 */
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static ConnFactory banana=ConnFactory.getInstance();
	//static RegisterBean employee = new RegisterBean();
	
	public static String username;
	public static String pass_word;
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		username = request.getParameter("username");
		pass_word = request.getParameter("pass_word");
		System.out.println("in do post loginvalidation");
		System.out.println(username+" "+pass_word);
		LoginDaoImpl rdi = new LoginDaoImpl();
		List <RegisterBean> UserList = new ArrayList<RegisterBean>();
		
		RegisterBean user = new RegisterBean();
		boolean l=false;
		
		try {
			UserList = rdi.getLogin();
			System.out.println(UserList);
			for (int i=0;i<UserList.size();i++) {
				if(UserList.get(i).getUsername().equalsIgnoreCase(username) && (UserList.get(i).getPass_word().equals(pass_word))){
					user=UserList.get(i);
					l=true;
				}
			}
		
		
		System.out.println(user);
		String name = user.getUsername();
		if(l==true) {
			HttpSession session = request.getSession();
			session.setAttribute("username", user);
			
			if (user.getRole_name().equalsIgnoreCase("Benefits_Coordinator") || user.getRole_name().equalsIgnoreCase("Direct_Supervisor") || user.getRole_name().equalsIgnoreCase("Department_Head")) {
				request.getRequestDispatcher("Consult.html").include (request, response);
				
			}
			else {
				request.getRequestDispatcher("fr.html").include (request, response);
			}
		}else {
			pw.print("Invalid credentials");
			request.getRequestDispatcher("Login.html").include (request, response);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
	}

	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("validation post");
		response.setContentType("text/html");
		ObjectMapper mapp= new ObjectMapper();
		Connection conn = banana.getConnection();
		request.getRequestDispatcher("Login.html").include(request, response);
		username = request.getParameter("username");
		pass_word = request.getParameter("pass_word");
		String u = null;
		String p = null;
		System.out.println(username+" "+pass_word);
		String q = "SELECT * FROM LOGIN WHERE USERNAME ="+username+" AND PASS_WORD ="+pass_word;
		if(u.equals("admin") && p.equals("admin")) {
			System.out.println("LoginSuccess");
			//HttpSession session= request.getSession();
			request.getRequestDispatcher("fr.html").include(request, response);
		}
	
		try {
			PreparedStatement st = conn.prepareStatement(q);
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
				//HttpSession session= request.getSession();
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
