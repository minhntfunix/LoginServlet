package context;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Connect
 */
@WebServlet("/Connect")
public class Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String serverName="DESKTOP-G5NDJT3";
	private final String dbName= "ShoppingDB";
	private final String portNumber= "1433";
	private final String instance="";
	private final String userID="sa";
	private final String password= "minhphuong";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="jdbc:sqlserver://"+serverName+":"+portNumber+"\\"+instance+";databaseName="+ dbName;
		if(instance ==null || instance.trim().isEmpty()) {
			url= "jdbc:sqlserver://" + serverName+":"+portNumber+";databaseName="+ dbName;
		}
		
		PrintWriter out= response.getWriter();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			out.println("Can't load the driver");
			return;
		}
		
		
		Connection conn= null;
		
		try {
			conn=DriverManager.getConnection(url,userID,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("Can't connect to database");	
			return;
					
		}
		
		out.println(" Connected to database");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
