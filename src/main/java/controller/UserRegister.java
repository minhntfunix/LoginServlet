package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.product.ListController;
import model.*
;
import dao.*;
/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String regexEmail = "^[A-Z0-9_a-z]+@[A-Z0-9_a-z]+\\.[A-Za-z\\.]{2,6}$";
		String regexPass = "[A-Z0-9a-z]+";
		try {
    	String email=request.getParameter("email");
		String password=request.getParameter("psw");
		String passRepeat=request.getParameter("psw-repeat");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		
		
		Account acc= new Account(email,password,1,name,address,phone);

		UserRegisterDAO dao= new UserRegisterDAO();
		
		if (!password.matches(regexPass) || !email.matches(regexEmail)) {
			response.getWriter().println("invalid format");
			RequestDispatcher rd= request.getRequestDispatcher("Register.jsp");
			rd.include(request, response);
	
			return;
		}else if (dao.exist (acc)){
			response.getWriter().println("Account with that email already exists");
			RequestDispatcher rd= request.getRequestDispatcher("Register.jsp");
			rd.include(request,response);
			return;
		}else if(!passRepeat.equals(password)) {
			response.getWriter().println("Repeat Password must match");
			RequestDispatcher rd= request.getRequestDispatcher("Register.jsp");
			rd.include(request,response);
			return;
		}else {
			
			dao.insert(acc);
			HttpSession session= request.getSession(true);
			response.getWriter().println("Account created");
			session.setAttribute("username",acc.getEmail());
			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
			rd.include(request,response);
			return;
		}
		}catch (Exception ex) {
			Logger.getLogger(ListController.class.getName()).log(Level.SEVERE,null,ex);
			response.getWriter().println(ex);
		}
		
		
		
		
		
		
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
		
	}

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

}
