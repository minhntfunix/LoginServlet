package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import dao.OrdersDAO;
import model.Cart;
import model.Orders;

/**
 * Servlet implementation class PayController
 */
@WebServlet("/Confirm")
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
	
		try {
			HttpSession session= request.getSession(true);
			if (session.getAttribute("username") ==null) {
				response.sendRedirect("UserLogin.jsp");
			} else if (session.getAttribute("cart") == null) {				
				response.sendRedirect("Cart.jsp");
			} else {
			
			
			OrdersDAO dao= new OrdersDAO();
			
			Cart c= (Cart) session.getAttribute("cart");
			String username= (String) session.getAttribute("username");
//			if (!username.equals(session.getAttribute("username"))) {
//				session.
//				
//				
//			}
			
			
			String discount= request.getParameter("discount");
			String address= request.getParameter("address");
			
			
			Orders d= new Orders(username,2,discount,address,"",null);
			dao.insertOrder(d, c);
			session.setAttribute("message","You have successfully place the order");
			session.removeAttribute("cart");
			
			
			response.sendRedirect("index.jsp");
			}
			
		} catch (Exception e) {
			response.getWriter().println(e);
			e.printStackTrace();
		}
		
	}

	
	protected void Checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.sendRedirect("UserLogin.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
