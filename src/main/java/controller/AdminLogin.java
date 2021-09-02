package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import context.DBContext;

import java.sql.*;
import model.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Loginform")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource ds;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		try {
//			InitialContext initcontext = new InitialContext();
//			Context env = (Context) initcontext.lookup("java:comp/env");
//			ds = (DataSource) env.lookup("jdbc/ShoppingDB");
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			throw new ServletException();
//		}
//	}
//
///**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//		  
//		  
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		  
//		Connection conn = null;
//
//		try {
//			conn = ds.getConnection();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		PrintWriter out = response.getWriter();
//		out.println("Connected to database");
//	}
//		  
//		 
//		  
//		  
//		  
//		
		  
		/*  @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		  response)*/
		 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.setContentType("text/html; charset=UTF-8");
		// request.setCharacterEncoding("UTF-8");
		Connection conn = null;		
		

		try {
			conn = new DBContext().getConnection();
			request.getSession(true).invalidate();
			String regexEmail = "^[A-Z0-9_a-z]+@[A-Z0-9_a-z]+\\.[A-Za-z]{2,6}$";
			String regexPass = "[A-Z0-9a-z]+";
			
			String emailGetFromForm = request.getParameter("username");
			String passGetFromForm = request.getParameter("pass");
			String remember = request.getParameter("remember");
			// Account acc= new Account();
			// acc.setUser(emailGetFromForm);
			// acc.setPwd(passGetFromForm);
			HttpSession session = request.getSession();
			if (!passGetFromForm.matches(regexPass) || !emailGetFromForm.matches(regexEmail)) {
				session.setAttribute("error", "invalid syntax");
				response.sendRedirect("AdminLogin.jsp");
				return;
			}
				
			String emailGetFromXML = getServletContext().getInitParameter("username");
			String passGetFromXML = getServletContext().getInitParameter("password");
			//Account acc= new Account(conn);	
			if (emailGetFromXML.equals(emailGetFromForm) && passGetFromXML.equals(passGetFromForm)) {

				session.setAttribute("user", emailGetFromForm);

				Cookie cookieEmail = new Cookie("cEmail", emailGetFromForm);
				Cookie cookiePass = new Cookie("cPass", passGetFromForm);
				Cookie cookRemember = new Cookie("cRemem", remember);

				response.addCookie(cookieEmail);
				response.addCookie(cookiePass);
				response.addCookie(cookRemember);
				response.sendRedirect("Admin/dashboard.jsp");
			} else {
				session.setAttribute("error", "wrong username or password");
				response.sendRedirect("AdminLogin.jsp");
			}

		} catch (NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			response.getWriter().println(e);
		}
		
	
	}

}
