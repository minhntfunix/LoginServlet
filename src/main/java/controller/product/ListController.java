package controller.product;

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

import dao.ListProductDAO;
import model.Product;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/index.jsp")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter out= response.getWriter();
			
			int count= new ListProductDAO().count("");
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
			List<Product> ls= new ListProductDAO().pagedivide("",indexPage,pageSize);
			request.setAttribute("end",endPage);
			request.setAttribute("products", ls);
			RequestDispatcher rd= request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		} catch (Exception ex) {
			Logger.getLogger(ListController.class.getName()).log(Level.SEVERE,null,ex);
		}
		
	}
    
    
    
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
