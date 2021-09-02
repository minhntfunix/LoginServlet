package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class AddtoCartController
 */

//Controller của chức năng thêm một sản phẩm vào giỏ hàng
@WebServlet("/AddtoCart")
public class AddtoCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	public AddtoCartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		try {
			
			
			HttpSession session= request.getSession();
			if (session.getAttribute("username") ==null) {
				response.sendRedirect("UserLogin.jsp");
				return;
			}
			
			String idd= request.getParameter("id");
			String action= request.getParameter("action");
			if (action!=null && action.equalsIgnoreCase("add")) {
				if (session.getAttribute("cart") == null) {
					session.setAttribute("cart", new Cart());
					
				}
				
				int id= Integer.parseInt(idd);
				Product p= new ListProductDAO().getProduct(id);
				Cart c= (Cart) session.getAttribute("cart");
				c.add(new Product (p.getId(),
									p.getName(),
									p.getDescription(),
									p.getPrice(),
									p.getSrc(),
									p.getType(),
									p.getBrand(),1  ));
				session.setAttribute("message","Item successfully added");			
					
				
						
			}else if (action!=null && action.equalsIgnoreCase("delete")) {
				int id= Integer.parseInt(idd);
				Cart c= (Cart) session.getAttribute("cart");
				session.setAttribute("message","Item successfully removed");
				c.remove(id);
				
				
				
			}else if (action!=null && action.equalsIgnoreCase("update")) {
				int id= Integer.parseInt(idd);
				String quant= request.getParameter("quantity");
				int number= Integer.parseInt(quant);
				Cart c= (Cart) session.getAttribute("cart");
				Product p= c.getProduct(id);
				p.setNumber(number);
				session.setAttribute("message","Item successfully updated");		
				
				
			}
			response.sendRedirect("Cart.jsp");
		}catch (Exception e) {
			response.getWriter().println(e);
		}
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
