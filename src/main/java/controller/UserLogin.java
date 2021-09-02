package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import context.DBContext;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    
    
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query="select * from Account where user_mail=? and password=? ";
		PreparedStatement stm=null;
		
		  
		/*
		 * if(session!=null){ String name=(String)session.getAttribute("name"); if
		 * (session.getAttribute("username") !=null) {
		 * response.sendRedirect("test.jsp"); return; }
		 */
		
       
		 
		try {	        	
			request.getSession(true).invalidate();
	        HttpSession session=request.getSession(true);
			Connection conn= new DBContext().getConnection();
			
						
			String regexEmail = "^[A-Z0-9_a-z]+@[A-Z0-9_a-z]+\\.[A-Za-z\\.]{2,6}$";
			String regexPass = "[A-Z0-9a-z]+";

			String emailGetFromForm = request.getParameter("username");
			String passGetFromForm = request.getParameter("password");
			//String remember = request.getParameter("remember");
		
			
			if (!passGetFromForm.matches(regexPass) || !emailGetFromForm.matches(regexEmail)) {
				session.setAttribute("error", "invalid syntax");
				RequestDispatcher rd= request.getRequestDispatcher("UserLogin.jsp");
				rd.forward(request, response);
		
				return;
			}
			
			
			stm=conn.prepareStatement(query);
			stm.setString(1, emailGetFromForm);
			stm.setString(2, passGetFromForm);
			ResultSet rs=stm.executeQuery();
			if(rs.next()) {
				response.getWriter().println("Account login successful");
				session.setAttribute("username",emailGetFromForm);
				
				RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
				rd.include(request, response);									
				return;
			}else {
				session.setAttribute("error", "wrong username or password");
				RequestDispatcher rd= request.getRequestDispatcher("UserLogin.jsp");
				rd.forward(request, response);
				
			}
			
	        
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}





	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
