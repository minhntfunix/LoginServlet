package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
import dao.ListProductDAO;
import model.Product;

/**
 * Servlet implementation class SearchController2
 */
@WebServlet("/SearchController2")
public class SearchController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController2() {
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
				PrintWriter out= response.getWriter();
				String search= request.getParameter("s");
				int count= new ListProductDAO().count(search);
				int pageSize= 6;
				int endPage=0;
				endPage= count /pageSize;
				if (count % pageSize !=0) {
					endPage++;
				}
				int indexPage;
				String indexString= request.getParameter("index");
				if (indexString == null) {
					indexPage=1;
				}else {
					indexPage= Integer.parseInt(indexString);
				}
				List<Product> ls= new ListProductDAO().pagedivide(search,indexPage,pageSize);
				request.setAttribute("end",endPage);
				request.setAttribute("products", ls);
				RequestDispatcher rd= request.getRequestDispatcher("search.jsp");
				rd.forward(request, response);
			} catch (Exception ex) {
				Logger.getLogger(ListController.class.getName()).log(Level.SEVERE,null,ex);
				response.getWriter().println(ex);
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
